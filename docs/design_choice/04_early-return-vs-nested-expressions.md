# 04_Design Choice: Early Return vs Nested Expressions

When validating input (e.g. for decoding), we faced a choice between:

* Nesting the final `Right(input)` inside an `else` block
* Or using early `return` statements to exit on failure

---

### 🧱 Original (Nested `Right`)

This version is idiomatic but gets harder to expand later:

```scala
def validateDecodeInput(input: String): Either[String, String] = {
  if (input.isEmpty)
    Left("Input is empty.")
  else {
    val morseWords = input.split(" / ")
    val allValid = morseWords.forall { ... }

    if (!allValid)
      Left("Invalid characters.")
    else
      Right(input) // ✅ but deeply nested
  }
}
```

---

### 🔁 Refactored (Early `return`)

This version is flatter and easier to grow:

```scala
def validateDecodeInput(input: String): Either[String, String] = {
  if (input.isEmpty)
    return Left("Input is empty.")

  val morseWords = input.split(" / ")
  val allValid = morseWords.forall { ... }

  if (!allValid)
    return Left("Invalid characters.")

  Right(input) // ✅ no nesting
}
```

---

### ✅ Why This Works

* Easy to read and extend (add new checks line-by-line)
* Clear failure paths
* Avoids deep nesting as validations grow

This keeps each validation rule isolated and the success case clean — making future updates or refactors simpler and safer.