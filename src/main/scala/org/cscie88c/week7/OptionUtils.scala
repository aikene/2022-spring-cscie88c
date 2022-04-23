package org.cscie88c.week7

import java.io.FileNotFoundException
import scala.io.Source
import scala.util.{Failure, Success, Try}

object OptionUtils {
  
  def fileCharCount(fileName: String): Try[Long] = {
    Try(Source.fromFile(fileName).size.toLong)
  }

  def charCountAsString(fileName: String): String = {
    fileCharCount(fileName) match {
      case Success(count) => s"number of characters: ${count.toString}"
      case Failure(e) => "error opening file"
    }
  }

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] = {
    try {
      val fileStream = Source.fromFile(fileName).getLines()
      if (!fileStream.isEmpty) {
        Some(LazyList.from(fileStream))
      } else {
        None
      }
    } catch {
      case e: FileNotFoundException => None
    }
  }
}
