package io

object OutputHandler {

  def printWelcome(): Unit = println("🤖 Welcome to Morse Code Translator!\n")

  def printPrompt(prompt: String): Unit = println(prompt)

  def printError(errorMessage: String): Unit =
    println(s"\u001b[31m⚠️ Error: $errorMessage\u001b[0m")

  def printEncoded(encodedText: String): Unit = println(s"Morse Code: $encodedText")

}
