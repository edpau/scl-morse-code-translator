object OutputHandler {

  def printWelcome(): Unit = println("🤖 Welcome to Morse Code Translator!\n")
  def printPrompt(prompt: String): Unit = println(prompt)

  def printEncoded(encodedText: String): Unit = println(s"Morse Code: $encodedText")

}
