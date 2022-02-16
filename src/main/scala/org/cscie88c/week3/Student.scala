package org.cscie88c.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
  ) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {

  def validateEmail(student: Student): Boolean = {
    student.email.contains("@")
  }

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
    ): Double = {
      var total = 0.0;
      var counter = 0;
      for ( student <- studentList if student.subject.contains(subject)) {
        total += student.score;
        counter += 1
      }

      return total/counter
    }

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
    ): Double = {
      var total = 0.0;
      var counter = 0;
      for ( stu <- studentList if stu.name.contains(student.name)) {
        total += stu.score
        counter += 1
      }
      return total/counter
    }
}