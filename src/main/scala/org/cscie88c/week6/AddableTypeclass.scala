package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  // add trait methods below
  def addTwoValues(a: A, b: A): A
}

object AddableTypeclass {
  
  implicit val intAddableTypeclass: AddableTypeclass[Int] = _ + _

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] = _ || _

}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A = {
    list.reduce(addable.addTwoValues)
  }
}
