package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class AddableTypeclassTest extends StandardTest {
  
  "AddableAggregator" should {
    "sum a list of integers" in {
      val listOfInts = List(2,4,6,8)
      AddableAggregator.sumWithAddable(listOfInts) should be (20)
    }
    "sum a list of booleans" in {
      val listofBools = true :: false :: false :: Nil
      AddableAggregator.sumWithAddable(listofBools)  should be(true)
    }
    "sum a list of employees" in {
      // add your unit tests here
    }
  }
}
