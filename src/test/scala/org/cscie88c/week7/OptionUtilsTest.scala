package org.cscie88c.week7

import org.cscie88c.testutils.StandardTest

import java.io.FileNotFoundException
import scala.util
import scala.util.{Failure, Success, Try}

class OptionUtilsTest extends StandardTest {
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        OptionUtils.fileCharCount("src/test/resources/data/dirty-retail-data-sample.csv").get should be (195)
      }
    }
    "calling charCountAsString" should {
      "return the correct number of characters as a string" in {
        OptionUtils.charCountAsString("src/test/resources/data/dirty-retail-data-sample.csv") should
          be("number of characters: 195")
      }
      "return an error when file does not exist" in {
        OptionUtils.charCountAsString("src/test/resources/data/dirty-retail-data-sample.csv-x") should be("error opening file")
//        OptionUtils.charCountAsString("src/test/resources/data/dirty-retail-data-sample.csv-x") shouldBe a [Failure[FileNotFoundException]]
      }
    }

  }

}
