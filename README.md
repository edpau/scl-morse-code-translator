# 🧠 Morse Code Translator – Scala CLI App

A simple, testable command-line app that translates between **English** and **Morse Code**, built in **Scala** using functional principles.

---

## 📋 Table of Contents

- [Overview](#overview)
  - [Features](#features)
  - [How to Use](#how-to-use)
  - [Run Locally](#run-locally)
  - [Links](#links)
- [Architecture](#architecture)
- [Testing](#testing)
- [What I Learned](#what-i-learned)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## 📌 Overview

This project simulates a **Morse Code translator** in a clean, interactive CLI using **Scala 3**. It reinforces:
- Functional programming practices
- Modular structure with pure/impure separation
- Type-safe validation via `Either`
- Confident testing using **ScalaTest**

---

## ✨ Features

- Translate between:
  - English → Morse
  - Morse → English
- Looping menu for repeated translations
- Validation with helpful error messages
- Modular architecture with separation of concerns

---

## 🕹️ How to Use

- Use **spaces** between Morse letters (e.g. `.... . .-.. .-.. ---`)
- Use **"/"** to separate Morse words (e.g. `.... . .-.. .-.. --- / .-- --- .-. .-.. -..`)

---

## 🚀 Run Locally

Make sure you have **SBT** installed:  
📖 https://www.scala-sbt.org/download.html

### 1. Clone the repository
```bash
git clone https://github.com/edpau/scl-morse-code-translator.git
cd scl-morse-code-translator
```

### 2. Run the app
```bash
sbt run
```

---

## 🧱 Architecture

All logic is modularized into small, focused components:

| Module            | Responsibility                         |
|-------------------|------------------------------------------|
| `Main`            | Orchestrates flow & loop logic          |
| `Translator`      | Pure encoding/decoding logic            |
| `MorseCode`       | Dictionary: `Map[Char, String]`         |
| `Validation`      | Input validation using `Either`         |
| `InputHandler`    | Handles user input (impure)             |
| `OutputHandler`   | Handles user output (impure)            |

---

## ✅ Testing

- Framework: **ScalaTest**
- Location: `src/test/scala`
- Coverage:
  - ✅ Encoding & decoding logic
  - ✅ Input validation (both directions)
  - ✅ Edge cases (e.g., empty input, invalid characters)

To run tests:
```bash
sbt test
```

---

## 📚 What I Learned

This project was part of my effort to:
- Learn functional programming in Scala
- Apply `Option`/`Either` over `null` or exceptions
- Structure an app for readability, testing, and extensibility
- Build clean CLI tools with **minimal dependencies**

See full log → [`docs/DEVLOG.md`](docs/DEVLOG.md)

---

## 🌱 Future Improvements

- 🔸 Auto-detect input type (English or Morse)
- 🔸 Support punctuation (e.g., `.` `,` `?`)
- 🔸 Stylized CLI output (colors, formatting)
- 🔸 Replace raw error strings with a `sealed trait` `ValidationError`

---

## 🔗 Links

- 📁 GitHub: [github.com/edpau/scl-morse-code-translator](https://github.com/edpau/scl-morse-code-translator)
- 📘 Dev Log: [`docs/DEVLOG.md`](docs/DEVLOG.md)

---

## 👤 Author

- 💼 Website: [edpau.me](https://www.edpau.me)
- 🎓 Frontend Mentor: [@edpau](https://www.frontendmentor.io/profile/edpau)
