package translator

import translator.MorseCode.*

object Translator {

  // Split sentence into words, ignoring extra spaces
  private def sentenceToWords(str: String): List[String] = {
    str.split(" ").filterNot(_.isEmpty).toList
  }

  private[translator] def encodeWord(word: String): String = {
    word.map(encodeChar).mkString(" ")
  }

  private def morseSentenceToWords(str: String): List[String] = {
    str.split(" / ").toList
  }

  private[translator] def decodeMorseWord(morseWord: String): String = {
    morseWord.split(" ").map(decodeMorseLetter).mkString("")
  }

  def encode(input: String): String = {
    sentenceToWords(input).map(encodeWord).mkString(" / ")
  }

  def decode(morse: String): String = {
    morseSentenceToWords(morse).map(decodeMorseWord).mkString(" ")
  }

}