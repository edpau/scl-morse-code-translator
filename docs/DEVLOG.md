@main vs Main

Keep impure code in input and output 

isolated side effects (I/O only in InputHandler/OutputHandler)
•	You’ve separated pure logic (in Translator)
•	You’ve kept data centralized (in MorseCode)
•	You can test Translator independently of everything else

Error Handling
Design pattern


What Is “State Logic” in This App?
In my Morse Code Translator, “state logic” might include:
Knowing what mode the app is in (Encode or Decode)
Tracking whether the user typed "exit" or not
Handling repeated input in a loop
Deciding which method to call (Translator.encode or .decode)
These are all parts of my app's control flow and user session state.

val trimmedList: List[String] = str.split("\\n").map(_.trim).toList
creating an intermediate collection from map
Use view for lazy transformation
val trimmedList: List[String] = str.split("\n").view.map(_.trim).toList
Use Iterator
val trimmedList: List[String] = str.split("\n").iterator.map(_.trim).toList

---
## Design Choice
01_Design Choice: Input Cleaning vs Interpretation
02_Design Choice: Fail-Fast Validation Before Encoding
03_Design Choice: Looping in `Main` for Repeated Translations
04_Design Choice: Early Return vs Nested Expressions
---

## Resources

[OReilly 11.19. Reversing Keys and Values](https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch11s20.html)
[How to reverse keys and values in Scala Map](https://www.includehelp.com/scala/reverse-keys-and-values-in-scala-map.aspx)
[What does it mean that there is a case argument in a map function?](https://www.reddit.com/r/scala/comments/gx3c3f/what_does_it_mean_that_there_is_a_case_argument/)

[A Guide to System.exit()](https://www.baeldung.com/java-system-exit)
---

## v0.1.0 – First Working Prototype: Input → Encode Pipeline

###  Core Features

- Built basic encoding flow from user input to Morse code output
- Added `InputHandler.scala` to collect and clean user input
- Implemented `Translator.scala` for word-by-word and char-by-char encoding
- Added `MorseCode.scala` to store mapping dictionary

### Functional Result

- User can input an English message
- App outputs correct Morse code translation

## v0.1.1 – Refactor I/O and Improve Readability

###  Structural Changes

- Added `OutputHandler.scala` to manage all user-facing output
- Refactored `InputHandler.scala`:
    - Extracted prompt logic to `OutputHandler`
    - Now focused only on getting and sanitizing input: `getUserInput()`

###  Design Benefits

- Clear separation of input/output responsibilities
- Easier to maintain and test each module independently

## v0.2.0 – Add Interactive Menu (Encoding + Decode Stub)

### Interactive Flow

- Introduced user menu:
  - [1] Encode English → Morse
  - [2] Decode Morse → English *(placeholder)*
  - [0] Exit
- Loop continues until user chooses to exit
- Includes `askToContinue()` Y/N prompt after each action

### Control Loop

- Introduced `while` loop to keep the app interactive
- Users can perform multiple actions in a single session
- Main loop pattern:
  ```scala
  while (keepTranslating) {
    keepTranslating = handleMenuSelection() && askToContinue()
  }

v0.2.1 – Add basic unit tests for encoding logic

## v0.2.2 – Add Decoding Logic + Translator Package

### Decode Feature

- Added `morseToChar` by reversing `charToMorse` map
- Implemented full `decode(morse: String)` method
- Extracted `decodeMorseWord()` helper for unit testing and clarity
- Connected decode to menu option [2] in Main loop

### Encode Refactor

- Extracted `encodeWord()` to mirror `decodeMorseWord`
- Renamed `splitWordsToList()` to `sentenceToWords()` for naming consistency

### Modular Design

- Introduced `translator` package to encapsulate:
  - `Translator.scala`
  - `MorseCode.scala`
  - `TranslatorTest.scala`
- Applied `private[translator]` visibility for internal helpers while keeping them testable

### Test Coverage

- Added unit tests for:
  - `encodeWord`
  - `decodeMorseWord`
  - Full encode/decode sentence round-trips
---