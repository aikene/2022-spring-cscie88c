package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class FunctionUtilsTest extends StandardTest {

   "FunctionUtils" when {
    "calling applyNtimes" should {
      "return 6" in {
        def add2(x: Int) = x + 2
        val actualValue = FunctionUtils.applyNtimes(3)(0)(add2)
        actualValue should equal(6)
      }
    }
      "calling myDeferred Function" should {
        "return valid log statement" in {
          def add5(x: Int) = x + 5
          val myDeferredFunction = FunctionUtils.deferredExecutor("CPU Pool")(add5)
          val result = myDeferredFunction(4)
          result should equal(9)
        }
    }
  }
}

