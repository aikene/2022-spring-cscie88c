package org.cscie88c.`final`

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
import org.cscie88c.config.ConfigUtils
import org.cscie88c.utils.SparkUtils
import org.apache.spark.sql.functions._
import pureconfig.generic.auto._

import java.util.{Calendar, UUID}

case class FinalProjectConfig(name: String, masterUrl: String, file: String, outputLocation: String)

// run with: sbt "runMain org.cscie88c.final.SparkFinalProject"
object SparkFinalProject {

  def main(args: Array[String]): Unit = {
    // Standard spark Setup
    implicit val conf: FinalProjectConfig = readConfig()
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)

    setAWSCredentials(spark)
    val dataframe = loadData(spark)
    printFirstRowOfData(dataframe)
    val dataframeWithAdvancedStats = addAdvancedStats(dataframe)
    loadDataToS3AsParquet(spark, dataframeWithAdvancedStats)

    // Standard Spark shutdown
    spark.stop()
  }

  def readConfig(): FinalProjectConfig = ConfigUtils.loadAppConfig[FinalProjectConfig]("org.cscie88c.final-project")

  def getDateAsString(): String = {
    val now = Calendar.getInstance()
    val uuid: String = UUID.randomUUID.toString
    s"${now.get(Calendar.YEAR)}/${now.get(Calendar.MONTH)+1}/${now.get(Calendar.DATE)}/$uuid"
  }

  def loadData(spark: SparkSession)(implicit conf: FinalProjectConfig): DataFrame = {
    spark
      .read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(conf.file)
  }

  def addAdvancedStats(dataFrame: DataFrame)(implicit conf: FinalProjectConfig): DataFrame = {
    dataFrame
      .withColumn("eFG_PCT", round( (col("FG3M") * 0.5 + col("FGM")) / col("FGA") ,3) )
      .withColumn("AST_TO", round(col("AST") / col("TOV"),2))
      .withColumn("TSA", round((col("FGA") + (col("FTA") * 0.44)) * 2, 2))
      .withColumn("TSP", round(col("PTS") / col("TSA"),3))
  }

  def loadDataToS3AsParquet(spark: SparkSession, dataFrame: DataFrame)(implicit conf: FinalProjectConfig): Unit = {
    // Necessary for Docker
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider")

    dataFrame
      .write
      .mode(SaveMode.Overwrite)
      .parquet(conf.outputLocation)
    print(s"***** S3 Bucket Location: ${conf.outputLocation} *****")
  }

  def printFirstRowOfData(dataframe: DataFrame): Unit = {
    dataframe.show(numRows = 1, truncate = false)
    dataframe.printSchema()
  }

  def setAWSCredentials(spark: SparkSession): Unit = {
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "<OBFUSCATED>")
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "<OBFUSCATED>")
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.endpoint", "s3.amazonaws.com")
  }

}


