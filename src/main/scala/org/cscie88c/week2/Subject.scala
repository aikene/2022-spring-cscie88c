package org.cscie88c.week2

import org.cscie88c.week2.Student.allStudents

// complete the definition of the Subject case class and companion object
final case class Subject(
  id: Int,
  name: String,
  isStem: String
)

object Subject {

  def apply(csvRow: String): Subject = {
  val fields = csvRow.split(",")
    Subject(
      id = fields(0).toInt,
      name = fields(1),
      isStem = fields(2)
    )
  } 

  val allSubjects: List[Subject] =
    List(
    "1,History102,false",
    "2,History204,false",
    "3,Math,true",
    "4,Physics,true"
  ).map(Subject(_))


  def stemSubjects: List[Subject] = allSubjects.filter(_.isStem)
  
}