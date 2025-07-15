package validator

import org.scalatest.funsuite.AnyFunSuite

class ValidationTest extends AnyFunSuite {

  // ─────────────────────────────────────────────
  // Tests for: validateEncodeInput
  // ─────────────────────────────────────────────

  test("returns Left when input is empty") {
    val result = Validation.validateEncodeInput("")
    assert(result.isLeft, "Expected validation to fail for empty input.")
  }

  test("returns Left when input contains unsupported characters") {
    val result = Validation.validateEncodeInput("HELLO@")
    assert(result.isLeft, "Expected validation to fail for unsupported character.")
  }

  test("returns Left for single unsupported character") {
    val result = Validation.validateEncodeInput("@")
    assert(result.isLeft)
  }

  test("returns Right with original input when input is valid") {
    val result = Validation.validateEncodeInput("HI")
    assert(result == Right("HI"))
  }

  test("returns Right when input contains multiple valid words") {
    val result = Validation.validateEncodeInput("HI ED")
    assert(result == Right("HI ED"))
  }

}


// TODO: Explore sealed trait ValidationError for type-safe errors