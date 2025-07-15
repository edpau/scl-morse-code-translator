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
  
}
