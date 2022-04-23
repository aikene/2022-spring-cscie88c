package org.cscie88c.week4
import math._

object TrigUtils {

  // https://www.scala-lang.org/api/2.13.6/scala/math/index.html
  // use the function literal syntax for sin and cos
  val sinDegrees: Double => Double = (x: Double) => sin(x.toRadians)
  val cosDegrees: Double => Double = (x: Double) => cos(x.toRadians)

  // use the placeholder syntax for squared
  val squared: Double => Double = (x: Double) => x*x
  
}
