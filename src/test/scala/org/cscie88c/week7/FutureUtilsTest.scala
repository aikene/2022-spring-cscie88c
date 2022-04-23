package org.cscie88c.week7

import org.cscie88c.testutils.FuturesTest

import scala.concurrent.Future
import scala.util.Random

class FutureUtilsTest extends FuturesTest {
  
  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling creditScoreAPI" should {
      "return a credit score greater than 300" in {
        // add unit tests below
        FutureUtils.creditScoreAPI(9).map(x => x should (be > 300 and be < 800) )
      }
    }
    "calling futureFactorial with a value of 4" should {
      "should return 24" in {
        // add unit tests below
        FutureUtils.futureFactorial(4).map(x => x should be (24) )
      }
    }
    "calling futurePermutations with a value of 3 and 3" should {
      "should return 6" in {
        // add unit tests below
        FutureUtils.futurePermuations(3,3).map(x => x should be (6) )
      }
    }
    "calling asyncAverageCreditScore" should {
      "should return an average between 200 and 800" in {
        // add unit tests below
        val rnd = new Random()
        val randomInts = LazyList.continually(rnd.between(300, 800)).take(5).toList
        FutureUtils.asyncAverageCreditScore(randomInts).map(x => x should (be > 300.0 and be < 800.0))
      }
    }
  }
}
