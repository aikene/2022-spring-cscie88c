package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Student below

class StudentTest extends StandardTest {

 "Student Test Class" when {
   val testData: List[Student] = List(
    "1,Emmy,Conrart,econrart0@gizmodo.com,Male,China",
    "2,Marin,Blasono,mblasomi1@edublogs.org,Female,United States",
    "3,Jesse,Chismon,jchismon2@hostgator.com,Male,China",
    "4,Delmore,Scriver,dscriver3@boston.com,Male,United States",
    "5,Jocelyn,Blaxlande,jblaxlande.europa.eu,Female,China",
   ).map(Student(_))

  "executed" should {
    "DO SOMETHING" in {
      val expectedResult = List("1,Emmy,Conrart,econrart0@gizmodo.com,Male,China").map(Student(_))
      val applyResult = Student.apply("1,Emmy,Conrart,econrart0@gizmodo.com,Male,China")
      applyResult.id shouldBe (expectedResult)
    }
  }
 }
  
}
