import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    OutputHandler.printWelcome()

    var keepTranslating = true
    while (keepTranslating) {

      OutputHandler.printPrompt("Enter your message (English → Morse):")
      val input = InputHandler.getUserInput()
      println(s"[Debug] input: $input")

      // TODO: Move input validation to Validation.scala
      // Includes: check for empty input, unsupported characters and max length
      if (!input.forall(MorseCode.morseMap.contains))
        throw new IllegalArgumentException("Input contains invalid characters.")

      val encodedText = Translator.encode(input)
      OutputHandler.printEncoded(encodedText)

      keepTranslating = askToContinue()
    }

  }
}

@tailrec
private def askToContinue(): Boolean = {
  OutputHandler.printPrompt("Do you want to translate another message? Y/N")
  InputHandler.getUserInput() match {
    case "Y" => true
    case "N" =>
      OutputHandler.printPrompt("Goodbye")
      false
    case _ =>
      OutputHandler.printError("Invalid input.")
      askToContinue()
    // change to printError later and think recursively retry
  }
}