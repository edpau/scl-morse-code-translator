object MorseCode {
  val charToMorse: Map[Char, String] = Map(
    'A' -> ".-", 'B' -> "-...", 'C' -> "-.-.", 'D' -> "-..",
    'E' -> ".", 'F' -> "..-.", 'G' -> "--.", 'H' -> "....",
    'I' -> "..", 'J' -> ".---", 'K' -> "-.-", 'L' -> ".-..",
    'M' -> "--", 'N' -> "-.", 'O' -> "---", 'P' -> ".--.",
    'Q' -> "--.-", 'R' -> ".-.", 'S' -> "...", 'T' -> "-",
    'U' -> "..-", 'V' -> "...-", 'W' -> ".--", 'X' -> "-..-",
    'Y' -> "-.--", 'Z' -> "--..", ' ' -> "/"
  )

  val morseToChar: Map[String, Char] = charToMorse.map((char, morse) => (morse, char))

  def encodeChar(c: Char): String = charToMorse(c)

}
