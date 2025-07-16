package validator

import org.scalatest.funsuite.AnyFunSuite

class ValidationTest extends AnyFunSuite {

  // ─────────────────────────────────────────────
  // Tests for: validateEncodeInput
  // ─────────────────────────────────────────────

  test("validateEncodeInput returns Left when input is empty") {
    val result = Validation.validateEncodeInput("")
    assert(result.isLeft, "Expected validation to fail for empty input.")
  }

  test("validateEncodeInput returns Left when input contains unsupported characters") {
    val result = Validation.validateEncodeInput("HELLO@")
    assert(result.isLeft, "Expected validation to fail for unsupported character.")
  }

  test("validateEncodeInput returns Left for single unsupported character") {
    val result = Validation.validateEncodeInput("@")
    assert(result.isLeft)
  }

  test("validateEncodeInput returns Right with original input when input is valid") {
    val result = Validation.validateEncodeInput("HI")
    assert(result == Right("HI"))
  }

  test("validateEncodeInput returns Right when input contains multiple valid words") {
    val result = Validation.validateEncodeInput("HI ED")
    assert(result == Right("HI ED"))
  }

  // ─────────────────────────────────────────────
  // Tests for: validateDecodeInput
  // ─────────────────────────────────────────────

  test("validateDecodeInput returns Left when input is empty") {
    val result = Validation.validateDecodeInput("")
    assert(result.isLeft, "Expected validation to fail for empty input.")
  }

  test("validateDecodeInput returns Left when input contains unsupported characters") {
    val result = Validation.validateDecodeInput("HELLO@")
    assert(result.isLeft, "Expected validation to fail for unsupported character.")
  }

  test("validateDecodeInput returns Left for single unsupported character") {
    val result = Validation.validateDecodeInput("@")
    assert(result.isLeft)
  }

  test("validateDecodeInput returns Right with original input when input is valid") {
    val result = Validation.validateDecodeInput(".")
    assert(result == Right("."))
  }

  test("validateDecodeInput returns Right when input contains multiple valid words") {
    val result = Validation.validateDecodeInput(".... .. / - .... . .-. .")
    assert(result == Right(".... .. / - .... . .-. ."))
  }

}


// TODO: Explore sealed trait ValidationError for type-safe errors