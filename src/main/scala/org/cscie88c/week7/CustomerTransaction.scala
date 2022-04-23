package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

final case class CustomerTransaction(
  customerId: String,
  transactionDate: String,
  transactionAmount: Double
)

object CustomerTransaction {
  // add companion object methods below
  def apply(csv: String): Option[CustomerTransaction] = Try {
    val Array(customerId, transactionDate, transactionAmount) = csv.split(",")
    CustomerTransaction(customerId.trim, transactionDate.trim, transactionAmount.trim.toDouble)
  }.toOption

  def readFromCSVFile(fileName: String): List[CustomerTransaction] = {
    Source.fromFile(fileName).getLines()
      .map(CustomerTransaction(_))
      .collect {case Some(emp) => emp }
      .toList
  }
}