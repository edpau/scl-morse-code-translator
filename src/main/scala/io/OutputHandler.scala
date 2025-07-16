package io

object OutputHandler {

  def printWelcome() = println("🤖 Welcome to Morse Code Translator!\n")

  def printPrompt(prompt: String) = println(prompt)

  def printError(errorMessage: String) =
    println(s"\u001b[31m⚠️ Error: $errorMessage\u001b[0m")

  def printResult(encodedText: String) = println(s"Morse Code: $encodedText")

}
