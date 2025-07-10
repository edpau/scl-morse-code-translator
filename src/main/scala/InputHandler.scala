import scala.io.StdIn.readLine

object InputHandler {
  def promptUser(prompt: String): String = readLine(prompt).trim.toUpperCase
}
