package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for white" in {
        val whiteRGB = FunctionUtils.colorToCode("White")
        whiteRGB should be ((255,255,255))
      }
      "return the correct value for lime" in {
        val whiteRGB = FunctionUtils.colorToCode("lime")
        whiteRGB should be ((0,255,0))
      }
    }

    "calling fizzBuzzString" should {
      "return the correct value for 15" in {
        val fizzBuzzString = FunctionUtils.fizzBuzzString(15)
        fizzBuzzString should be("FizzBuzz")
      }
      "return the correct value for 3" in {
        val fizzBuzzString = FunctionUtils.fizzBuzzString(3)
        fizzBuzzString should be("Fizz")
      }
      "return the correct value for 5" in {
        val fizzBuzzString = FunctionUtils.fizzBuzzString(5)
        fizzBuzzString should be("Buzz")
      }
      "return the correct value for 17" in {
        val fizzBuzzString = FunctionUtils.fizzBuzzString(17)
        fizzBuzzString should be("17")
      }
    }

    "calling fizzBuzz" should {
      "return the correct value" in {
        // write unit tests here
      }
    }
    
    // Problem 2 unit tests
    "calling isDefinedAt for tanDegrees" should {
      "return false for 90" in {
        val expectedBool = FunctionUtils.tanDegrees.isDefinedAt(90)
        expectedBool should be(false)
      }
      "return false for -90" in {
        val expectedBool = FunctionUtils.tanDegrees.isDefinedAt(-90)
        expectedBool should be(false)
      }
    }
    "calling high transactions" should {
      "return correct sum for list of transactions" in {
        val cs1 = CustomerTransaction("string","date", 1)
        val cs2 = CustomerTransaction("string","date", 101)
        val cs3 = CustomerTransaction("string","date", 200)

        val expectedAmount = FunctionUtils.totalHighValueTransactions(List(cs1, cs2, cs3))
        expectedAmount should be (301)
      }
    }

    // Problem 3 unit tests
    "calling flip2" should {
      "flip the values of a binary function" in {
        val expectedPower = FunctionUtils.flip2(math.pow)(5,2)
        expectedPower should be (32.0)
      }
    }

    "calling sample list should only return 5 values" should {
      "with a list of strings" in {
        val los = List("I","am","a","list","of...","strings")
        FunctionUtils.sampleList(los) should be (los.take(5))
      }
      "with a list of integers" in {
        val loi = List(1,2,3,4,5,6,7,8)
        FunctionUtils.sampleList(loi) should be (loi.take(5))
      }
    }

    // Bonus unit tests
  }

}
