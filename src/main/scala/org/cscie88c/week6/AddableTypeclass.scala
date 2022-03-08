package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  // add trait methods below
  def addTwoValues(a: A, b: A): A
  def zero: A
}

object AddableTypeclass {
  
  implicit val intAddableTypeclass: AddableTypeclass[Int] = new AddableTypeclass[Int] {
    override def addTwoValues(a: Int, b: Int): Int = a + b

    override def zero: Int = 0
  }

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] = new AddableTypeclass[Boolean] {
    override def addTwoValues(a: Boolean, b: Boolean): Boolean = a || b

    override def zero: Boolean = true
  }

}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A = {
    list.foldLeft(addable.zero)(addable.addTwoValues)
  }
}
