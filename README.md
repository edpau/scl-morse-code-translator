# Morse Code Translator – Scala CLI App

## Overview

Create a **Scala command-line application** that translates between **English text** and **Morse code**.

This project encourages:
- Functional programming
- Clean modular code using classes or objects
- Writing tests with ScalaTest

---

##MVP Requirements

### Functional Requirements

- Accept user input via command line
- Translate:
  - **English → Morse**
  - **Morse → English**
- Follow these spacing conventions:
  - One space between Morse characters (e.g., `.... . .-.. .-.. ---`)
  - Use **"/"** for word separation (e.g., `.... . .-.. .-.. --- / .-- --- .-. .-.. -..`)

---

### Architecture

Split the program into the following **Scala objects/classes**:

- `InputHandler`: Handles reading and validating input
- `OutputHandler`: Handles printing the result
- `Translator`: Contains all conversion logic
- `MorseCode`: Stores the Morse mappings (as a `Map[Char, String]`)

Use pure functions in `Translator` to make testing easy.

---

## Unit Testing

- Use **ScalaTest**
- Test:
  - English to Morse
  - Morse to English
  - Word separation
  - Invalid inputs

---

##  Bonus Features

- Auto-detect input type
- Keep asking for input until `"exit"` is typed
- Optionally include punctuation support

---

## Functional Programming Guidelines

Your implementation should follow the principles of **functional programming**:

- ✅ Prefer `val` over `var` — avoid mutation where possible
- ✅ Keep `Translator` logic **pure** — no side effects or external dependencies
- ✅ Use `Option`, `Either`, or `Try` to handle potential failures instead of `null` or exceptions
- ✅ Use **higher-order functions** like `map`, `flatMap`, and `filter` instead of loops
- ✅ Keep input/output (I/O) in `InputHandler` and `OutputHandler` only
- ✅ Aim for composable, reusable, testable functions

---

## Morse Code Mapping (Partial)

```scala
val morseCode: Map[Char, String] = Map(
  'A' -> ".-",   'B' -> "-...", 'C' -> "-.-.", 'D' -> "-..",
  'E' -> ".",    'F' -> "..-.", 'G' -> "--.",  'H' -> "....",
  'I' -> "..",   'J' -> ".---", 'K' -> "-.-",  'L' -> ".-..",
  'M' -> "--",   'N' -> "-.",   'O' -> "---",  'P' -> ".--.",
  'Q' -> "--.-", 'R' -> ".-.",  'S' -> "...",  'T' -> "-",
  'U' -> "..-",  'V' -> "...-", 'W' -> ".--",  'X' -> "-..-",
  'Y' -> "-.--", 'Z' -> "--..", ' ' -> "/"
)