package translator
import org.scalatest.funsuite.AnyFunSuite


class TranslatorTest extends AnyFunSuite {

  test("encodes a single character") {
    assert(Translator.encode("E") == ".")
  }

  test("encodes a word") {
    assert(Translator.encode("HELLO") == ".... . .-.. .-.. ---")
  }

  test("encodes a sentence with spaces") {
    assert(Translator.encode("HI THERE") == ".... .. / - .... . .-. .")
  }

  test("decodeMorseWord decodes a single word") {
    assert(Translator.decodeMorseWord(".... . .-.. .-.. ---") == "HELLO")
  }

  test("decode decodes full sentence with /") {
    assert(Translator.decode(".... .. / - .... . .-. .") == "HI THERE")
  }

}
