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

}
