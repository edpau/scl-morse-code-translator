package io

import scala.io.StdIn.readLine

object InputHandler {
  def getUserInput(): String = readLine().trim

  def getUppercasedInput(): String = getUserInput().toUpperCase
}
