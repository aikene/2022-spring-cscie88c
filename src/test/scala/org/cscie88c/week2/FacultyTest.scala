package org.cscie88c.week2

import org.cscie88c.testutils.{ StandardTest }

// write unit tests for Faculty below
class FacultyTest extends StandardTest {

    var faculty1: Faculty = new Faculty("Malcom Zieto","malcom.zieto@gmail.com","History101");
    var faculty2: Faculty = new Faculty("Zieto Malcom","zieto.malcom@gmail.com","History204");

    "Faculty" when {
        "description" should {
        "match faculty 1" in {
            faculty1.description should be ("Name: Malcom Zieto, Email: malcom.zieto@gmail.com, Course: History101")
        }
        "match faculty 2" in {
            faculty2.description should be ("Name: Zieto Malcom, Email: zieto.malcom@gmail.com, Course: History204")
        }
        }
  }

}
