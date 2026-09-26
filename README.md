# Binary Number Converter

A Java command-line application that converts values between decimal and binary using custom conversion algorithms.

## Why I built it

This project demonstrates core programming fundamentals that are useful in software engineering: decomposing a problem into focused methods, validating user input, handling exceptional cases, and reasoning about numeric overflow.

## Features

- Convert non-negative decimal values to binary
- Convert binary strings to decimal values
- Custom algorithms instead of built-in base-conversion utilities
- Clear validation for malformed and negative input
- Overflow detection for values larger than Java's `long` range
- Menu-driven interface that supports repeated conversions

## How the algorithms work

Decimal-to-binary repeatedly divides the number by two, records each remainder, and reverses the collected digits.

Binary-to-decimal processes digits from left to right. For each digit, it doubles the current result and adds the new bit:

```text
result = result * 2 + bit
```

## Run locally

Requirements: Java Development Kit (JDK) 17 or newer.

```bash
javac BinaryConverter.java
java BinaryConverter
```

## Example

```text
Binary Number Converter

1. Decimal to Binary
2. Binary to Decimal
3. Exit
Choose an option: 1
Enter a non-negative decimal number: 13
Binary: 1101
```

## Skills demonstrated

Java, object-oriented organization, loops, conditionals, string processing, input validation, exception handling, overflow-safe arithmetic, and command-line application design.

## Possible next steps

- Add automated unit tests with JUnit
- Support hexadecimal and octal conversion
- Add signed-number support
- Build a graphical interface

## License

Released under the MIT License.
