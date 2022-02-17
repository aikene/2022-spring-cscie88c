package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}
import math._

class TrigUtilsTest extends StandardTest {
  
  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 90" in {
        val sinValue: Double = TrigUtils.sinDegrees(90)
        val expectedSinValue: Double = sin(90) 
        sinValue should equal(expectedSinValue)
      }
      "return the correct value for 0" in {
        val sinValue: Double = TrigUtils.sinDegrees(0)
        val expectedSinValue: Double = sin(0) 
        sinValue should equal(expectedSinValue)
      }    
    }
    "calling cos" should {
      "return the correct value for 90" in {
        val cosValue: Double = TrigUtils.cosDegrees(90)
        val expectedCosValue: Double = cos(90) 
        cosValue should equal(expectedCosValue)
      }
      "return the correct value for 0" in {
        val cosValue: Double = TrigUtils.cosDegrees(0)
        val expectedCosValue: Double = cos(0) 
        cosValue should equal(expectedCosValue)
      }       
    }
    "calling squared" should {
      "return the correct value for 100" in {
        val squaredValue: Double = TrigUtils.squared(100)
        val expectedSquaredValue: Double = 100*100
        squaredValue should equal(expectedSquaredValue)
      }       
    }
  }
}
