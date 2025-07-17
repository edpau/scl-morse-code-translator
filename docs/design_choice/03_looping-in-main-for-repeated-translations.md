# 03_Design Choice: Looping in `Main` for Repeated Translations

The app uses a `while` loop in `Main.scala` to allow users to translate multiple messages in one session. This approach keeps the control flow simple while I focus on building and testing the core features.

Later, this loop can be refactored to a tail-recursive function or a functional style (`Iterator.continually`, etc.) to improve readability and functional purity.

## Why This Works

- Keeps iteration logic isolated in `Main`, making future refactors easy
- Lets me build the control loop incrementally, without early complexity

## Resources
[Scala3 -Book , control structures](https://docs.scala-lang.org/scala3/book/control-structures.html?utm_source=chatgpt.com)

[Scala while and do/while loops (syntax, examples)](https://alvinalexander.com/scala/while-do-while-loops-syntax-examples/?utm_source=chatgpt.com)
If you get into functional programming, you won’t use while loops — because you don’t use var fields in FP — but Scala while loops and do/while loops still have a place in OOP (object-oriented programming).