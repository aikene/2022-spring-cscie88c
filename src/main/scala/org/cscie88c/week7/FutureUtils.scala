package org.cscie88c.week7

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.collection.parallel.CollectionConverters._
import scala.concurrent.duration.{Duration, MILLISECONDS}

object FutureUtils {
  
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = {
    Future(rnd.between(300, 800))
  }

  def printCreditScore(applicantId: Int): Unit = {
    creditScoreAPI(applicantId).onComplete {
      case Success(creditScore) => println(s"The credit score for ${applicantId} is ${creditScore}")
      case Failure(e) => println(s"Cannot get credit score for ${applicantId} at this time")
    }
  }

  def passedCreditCheck(applicantId: Int): Future[Boolean] = {
    creditScoreAPI(applicantId).map(cs => cs > 600)
  }

  def futureFactorial(n: Int): Future[Int] = Future {
    (1 to n).foldLeft(1)(_*_)
  }

  def futurePermuations(n: Int, r: Int): Future[Int] = {
    for {
      numerator <- futureFactorial(n)
      denominator <-  futureFactorial(n-r)
    } yield numerator / denominator
  }

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = Future (idList.map(_.toDouble).sum / idList.length)

  def slowMultiplication(x: Long, y: Long): Long = ???

  def concurrentFactorial(n: Long): Long = ???

  def sequentialFactorial(n: Long): Long = ???

}
