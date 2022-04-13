package org.cscie88c.week11

import cats._
import cats.implicits._
import org.apache.spark.sql.{Dataset, SparkSession}

final case class WritableRow(
  customerId: String,
  averageAmount: Double
)

final case class AverageTransactionAggregate(
  customerId: String,
  totalAmount: Double,
  count: Long
) {
  def averageAmount: Double = totalAmount / count
}


object AverageTransactionAggregate {
  def apply(raw: RawTransaction): AverageTransactionAggregate = {
    AverageTransactionAggregate(raw.customer_id, raw.tran_amount, 1)
  }

  implicit val averageTransactionMonoid: Monoid[AverageTransactionAggregate] = new Monoid[AverageTransactionAggregate] {
    override def empty: AverageTransactionAggregate = AverageTransactionAggregate("",0,0)

    override def combine(x: AverageTransactionAggregate, y: AverageTransactionAggregate): AverageTransactionAggregate = {
      AverageTransactionAggregate(
        if (x.customerId.isEmpty) y.customerId else x.customerId,
        x.totalAmount + y.totalAmount,
        x.count + y.count
      )
    }
  }
  def aggregateDataWithMonoid(transactionDS: Dataset[RawTransaction]): Map[String,AverageTransactionAggregate] = {
    import transactionDS.sparkSession.implicits._
    transactionDS
      .map{ trans =>
        Map(trans.customer_id -> AverageTransactionAggregate(trans))
      }
      .reduce(_ |+| _)
  }

  def saveAverageTransactionByCustomerId(spark: SparkSession, transactionsById: Map[String,AverageTransactionAggregate], path: String): Unit = {
    import spark.implicits._
//    val outputDs: WritableRow = transactionsById.asInstanceOf[WritableRow]
    val outputDs = transactionsById.map {
      case (trans) =>
        WritableRow(trans._1, trans._2.averageAmount)
    }.toSeq.toDF()

    outputDs.coalesce(1)
      .write
      .format("csv")
      .option("header","true")
      .mode("overwrite")
      .save(path)


  }

}

