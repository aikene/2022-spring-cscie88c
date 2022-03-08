package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class EmployeeTest extends StandardTest {
  "Employee" should {
    val emp1 = Employee("Ben",24,100000)
    val emp2 = Employee("AJ",28,400000)
    val emp3 = Employee("Micah",30,30000)
    val listOfEmployees = emp1 :: emp2 :: emp3 :: Nil
 
    "have a default sort order" in {
      val expectedValue = List(emp1, emp2, emp3).sorted
      expectedValue.head should equal(emp2)
    }

    "sort employees by salary" in {
      // write unit tests here
      val lowSalarySort = Employee.sortEmployeesBySalary(listOfEmployees)
      lowSalarySort.head should equal(emp3)
    }
  }
}
