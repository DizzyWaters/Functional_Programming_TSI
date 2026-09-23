# TSI Task 1

Simple Haskell project with several build/run modes controlled through the Makefile.

## Requirements

- GHC
- GNU Make

## Build

Default mode:

```bash
make
```

This compiles:

```text
main.hs -> main
```

The default mode uses the `#else` branch in `main.hs`.

## Available modes

### Default mode

```bash
make
```

or:

```bash
make default
```

Uses:

```haskell
main = interact Task1.solve
```

### Manual mode

```bash
make manual
```

Compiles with:

```text
-DMANUAL
```

and uses the `#ifdef MANUAL` branch.

### Read-file mode

```bash
make read
```

Compiles with:

```text
-DREADM
```

and uses the `#ifdef READM` branch.

### Super mode

```bash
make super
```

Compiles with:

```text
-DSUPERM
```

and uses the `#ifdef SUPERM` branch.

## Build and run

You can build and immediately run a mode:

```bash
make run
make run_manual
make run_read
make run_super
```

## Automatic tests

Run all tests with:

```bash
make test
```

The Makefile runs 10 tests.

Input files should be named:

```text
tests/task_1_test_1.txt
tests/task_1_test_2.txt
...
tests/task_1_test_10.txt
```

Expected output files should be named:

```text
tests/task_1_test_1_expected.txt
tests/task_1_test_2_expected.txt
...
tests/task_1_test_10_expected.txt
```

For every test, Make prints either:

```text
Test N: SUCCESS
```

or:

```text
Test N: FAIL
```

If a test fails, the expected and actual output are printed.

## Cleanup

Remove GHC temporary files:

```bash
make clean_trash
```

This removes:

```text
*.o
*.hi
```

Remove the executable and all generated files:

```bash
make clean_all
```

## Quick command reference

| Command | Description |
|---|---|
| `make` | Build default mode |
| `make manual` | Build manual mode |
| `make read` | Build read-file mode |
| `make super` | Build super mode |
| `make run` | Build and run default mode |
| `make run_manual` | Build and run manual mode |
| `make run_read` | Build and run read-file mode |
| `make run_super` | Build and run super mode |
| `make test` | Run all 10 automatic tests |
| `make clean_trash` | Remove `.o` and `.hi` files |
| `make clean_all` | Remove all generated files |
