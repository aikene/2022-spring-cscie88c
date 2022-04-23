package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

class UtilFunctionsTest extends StandardTest {
  
  "UtilFunctions" when {
    "maximum" should {
      "return maximum of two ints when first integer is greater" in {
        UtilFunctions.maximum(2, 1) should be (2)
      }
      // add more unit tests for maximum below
      "return maximum of two ints when second integer is greater" in {
        UtilFunctions.maximum(1,3) should be (3)
      }
    };

    // add unit tests for average below
    "average" should {
      "return the average of two ints" in {
        UtilFunctions.average(2, 1) should be (1.5)
      }
    };
    
  }
}
