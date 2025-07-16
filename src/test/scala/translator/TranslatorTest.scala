package translator

import org.scalatest.funsuite.AnyFunSuite

class TranslatorTest extends AnyFunSuite {

  test("encodes a single character") {
    assert(Translator.encode("E") == ".")
  }

  test("encodeWord encodes a word") {
    assert(Translator.encodeWord("HELLO") == ".... . .-.. .-.. ---")
  }

  test("encode encodes a sentence with spaces") {
    assert(Translator.encode("HI THERE") == ".... .. / - .... . .-. .")
  }

  test("decodeMorseWord decodes a single word") {
    assert(Translator.decodeMorseWord(".... . .-.. .-.. ---") == "HELLO")
  }

  test("decode decodes full sentence with /") {
    assert(Translator.decode(".... .. / - .... . .-. .") == "HI THERE")
  }

}
