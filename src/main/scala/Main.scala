object Main {
  def main (args: Array[String]): Unit = {
    println("🤖Welcome to Morse Code Translator!\n")

    val input = InputHandler.promptUser("Please type what you want to translate: ")
    
    println(input)
  }
}
