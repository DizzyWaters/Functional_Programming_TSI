# Suggested Structure for the Functional Programming Lab

## Purpose

Keep the existing idea: each task has pure Haskell functions, a small I/O entry point, Make commands, fixture tests, and saved results. Use Variant 1 throughout and only GHC, Make, and standard libraries.

This is a structure proposal; it does not implement the exercises.

## Project Layout

Gradually consolidate the assessed lab under `Lab_1`, keeping lecture notes, classwork, and playground experiments separate.

```text
Functional_Programming/
├── .gitignore
├── assistant_suggestions.md        # Local, ignored planning document
├── Notes_1.md
├── Notes_2.md
├── Resources.md
├── classwork/
├── playground/
└── Lab_1/
    ├── README.md                  # Requirements, commands, progress
    ├── Makefile                   # Build and test every task
    ├── haskell_laboratory_work_n1.pdf
    ├── src/
    │   ├── Task1.hs
    │   ├── Task2.hs
    │   └── ...                    # Through Task8.hs
    ├── app/
    │   ├── Task1Main.hs
    │   ├── Task2Main.hs
    │   └── ...                    # Only tasks needing executable I/O
    ├── tests/
    │   ├── fixtures/
    │   │   ├── task1/
    │   │   ├── task2/
    │   │   └── ...
    │   └── properties/
    │       └── Main.hs
    ├── docs/
    │   ├── task0-setup.md
    │   └── task8-proof.md
    ├── build/                     # Ignored executables and compiler files
    └── test_results/              # Ignored generated logs
```

Move existing Task 1 sources and fixtures into this structure when implementation begins. Preserve the current tests and notes; document their new locations. Keep existing Make commands working through forwarding targets during the move.

## Module and Command Conventions

- `src/TaskN.hs` contains the task's pure functions, explicit types, and a small exported interface.
- Each executable entry point handles input, validation, formatting, and errors. Keep task logic out of I/O code.
- Retain `solve :: String -> String` adapters where useful for existing fixture tests. Tasks involving lists and trees should also expose typed functions for direct testing.
- Build separate executables with separate compiler-output directories, avoiding collisions between entry points named `Main`.
- Provide `make task1`, `make run_task1`, and `make test_task1`, following the same pattern for executable tasks.
- Provide `make all`, `make test`, `make test_properties`, and `make clean`. Aggregate testing must fail if any suite fails.
- Use paired fixture names such as `normal.input` and `normal.expected`. Allow optional `.status` files for cases expecting a nonzero exit code; default to zero.
- Test execution must detect missing fixtures, crashes, incorrect exit codes, and output mismatches. Save actual output, stderr, and a clear result per case.
- Document each task's input and output before implementing it. Keep successful output on stdout and input errors on stderr.

## Task Coverage and Testing

| Task | Variant 1 deliverable | Planned checks |
|---|---|---|
| 0 | Compiler setup record | Record GHC/Make versions and a successful smoke build. |
| 1 | Maximum through descending sort, with descriptive output | Keep existing sorting tests; separately test the final maximum result. Cover negatives, duplicates, singleton lists, empty input, and invalid numbers. |
| 2 | Reverse a name | Ordinary names, blank name, one character, spaces, punctuation, Unicode letters, and reversing twice. |
| 3 | Capitalize each word | Empty text, repeated spaces, single-letter words, mixed case, and multiple words. Follow the assignment's single-space joining rule. |
| 4 | Penultimate list element | Two-element and longer lists, duplicates, and explicit handling of lists shorter than two. |
| 5 | Custom indexing operator | First, middle, and last positions; agreement with Prelude indexing for valid positions; defined behavior for negative and out-of-range positions. |
| 6 | Every list formed by removing one position | Empty and singleton lists, ordinary lists, and duplicates. Check output count, lengths, and positional order. |
| 7 | Search-tree validation and insertion property | Empty trees, valid trees, deep ordering violations, duplicates, and insertion preserving validity. Include a deliberately faulty insertion in the test code and demonstrate that the property catches it. |
| 8 | Written proof of the supplied list law | Document the proof by induction. Add finite executable examples as supporting checks, clearly distinguishing them from the proof. |

The property runner should use bounded exhaustive examples with standard libraries. For Task 7, follow the supplied insertion rule: equal values belong in the left subtree, and ordering must hold across entire subtrees.

## Recommended Order and Acceptance

1. Establish the layout and repair test routing and failure reporting using Task 1 as the baseline.
2. Complete and test Tasks 2–3, then Tasks 4–6.
3. Add Task 7's tree properties and mutation demonstration.
4. Write Task 8's proof and assemble the lab evidence.

A task is complete when its documented behavior matches the assignment, its fixture and property checks pass where applicable, and its execution evidence can be regenerated.

Ignore generated builds and routine results in Git. Keep selected submission evidence separately in documentation. Before removing already tracked generated files, check whether they contain evidence worth preserving.
