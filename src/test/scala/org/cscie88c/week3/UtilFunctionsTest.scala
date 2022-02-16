package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }

class UtilFunctionsTest extends StandardTest {
  "UtilFunctions" when {

    val tup1 = UtilFunctions.pythTriplesUpto100(1)
    val tup2 = UtilFunctions.pythTriplesUpto100(50)
    val tup3 = UtilFunctions.pythTriplesUpto100(100)

    "with pythTriplesUpto100" should {
      "verify elements in list 1 are pythagorean triples" in {
        // write your test here
        val bs: Boolean = UtilFunctions.pythTest(x = tup1._1, y = tup1._2, z = tup1._3)
        bs shouldBe true
      }
      "verify elements in list 2 are pythagorean triples" in {
        // write your test here
        val bs: Boolean = UtilFunctions.pythTest(x = tup2._1, y = tup2._2, z = tup2._3)
        bs shouldBe true
      }
      "verify elements in list 3 are pythagorean triples" in {
        // write your test here
        val bs: Boolean = UtilFunctions.pythTest(x = tup3._1, y = tup3._2, z = tup3._3)
        bs shouldBe true
      }
    }
  }
}
