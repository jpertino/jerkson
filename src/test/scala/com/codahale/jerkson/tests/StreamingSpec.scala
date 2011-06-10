package com.codahale.jerkson.tests

import com.codahale.jerkson.Json._
import java.io.ByteArrayInputStream
import com.codahale.simplespec.Spec

class StreamingSpec extends Spec {
  class `Parsing a stream of objects` {
    private val json = """[
      {"id":1, "name": "Coda"},
      {"id":2, "name": "Niki"},
      {"id":3, "name": "Biscuit"},
      {"id":4, "name": "Louie"}
    ]"""

    def `returns an iterator of stream elements` = {
      stream[CaseClass](new ByteArrayInputStream(json.getBytes)).toList must
        beEqualTo(CaseClass(1, "Coda") :: CaseClass(2, "Niki") ::
                  CaseClass(3, "Biscuit") :: CaseClass(4, "Louie") :: Nil)
    }
  }
}