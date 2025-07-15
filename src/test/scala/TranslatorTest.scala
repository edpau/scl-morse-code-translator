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

  test("decodes a single word") {
    assert(Translator.decode(".... . .-.. .-.. ---") == "HELLO")
  }
  
  test("decodes full sentence with /") {
    assert(Translator.decode(".... .. / - .... . .-. .") == "HI THERE")
  }

}
