package org.cscie88c.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] = LazyList.range(0, 105, 5)

  val randIntStream: LazyList[Int] = LazyList.continually(rnd.nextInt(15))

  val dogs: LazyList[Dog] = LazyList.iterate(Dog("dog-"+uuid, randIntStream.head, rnd.nextBoolean()))(
    d => d.copy(name = "dog-"+uuid, age = rnd.nextInt(randIntStream.head), hasCurrentShots = rnd.nextBoolean() ) 
  )

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = dogs.filter(_.hasCurrentShots == true)

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = allDogs.filter(_.hasCurrentShots == true).take(sampleSize).map(_.age).sum / sampleSize


}
