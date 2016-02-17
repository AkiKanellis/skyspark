package com.github.dkanellis.skyspark.api.algorithms

import com.github.dkanellis.skyspark.scala.api.algorithms.Point
import org.scalatest.FlatSpec

class PointTest extends FlatSpec {

  val point = new Point(5, 2, 7, 1)

  "A smaller than 0 index" should "throw IndexOutOfBoundsException" in {
    intercept[IndexOutOfBoundsException] {
      point.getValueOf(-1)
    }
  }

  "A bigger than size index" should "throw IndexOutOfBoundsException" in {
    intercept[IndexOutOfBoundsException] {
      point.getValueOf(4)
    }
  }

  "A 0 index" should "return the first value" in {
    assertResult(5)(point.getValueOf(0))
  }

  "A 3 index" should "return the last value" in {
    assertResult(1)(point.getValueOf(3))
  }
}
