TARGET = main
SRC = main.hs
GHC = ghc

.PHONY: all default manual read super run run_manual run_read run_super test clean_all clean_trash

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

# Automatic tests use the default mode (main = interact Task1.solve)
# Command substitution removes trailing newlines, so "5" and "5\n" compare equal.
test: default
	@for i in $$(seq 1 10); do \
		actual=$$(./$(TARGET) < tests/task_1_test_$$i.txt); \
		expected=$$(cat tests/task_1_test_$${i}_expected.txt); \
		if [ "$$actual" = "$$expected" ]; then \
			echo "Test $$i: SUCCESS"; \
		else \
			echo "Test $$i: FAIL"; \
			echo "Expected: $$expected"; \
			echo "Got:      $$actual"; \
		fi; \
	done

clean_all:
	rm -f $(TARGET) *.o *.hi tests/output.tmp

clean_trash:
	rm -f *.o *.hi
