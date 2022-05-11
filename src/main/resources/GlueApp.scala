import com.amazonaws.services.glue.GlueContext
import com.amazonaws.services.glue.MappingSpec
import com.amazonaws.services.glue.errors.CallSite
import com.amazonaws.services.glue.util.GlueArgParser
import com.amazonaws.services.glue.util.Job
import com.amazonaws.services.glue.util.JsonOptions
import org.apache.spark.SparkContext
import scala.collection.JavaConverters._
import com.amazonaws.services.glue.DynamicFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame}

object GlueApp {
  def main(sysArgs: Array[String]) {
    val spark: SparkContext = new SparkContext()

    val glueContext: GlueContext = new GlueContext(spark)

    // @params: [JOB_NAME]
    val args = GlueArgParser.getResolvedOptions(sysArgs, Seq("JOB_NAME").toArray)
    Job.init(args("JOB_NAME"), glueContext, args.asJava)


    val S3bucket_node1 = glueContext.getSourceWithFormat(
      formatOptions=JsonOptions("""{"quoteChar":"","escaper":"","withHeader":true,"optimizePerformance":false,"separator":"," , "multiline": false}"""),
      connectionType="s3",
      format="csv",
      options=JsonOptions("""{"paths": ["s3://aws-demo-ingestion-bucket/nba-data/temp_data/2544.csv"],"recurse":true}"""), transformationContext="S3bucket_node1").getDynamicFrame()

    val dataframe = S3bucket_node1.toDF()
    dataframe.printSchema()

    val advancedDataframe = addAdvancedStats(dataframe)

    dataframe
      .write
      .mode("overwrite")
      .partitionBy("SEASON_ID")
      .parquet("s3://aws-demo-refined-bucket/glue-nba-data/")

    Job.commit()
  }
  def addAdvancedStats(dataFrame: DataFrame): DataFrame = {
    dataFrame
      .withColumn("eFG_PCT", round( (col("FG3M") * 0.5 + col("FGM")) / col("FGA") ,3) )
      .withColumn("AST_TO", round(col("AST") / col("TOV"),2))
      .withColumn("TSA", round((col("FGA") + (col("FTA") * 0.44)) * 2, 2))
      .withColumn("TSP", round(col("PTS") / col("TSA"),3))
  }
}