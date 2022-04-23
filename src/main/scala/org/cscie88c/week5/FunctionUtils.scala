package org.cscie88c.week5

import scala.math

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = color.toLowerCase match {
    case "black" => (0,0,0)
    case "white" => (255,255,255)
    case "red" => (255,0,0)
    case "lime" => (0,255,0)
    case "blue" => (0,0,255)
    case "yellow" => (255,255,0)
  }

  def fizzBuzzString(n: Int): String = n match {
    case n if (n%3==0 & n%5==0) => "FizzBuzz"
    case n if (n%3==0) => "Fizz"
    case n if (n%5==0) => "Buzz"
    case _ => n.toString()
  }

  def fizzBuzz(n: Int): List[String] = {
    (1 to n).toList.map(fizzBuzzString)
  }

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    case x: Double if (x==90.0) & (x== (-90.0)) => math.tan(x)
  }

  def totalHighValueTransactions(transactionList: List[CustomerTransaction]): Double = {
    transactionList.collect({case t if t.transactionAmount >= 100 => t.transactionAmount}).sum
    // transactionList.map(_.transactionAmount).filter(_ >= 100).sum
  }

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C =  {
    (b: B, a: A) => f(a, b)
  }

  // Write a generic function sampleList parameterized by type A, that returns the first 5 elements of a list of type A.
  def sampleList[A](a: List[A]): List[A] = a.take(5)

  def deferredExecutor[A,B,C](f: (B) => C): (A,B) => C = ???  
}
