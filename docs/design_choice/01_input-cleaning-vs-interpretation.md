#  01_Design Choice: Input Cleaning vs Interpretation

`InputHandler` gives a clean slate — it handles sanitization (e.g. `.trim`, `.toUpperCase`) but **not interpretation**.  
Extra spaces like `"HI  ED"` are handled in `Translator.scala`, where formatting and word segmentation logic belongs.  
This keeps input handling predictable and simple, while allowing `Translator` full control over how the message is encoded.

By structuring the logic **word-by-word + char-by-char** (instead of only char-by-char), I gain the flexibility to handle edge cases like multiple spaces in a clean, testable way.

<details>
<summary>🧪 Example</summary>

```scala
"HI  ED"       // → List("HI", "", "ED")
"HI     ED"    // → after .filterNot(_.isEmpty) → List("HI", "ED")
// → ".... .. / . -.." ✅
```

</details>

## Why This Works

- **Char-by-char only** → you'd get multiple `/`s or need messy string cleanup
- **Word-by-word + char-by-char** → gives control to normalize, format, or reject input cleanly