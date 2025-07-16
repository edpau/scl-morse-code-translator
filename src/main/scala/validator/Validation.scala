package validator

import translator.MorseCode

object Validation {
  
  def validateEncodeInput(input: String): Either[String, String] = {
    if (input.isEmpty)
      Left("Input is empty.")
    else if (!input.forall(MorseCode.charToMorse.contains))
      Left("Input contains unsupported characters.")
    else 
      Right(input)
  }

  def validateDecodeInput(input: String): Either[String, String] = {
    if (input.isEmpty)
      return Left("Input is empty.")

    val morseWords = input.split(" / ")

    val allValid = morseWords.forall{ word =>
      val letters = word.split(" ")
      letters.forall(MorseCode.morseToChar.contains)
    }

    if(!allValid)
     return Left("Input contains unsupported characters.")

    Right(input)
  }

}
