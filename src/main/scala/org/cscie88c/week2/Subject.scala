package org.cscie88c.week2

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

  val allSubjects: List[Subject] = ???

  def stemSubjects: List[Subject] = ???
  
}//"1,Physics,true"