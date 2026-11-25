# Scala Laboratory Work 3

This project contains six exercises about Scala best practices and functional programming. All tasks are implemented in `lab3.scala`.

## Requirements

- Scala (tested with 2.11.12)
- Java/JDK

## How to Run

Open a terminal in the project folder and run:

```bash
scala -nc lab3.scala
```

The program runs all six tasks, prints their results, and checks them using `assert()`.

## Tasks

1. **Fibonacci:** Generates a sequence using immutable values and tail recursion.
2. **flatMap and map:** Extracts ZIP codes from nested `Option` and `Seq` values.
3. **Type inference:** Demonstrates why Scala infers `Any` when a function returns different types.
4. **Option[Int]:** Implements safe division using `Option`, `map`, and `flatten`.
5. **Pattern matching:** Determines whether a number is positive, negative, or zero using `match` with guards.
6. **Futures:** Combines asynchronous computations to produce `"The answer is 6"`.

## Notes

- No external libraries or testing frameworks are required.
- The `-nc` option disables the Scala compilation server.
- Each task includes simple tests using `assert()`.
