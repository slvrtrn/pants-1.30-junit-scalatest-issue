package com.github.slvrtrn

import org.scalatest.flatspec.AnyFlatSpec

/**
  * ScalaTest 3.0.8 works without the annotation
  * ScalaTest 3.1.0+ throws
  *
  * [run]
  * .E
  * Time: 0.024
  * There was 1 failure:
  * 1) initializationError(com.github.slvrtrn.TestHello)
  * java.lang.NullPointerException
  *
  * but works fine if the annotation is uncommented
  */
class TestHello extends AnyFlatSpec {

  it should "pass" in {
    assert(false)
  }
}
