package io

object OutputHandler {

  def printWelcome() = println("🤖 Welcome to Morse Code Translator!\n")

  def printPrompt(prompt: String) = println(prompt)

  def printError(errorMessage: String) =
    println(s"\u001b[31m⚠️ Error: $errorMessage\u001b[0m")

  def printEncodeResult(morse: String) =
    println(s"\u001b[92mMorse Code: $morse\u001b[0m")

  def printDecodeResult(english: String) =
    println(s"\u001b[94mEnglish: $english\u001b[0m")

}
