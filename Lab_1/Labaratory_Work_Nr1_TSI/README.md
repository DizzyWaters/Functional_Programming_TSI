## Requirements

- GHC (Haskell compiler)
- GNU Make

On Ubuntu, install them with:

```bash
sudo apt install ghc make
```

## How to run a task

Open a terminal in the repository folder:

```bash
cd Lab_1/TSI_tasks
```

Compile a task (for example, Task 8):

```bash
make task8
```

Run it with input:

```bash
printf '[[1,2],[3,4]]\n' | ./main
```

Expected output: `True`.

To run another task, compile it first, for example `make task5`, and then run `./main` with the input required by that task.

## How to run tests

Each task has input files and expected output files in `tests/`.

Run all tests for one task:

```bash
make test_task8
```

Or test another task:

```bash
make test_task5
make test_task7
```

The terminal shows `SUCCESS` or `FAIL` for each test. Test results are saved in `test_results/`.

For the original Task 1 tests, use:

```bash
make test
make test_reverse_sort
```

## Project files

- `main.hs` — selects which task to run.
- `Task1.hs`, `Task2.hs`, etc. — task solutions.
- `Task8.hs` — code and comments containing the proof for Task 8.
- `Makefile` — commands to compile and test tasks.
- `tests/` — test inputs and expected outputs.
- `test_results/` — generated test logs.

**Note:** The `main` executable is replaced when you compile a different task, so run `make taskN` before testing Task N manually.
