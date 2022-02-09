package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}
import org.cscie88c.week2.{UniversityEmployee}

// write unit tests for University employee below
class UniversityEmployeeTest extends StandardTest {

  var employee1: UniversityEmployee = new UniversityEmployee("AJ Student","aj@gmail.com");
  var employee2: UniversityEmployee = new UniversityEmployee("Jack Reacher","jack_reacher@gmail.com");


  "UniversityEmployee" when {
    "instantiated" should {
      "have a name property" in {
        employee1.name should not be (null)
        employee2.name should not be (null)
      }
      "have an email property" in {
        employee1.email should not be (null)
        employee2.email should not be (null)
      }
    }
    "description" should {
      "match employee 1" in {
        employee1.description should be ("Name: AJ Student, Email: aj@gmail.com")
      }
      "match employee 2" in {
        employee2.description should be ("Name: Jack Reacher, Email: jack_reacher@gmail.com")
      }      
    }
  }
}
