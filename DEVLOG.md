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
## ✅ Design Choice: Input Cleaning vs Interpretation

`InputHandler` gives a clean slate — it handles sanitization (e.g. `.trim`, `.toUpperCase`) but **not interpretation**.  
Extra spaces like `"HI  ED"` are handled in `Translator.scala`, where formatting and word segmentation logic belongs.  
This keeps input handling predictable and simple, while allowing `Translator` full control over how the message is encoded.

By structuring the logic **word-by-word + char-by-char** (instead of only char-by-char), we gain the flexibility to handle edge cases like multiple spaces in a clean, testable way.

<details>
<summary>🧪 Example</summary>

```scala
"HI  ED"       // → List("HI", "", "ED")
"HI     ED"    // → after .filterNot(_.isEmpty) → List("HI", "ED")
// → ".... .. / . -.." ✅
```

</details>

### ✅ Why This Works

- **Char-by-char only** → you'd get multiple `/`s or need messy string cleanup
- **Word-by-word + char-by-char** → gives control to normalize, format, or reject input cleanly

---

## ✅ Design Choice: Fail-Fast Validation Before Encoding

To keep `Translator.encode` clean and safe, we **validate input upfront** — rejecting any character not in our Morse map.

By enforcing valid input early, we avoid `.getOrElse`, `.Option`, or fallback logic in the encode phase. This makes the encoding process pure and focused.

<details>
<summary>🧪 Example</summary>

```scala
if (!input.forall(MorseCode.morseMap.contains))
  throw new IllegalArgumentException("Input contains invalid characters.")
```

```scala
// Safe to use:
def encodeChar(c: Char): String = morseMap(c)
```

</details>

### ✅ Why This Works

- **Validation phase** owns responsibility for bad input
- **Encode phase** assumes input is valid and stays clean
- No wasted processing on invalid input

---

reverse map, make sure value is unique
[OReilly 11.19. Reversing Keys and Values](https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch11s20.html)
[How to reverse keys and values in Scala Map}(https://www.includehelp.com/scala/reverse-keys-and-values-in-scala-map.aspx)
