object Main {
  def main(args: Array[String]): Unit = {
    OutputHandler.printWelcome()

    val input = InputHandler.promptUser("Please type what you want to translate: ")
    println("[Debug] " + "input: " + input)

    // TODO: Move input validation to Validation.scala
    // Includes: check for empty input, unsupported characters and max length
    if (!input.forall(MorseCode.morseMap.contains))
      throw new IllegalArgumentException("Input contains invalid characters.")

    val encodedText  = Translator.encode(input)
    OutputHandler.printEncoded(encodedText)

  }
}
