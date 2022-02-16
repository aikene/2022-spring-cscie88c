package org.cscie88c.week3

object UtilFunctions {

  def mult2(x: Int, y: Int): Int = x * y

  def pythTest(
      x: Int,
      y: Int,
      z: Int
    ): Boolean = if ((x*x) + (y*y) == (z*z)) {
      true
    } else {
      false
    };

  val pythTriplesUpto100: List[(Int, Int, Int)] = for {
    i <- (1 to 100).toList
    j <- (1 to 100).toList
    k <- (1 to 100).toList
    if ((k*k) == ((i*i) + (j*j)))
  } yield (i,j,k)

}
