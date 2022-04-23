package org.cscie88c.week4
import scala.collection.immutable._

object ListUtils {
  // complete the function below
  def initDoubleList(initValue: Double)(size: Int): List[Double] = List.fill(size)(initValue)

  // complete the functions below using currying
  def ones: Int => List[Double] = initDoubleList(1) _
  def zeros: Int => List[Double] = initDoubleList(0) _

  // complete the functions below
  def charCounts(sentence: String): Map[Char, Int] = sentence.filterNot(_.isWhitespace).toCharArray().groupBy(el => el).map(e => (e._1, e._2.length))

  def topN(n: Int)(frequencies: Map[Char, Int]): Map[Char, Int] = ListMap(frequencies.toSeq.sortWith(_._2 > _._2):_*).toMap.take(n)

}
