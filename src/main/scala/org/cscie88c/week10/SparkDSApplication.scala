package org.cscie88c.week10

import org.apache.spark.sql.SparkSession
import com.typesafe.scalalogging.{LazyLogging}
import org.cscie88c.config.{ConfigUtils}
import org.cscie88c.utils.{SparkUtils}
import org.apache.spark.sql.{Dataset}
import pureconfig.generic.auto._

// write config case class below
 case class SparkDSConfig(name: String, masterUrl: String, transactionFile: String)

// run with: sbt "runMain org.cscie88c.week10.SparkDSApplication"
object SparkDSApplication {

  // application main entry point
  def main(args: Array[String]): Unit = {
    implicit val conf:SparkDSConfig = readConfig()
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)
    val transactionDS = loadData(spark)
    val totalsByCategoryDS = transactionTotalsByCategory(spark,transactionDS)
    printTransactionTotalsByCategory(totalsByCategoryDS)
    spark.stop()
  }

  def readConfig(): SparkDSConfig = ConfigUtils.loadAppConfig[SparkDSConfig]("org.cscie88c.spark-ds-application")
  
  def loadData(spark: SparkSession)(implicit conf: SparkDSConfig): Dataset[CustomerTransaction] = {
    import spark.implicits._
    val file = conf.transactionFile
    spark.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(file)
      .as[RawTransaction]
      .map(CustomerTransaction(_))
  }

  def transactionTotalsByCategory(spark: SparkSession, transactions: Dataset[CustomerTransaction]): Dataset[(String, Double)] = {
    import spark.implicits._
    transactions.groupByKey(_.transactionCategory).mapValues(_.transactionAmount).reduceGroups((a,b) => a+b)
  }

  def printTransactionTotalsByCategory(ds: Dataset[(String, Double)]): Unit = ds.foreach(println)
}
