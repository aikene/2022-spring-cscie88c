package org.cscie88c.week2

// complete the definition of the Student case class and companion object
final case class Student(
  id: Int,
  firstName: String,
  lastname: String,
  email: String,
  gender: String,
  country: String
)

object Student {
  
  def apply(csvRow: String): Student = {
    val fields = csvRow.split(",")
    Student(
      id = fields(0).toInt,
      firstName = fields(1),
      lastname = fields(2),
      email = fields(3),
      gender = fields(4),
      country = fields(5)
    )
  }
  
  val allStudents: List[Student] = {
    List(
    "1,Emmy,Conrart,econrart0@gizmodo.com,Male,China",
    "2,Marin,Blasono,mblasomi1@edublogs.org,Female,United States",
    "3,Jesse,Chismon,jchismon2@hostgator.com,Male,China",
    "4,Delmore,Scriver,dscriver3@boston.com,Male,United States",
    "5,Jocelyn,Blaxlande,jblaxlande.europa.eu,Female,China",
   ).map(Student(_))
  }

  def studentNamesByCountry(country: String): List[String] = ???
    // allStudents.filter(x => x.country == country)
    // for (student <- allStudents) { student.country }

  def studentTotalsByCountry(country: String): Int = ???
  
}