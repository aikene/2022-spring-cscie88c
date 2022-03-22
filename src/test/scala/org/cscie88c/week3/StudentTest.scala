package org.cscie88c.week3

import org.cscie88c.testutils.{ StandardTest }

class StudentTest extends StandardTest {
  var ts1: Student = new Student("AJ", "ikene@gmail.com","Math",87)
  var ts2: Student = new Student("Matthew", "invalid","Social Studies",70)
  var ts3: Student = new Student("Aaron", "donald@gmail.com","Math",99)
  var ts4: Student = new Student("Aaron", "donald@gmail.com","Social Studeies",99)
  var ts5: Student = new Student("AJ", "ikene@gmail.com","Social Studies",78)

  var ajList: List[Student] = List(ts1, ts2, ts5)
  var aaronList: List[Student] = List(ts3, ts4)
  var compList: List[Student] = List(ts1, ts2, ts3, ts4, ts5)


  "Student Management System" when {
    "creating a student" should {
      "have properties - name, email, subject and score" in {
        val studentPropertyCheck = Student.apply("Name","email@email.com","subject",100)
        studentPropertyCheck.name should not be (null)
        studentPropertyCheck.email should not be (null)
        studentPropertyCheck.subject should not be (null)
        studentPropertyCheck.score should be (100) 
      }
    }
    "calculating average score" should {
      "have an average of 99 for Aaron" in {
        val actualResult = Student.averageScoreByStudent(ts3, compList)
        actualResult should be (99)
      }
      "have an average of 82.5 for AJ" in {
        val actualResult = Student.averageScoreByStudent(ts1, compList)
        actualResult should be (82.5)
      }
    }
    "calculating average score for class" should {
      "have an average of 74 for Social Studies" in {
        val actualResult = Student.averageScoreBySubject("Social Studies", compList)
        actualResult should be (74)
      }
      "have an average of 93 for Math" in {
        val actualResult = Student.averageScoreBySubject("Math", compList)
        actualResult should be (93)
      }
    }

  }

}
