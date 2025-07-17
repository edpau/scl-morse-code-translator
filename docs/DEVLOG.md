# 🧠 Devlog – Morse Code Translator (Scala)

## 🔧 Architecture Notes

### `Main` vs `@main` vs `extends App`
<details>
<summary>Why I use a traditional `Main` object</summary>

I chose a `Main` object with a `def main(args: Array[String]): Unit` method instead of using:
- `@main` annotation
- `extends App`

This was a conscious design decision for **clarity and testability**.

- `@main` is concise but hides the `args` signature and can be harder to debug.
- `extends App` has been **deprecated** in Scala 3 for larger applications because it:
  - Automatically runs everything in the body
  - Makes dependency injection and testability harder
- A `Main` object gives me **full control** over execution flow and better aligns with:
  - Explicit dependency management
  - Clean separation of concerns
  - Unit test–friendly structure

📚 *See also*: [Scala 3 - Book -  Main Methods in Scala 3](https://docs.scala-lang.org/scala3/book/methods-main-methods.html)

Quoted from the Scala 3 Book:
<blockquote>
“@main methods are the recommended way to generate programs that can be invoked from the command line in Scala 3. They replace the previous approach in Scala 2, which was to create an object that extends the App class.”
— Scala 3 Book: Main Methods
</blockquote>
</details>

---

### ♻️ Isolating Side Effects
<details>
<summary>Why I keep impure code in input and output handlers</summary>

I followed a **functional programming principle** of separating pure and impure code.

#### 💡 Structure:

| Module          | Responsibility               | Purity     |
|-----------------|------------------------------|------------|
| `InputHandler`  | Console input (`readLine`)   | **Impure** |
| `OutputHandler` | Console output (`println`)   | **Impure** |
| `Translator`    | Core encoding/decoding logic | ✅ **Pure** |
| `MorseCode`     | Morse dictionary (data only) | ✅ **Pure** |
| `Validation`    | Input checking logic         | ✅ **Pure** |

- `Validation` is **pure** — it returns `Either[String, String]` and doesn’t mutate anything.
- This lets me test validation logic **without needing I/O**.
- Impure actions (input/output) are isolated in `io/`, while everything else is **testable, reusable, and predictable**.

</details>

--- 

### 🔄 What Is “State Logic” in This App?
<details>
<summary>How I manage session state</summary>

Even a CLI app has state! In my translator, state logic includes:

- The app **mode**: Encode or Decode
- Whether the user typed `"exit"`
- Whether to continue looping
- Which function to call: `Translator.encode` vs `Translator.decode`

This logic controls what happens next and reflects the user session.
</details>

---
### ⚠️ Future Topics To Explore

<details>
<summary>Error Handling</summary>
  - User input errors
  - Graceful fallback
  - Reporting and logging
</details>

<details>
<summary>Design Patterns</summary>
  - Maybe apply **Strategy** (for encode/decode mode)
  - Use a **State pattern** if mode logic grows complex
</details>

<details>
<summary>Trimming Strings Without Intermediate Collections</summary>

Instead of:
```scala
val trimmedList: List[String] = str.split("\n").map(_.trim).toList
```

I can use **lazy or streaming alternatives**:

✅ With `view`:
```scala
val trimmedList: List[String] = str.split("\n").view.map(_.trim).toList
```

✅ With `iterator`:
```scala
val trimmedList: List[String] = str.split("\n").iterator.map(_.trim).toList
```

Why?
- `map(...).toList` creates intermediate collections
- `view` and `iterator` process elements lazily — better for performance in large data

</details>

---
## Design Choice
- [01_Design Choice: Input Cleaning vs Interpretation](design_choice/01_input-cleaning-vs-interpretation.md)
- [02_Design Choice: Fail-Fast Validation Before Encoding](design_choice/02_fail-fast-validation-before-encoding.md)
- [03_Design Choice: Looping in `Main` for Repeated Translations](design_choice/03_looping-in-main-for-repeated-translations.md)
- [04_Design Choice: Early Return vs Nested Expressions](design_choice/04_early-return-vs-nested-expressions.md)
---

## Reference & Learning Snippets

###  Reversing Map Keys and Values
- [OReilly 11.19. Reversing Keys and Values](https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch11s20.html)
- [How to reverse keys and values in Scala Map](https://www.includehelp.com/scala/reverse-keys-and-values-in-scala-map.aspx)
- [What does it mean that there is a case argument in a map function?](https://www.reddit.com/r/scala/comments/gx3c3f/what_does_it_mean_that_there_is_a_case_argument/)

### System Exit in Scala/Java
- [A Guide to System.exit()](https://www.baeldung.com/java-system-exit)

---
## Release Notes
- [v0.1.0 – First Working Prototype: Input → Encode Pipeline](release_notes/v0.1.0.md)
- [v0.1.1 – Refactor I/O and Improve Readability](release_notes/v0.1.1.md)
- [v0.2.0 – Add Interactive Menu (Encoding + Decode Stub)](release_notes/v0.2.0.md)
- v0.2.1 – Add basic unit tests for encoding logic
- [v0.2.2 – Add Decoding Logic + Translator Package](release_notes/v0.2.2.md)
- [v0.3.0 – MVP Complete](release_notes/v0.3.0.md)
---