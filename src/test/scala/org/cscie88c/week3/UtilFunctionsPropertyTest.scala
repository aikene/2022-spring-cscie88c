package org.cscie88c.week3

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class UtilFunctionsPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {
  
  val triplesGen: Gen[(Int, Int, Int)] = Gen.oneOf(UtilFunctions.pythTriplesUpto100)

  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }

  test("verify distributive property of multiplication is true in mult2") {
  val distributiveProperty = Prop.forAll {(a: Int, b:Int, c:Int) =>
    UtilFunctions.mult2(a,(b+c)) == UtilFunctions.mult2(a,b) + UtilFunctions.mult2(a,c)
  }
    distributiveProperty.check()
  }

  test("verify elements in randomly generated list are pythagorean triples") {
    forAll(triplesGen) {tup: (Int, Int, Int) => UtilFunctions.pythTest(x = tup._1, y = tup._2, z = tup._3) shouldBe true}
    forAll(triplesGen) {tup: (Int, Int, Int) => UtilFunctions.pythTest(x = tup._2, y = tup._1, z = tup._3) shouldBe true}
  }

  test("verify 2x, 2y, and 2z is a pythagorean triple") {
    forAll(triplesGen) {tup: (Int, Int, Int) => UtilFunctions.pythTest(x = tup._1, y = tup._2, z = tup._3) shouldBe true}
    forAll(triplesGen) {tup: (Int, Int, Int) => UtilFunctions.pythTest(x = 2*tup._1, y = 2*tup._2, z = 2*tup._3) shouldBe true}
  }
}
