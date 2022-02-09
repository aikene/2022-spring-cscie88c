package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Administrator below
class AdministratorTest extends StandardTest {

    var administrator1: Administrator = new Administrator("James Henry","admin1@gmail.com","$1500800");
    var administrator2: Administrator = new Administrator("Henry James","admin2@gmail.com","$21004000");
    
    "Administrator" when {
        "description" should {
        "match Administrator 1" in {
            administrator1.description should be ("Name: James Henry, Email: admin1@gmail.com, Budget: $1500800")
        }
        "match Administrator 2" in {
            administrator2.description should be ("Name: Henry James, Email: admin2@gmail.com, Budget: $21004000")
        }      
        }
  }
  
}
