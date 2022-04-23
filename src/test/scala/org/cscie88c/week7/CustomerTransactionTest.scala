package org.cscie88c.week7

import org.cscie88c.testutils.StandardTest

import scala.util.{Failure, Success, Try}

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "load and clean raw CSV data file" in {
      // add unit tests below
      CustomerTransaction.apply("id1,cus1,0.0") should be(Some(CustomerTransaction("id1","cus1",0.0)))
    }
    "return None when bad data is entered" in {
      // add unit tests below
      CustomerTransaction.apply("id1,cus1,0.0x") should be(None)
    }
    "load and clean data from a CSV DATA FILE" in {
      val validCustomers = CustomerTransaction.readFromCSVFile("src/test/resources/data/dirty-retail-data-sample.csv")
      validCustomers.length should be(5)
      validCustomers(0) should be(CustomerTransaction("CS5295","11-Feb-13",35.0))
    }
  }
}
