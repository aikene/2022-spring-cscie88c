package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class ListUtilsTest extends StandardTest {
  "ListUtils" when {
    "calling ones" should {
      "return the correct value" in {
        ListUtils.ones(9).sum should equal(9.0)
      }
    }
    "calling zeros" should {
      "return the correct value" in {
        ListUtils.zeros(99).sum should equal(0.0)
      }
    }
    "calling charCounts with 'Hello world'" should {
      "return the correct Map" in {
        val expectedMap = Map('e' -> 1, 'l' -> 3, 'H' -> 1, 'w' -> 1, 'r' -> 1, 'o' -> 2, 'd' -> 1)
        val map1 = Map(1 -> "one", 2 -> "two", 3 -> "three")
        val actualMap = ListUtils.charCounts("Hello world")
        expectedMap should equal (actualMap)
      }
    }
    "calling charCounts with a pangram" should {
      "return all of the letters in the alphabet" in {
        val alphabet = ('a' to 'z').toSeq
        val actualMapAsSortedLowerCaseSeq = ListUtils.charCounts("The quick brown fox jumps over the lazy dog").keys.map(_.toLower).toSeq.sorted
        actualMapAsSortedLowerCaseSeq should be(alphabet)
      }
    }
    "calling top N with 2" should {
      "return the values 'l' and 'o' " in {
        val actualMap = ListUtils.charCounts("Hello world")
        val actualFreq = ListUtils.topN(2)(actualMap)
        val expectedFreq = Map('l' -> 3, 'o' -> 2)
        expectedFreq should equal(actualFreq)
      }
    }
  }

}
