package translator

import translator.MorseCode.*

object Translator {

  // Split sentence into words, ignoring extra spaces
  private def splitWordsToList(str: String): List[String] = {
    str.split(" ").filterNot(_.isEmpty).toList
  }

  private def morseSentenceToWords(str: String): List[String] = {
    str.split(" / ").toList
  }

  private[translator] def decodeMorseWord(morseWord: String): String = {
    morseWord.split(" ").map(decodeMorseLetter).mkString("")
  }

  def encode(input: String): String = {
    splitWordsToList(input)
      .map { word =>
        word.map(encodeChar).mkString(" ")
      }
      .mkString(" / ")
  }

  def decode(morse: String): String = {
    morseSentenceToWords(morse).map(decodeMorseWord).mkString(" ")
  }

}

// =============================
// Developer Notes (Pseudo-code)
// =============================
//  Goal: Translate English to Morse Code
//   1. Split sentence into words → .split(" ") → List[String]
//   2. Filter out empty strings
//   3. For each word, convert to List[Char]
//   4. Map each Char to Morse → encodeChar(c)
//   5. Join letters with " " and words with " / "
//
// - Idea:
//   • Improve with for-comprehension or flatMap
//   • Use Option or Either to handle missing chars
//   • Reject input that is empty or too long
//   • Decide how to handle multiple spaces (normalize or preserve)
//   • Add .getOrElse("?") fallback for unknown characters
//   • Extract validation to separate module (Validation.scala)
