TARGET = main
SRC = main.hs
GHC = ghc

TEST1_DIR = tests/test_1
REVERSE_TEST_DIR = tests/task1_reverse_sort_tests/tests

RESULTS_DIR = test_results
TEST1_RESULTS_DIR = $(RESULTS_DIR)/results_1
REVERSE_RESULTS_DIR = $(RESULTS_DIR)/results_reverse_sort

.PHONY: all default manual read super run run_manual run_read run_super \
        test test_reverse_sort test_all clean_all clean_trash

# Default mode: uses the #else branch in main.hs
all: default

default:
	$(GHC) $(SRC) -o $(TARGET)

# Compile with: #ifdef MANUAL
manual:
	$(GHC) -DMANUAL $(SRC) -o $(TARGET)

# Compile with: #ifdef READM
read:
	$(GHC) -DREADM $(SRC) -o $(TARGET)

# Compile with: #ifdef SUPERM
super:
	$(GHC) -DSUPERM $(SRC) -o $(TARGET)

# Build and run each mode
run: default
	./$(TARGET)

run_manual: manual
	./$(TARGET)

run_read: read
	./$(TARGET)

run_super: super
	./$(TARGET)

# Original Task 1 tests
# Input:    tests/test_1/task_1_test_N.txt
# Expected: tests/test_1/task_1_test_N_expected.txt
# Logs:     test_results/results_1/task_1_test_N.log
test: default
	@mkdir -p $(TEST1_RESULTS_DIR)
	@for i in $$(seq 1 10); do \
		actual=$$(./$(TARGET) < $(TEST1_DIR)/task_1_test_$$i.txt); \
		expected=$$(cat $(TEST1_DIR)/task_1_test_$${i}_expected.txt); \
		log="$(TEST1_RESULTS_DIR)/task_1_test_$$i.log"; \
		if [ "$$actual" = "$$expected" ]; then \
			echo "Test $$i: SUCCESS"; \
			printf "Test %s: SUCCESS\nExpected: %s\nGot:      %s\n" \
				"$$i" "$$expected" "$$actual" > "$$log"; \
		else \
			echo "Test $$i: FAIL"; \
			echo "Expected: $$expected"; \
			echo "Got:      $$actual"; \
			printf "Test %s: FAIL\nExpected: %s\nGot:      %s\n" \
				"$$i" "$$expected" "$$actual" > "$$log"; \
		fi; \
	done
	@echo "Logs saved in $(TEST1_RESULTS_DIR)/"

# Task 1 descending/reverse sort tests
# Input:    tests/task1_reverse_sort_tests/tests/test_task1_reverse_sort_N.txt
# Expected: tests/task1_reverse_sort_tests/tests/expected_task1_reverse_sort_N.txt
# Logs:     test_results/results_reverse_sort/test_task1_reverse_sort_N.log
test_reverse_sort: default
	@mkdir -p $(REVERSE_RESULTS_DIR)
	@for i in $$(seq 1 10); do \
		actual=$$(./$(TARGET) < $(REVERSE_TEST_DIR)/test_task1_reverse_sort_$$i.txt); \
		expected=$$(cat $(REVERSE_TEST_DIR)/expected_task1_reverse_sort_$$i.txt); \
		log="$(REVERSE_RESULTS_DIR)/test_task1_reverse_sort_$$i.log"; \
		if [ "$$actual" = "$$expected" ]; then \
			echo "Reverse sort test $$i: SUCCESS"; \
			printf "Reverse sort test %s: SUCCESS\nExpected: %s\nGot:      %s\n" \
				"$$i" "$$expected" "$$actual" > "$$log"; \
		else \
			echo "Reverse sort test $$i: FAIL"; \
			echo "Expected: $$expected"; \
			echo "Got:      $$actual"; \
			printf "Reverse sort test %s: FAIL\nExpected: %s\nGot:      %s\n" \
				"$$i" "$$expected" "$$actual" > "$$log"; \
		fi; \
	done
	@echo "Logs saved in $(REVERSE_RESULTS_DIR)/"

# Run both test suites
test_all: test test_reverse_sort

# Remove compiled program, GHC files and generated test logs
clean_all:
	rm -f $(TARGET) *.o *.hi
	rm -rf $(RESULTS_DIR)

# Remove only GHC temporary files
clean_trash:
	rm -f *.o *.hi
