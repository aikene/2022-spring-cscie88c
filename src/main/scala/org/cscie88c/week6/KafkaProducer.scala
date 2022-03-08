package org.cscie88c.week6

// define trait KafkaProducer below
trait KafkaProducer {
  def topic: String
  def send(message: String): String = s"Topic $topic with message: ($message) has been sent to Kafka"
}

// define the case class SimpleKafkaProducer below
case class SimpleKafkaProducer(topic: String) extends KafkaProducer {
}

// define the companion object SimpleKafkaProducer below
object SimpleKafkaProducer {
  implicit val defaultKafkaProducer: SimpleKafkaProducer = SimpleKafkaProducer(topic = "default-topic")
}

// uncomment the lines below once you have implemented KafkaProducer and SimpleKafkaProducer

object KafkaClient {
  // sends a status message to kafka
  def sendStatusEvent(status: String)(implicit kafkaProducer: KafkaProducer) = {
    kafkaProducer.send(status) // use the implicit KafkaProducer provided
  }  
}

