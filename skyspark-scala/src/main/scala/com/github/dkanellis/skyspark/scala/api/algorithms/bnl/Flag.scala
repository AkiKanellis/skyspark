package com.github.dkanellis.skyspark.scala.api.algorithms.bnl

private[bnl] case class Flag(bits: Boolean*) extends Serializable {

  private[bnl] def size = bits.length

  private[bnl] def bit(i: Int) = bits(i)
}
