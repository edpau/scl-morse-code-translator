# 02_Design Choice: Fail-Fast Validation Before Encoding

To keep `Translator.encode` clean and safe, I **validate input upfront** — rejecting any character not in my Morse map.

By enforcing valid input early, I avoid `.getOrElse`, `.Option`, or fallback logic in the encode phase. This makes the encoding process pure and focused.

<details>
<summary>🧪 Example</summary>

```scala
if (!input.forall(MorseCode.charToMorse.contains))
  throw new IllegalArgumentException("Input contains invalid characters.")
```

```scala
// Safe to use:
def encodeChar(c: Char): String = charToMorse(c)
```

</details>

## Why This Works

- **Validation phase** owns responsibility for bad input
- **Encode phase** assumes input is valid and stays clean
- No wasted processing on invalid input