package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Student below

class StudentTest extends StandardTest {
 "Student Test Class" when {
  "executed" should {
    "DO SOMETHING" in {
      val expectedResult = List("1,Emmy,Conrart,econrart0@gizmodo.com,Male,China").map(Student(_))
      val applyResult = Student.apply("1,Emmy,Conrart,econrart0@gizmodo.com,Male,China")
      applyResult.id shouldBe (expectedResult(0).id)
    }
  }
 }
  
}
