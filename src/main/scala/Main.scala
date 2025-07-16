import io.{InputHandler, OutputHandler}
import translator.{MorseCode, Translator}
import validator.Validation

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

    Validation.validateEncodeInput(input) match
      case Right(validInput) =>
        val encodedText = Translator.encode(validInput)
        OutputHandler.printEncoded(encodedText)
      case Left(error) =>
        OutputHandler.printError(error)
        handleEncode()
  }

  private def handleDecode(): Unit = {
    OutputHandler.printPrompt("Enter your message (Morse → English):")
    val input = InputHandler.getUserInput()
    println(s"[Debug] input: $input")

    Validation.validateDecodeInput(input) match
      case Right(validInput) =>
        val decodedText = Translator.decode(validInput)
        OutputHandler.printEncoded(decodedText)
      case Left(error) =>
        OutputHandler.printError(error)
        handleDecode()
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



