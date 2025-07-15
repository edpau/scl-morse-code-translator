import translator.{MorseCode, Translator}

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    OutputHandler.printWelcome()

    var keepTranslating = true
    while (keepTranslating) {
      keepTranslating = handleMenuSelection() && askToContinue()
    }

  }

  @tailrec
  private def handleMenuSelection(): Boolean = {
    OutputHandler.printPrompt(menuText)

    InputHandler.getUserInput() match {
      case "1" => {
        handleEncode()
        true
      }
      case "2" => {
        handleDecode()
        true
      }
      case "0" => {
        OutputHandler.printPrompt("Goodbye")
        false
      }
      case _ => {
        OutputHandler.printError("Invalid input.")
        handleMenuSelection()
      }
    }
  }

  private def handleEncode(): Unit = {
    OutputHandler.printPrompt("Enter your message (English → Morse):")
    val input = InputHandler.getUppercasedInput()
    println(s"[Debug] input: $input")

    // TODO: Move input validation to Validation.scala
    // Includes: check for empty input, unsupported characters and max length
    if (!input.forall(MorseCode.charToMorse.contains))
      throw new IllegalArgumentException("Input contains invalid characters.")

    val encodedText = Translator.encode(input)
    OutputHandler.printEncoded(encodedText)
  }

  private def handleDecode(): Unit = {
    OutputHandler.printPrompt("Enter your message (Morse → English):")
    val input = InputHandler.getUserInput()
    println(s"[Debug] input: $input")

    //TODO input validation

    val decodedText = Translator.decode(input)
    OutputHandler.printEncoded(decodedText)

  }

  @tailrec
  private def askToContinue(): Boolean = {
    OutputHandler.printPrompt("Do you want to translate another message? Y/N")
    InputHandler.getUppercasedInput() match {
      // Input already uppercased in InputHandler
      case "Y" => true
      case "N" =>
        OutputHandler.printPrompt("Goodbye")
        false
      case _ =>
        OutputHandler.printError("Invalid input.")
        askToContinue()
    }
  }

  private val menuText: String =
    """📋 Menu
      |[1] Encode English → Morse
      |[2] Decode Morse → English
      |[0] Exit
      |""".stripMargin

}



