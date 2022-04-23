package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import Streams.Dog

class StreamsTest extends StandardTest {
  "Streams" when {
    "calling healthyDogs" should {
      "return a list of dogs with hasCurrentShots set to true" in {
        val infiniteStreamOfDogs = Streams.dogs
        val healthyDogs = Streams.healthyDogs(infiniteStreamOfDogs)
        healthyDogs.map(_.hasCurrentShots).take(5) should equal(List.fill(5)(true))
      }
    }
    "calling averageHealtheyAge" should {
      "return an average less than 15" in {
        val infiniteStreamOfDogs = Streams.dogs
        val healthyDogAverage = Streams.averageHealthyAge(infiniteStreamOfDogs, 5)
        healthyDogAverage <= 15.0 should be(true)
      }
    }
  }

  // Bonus problem unit tests
}
