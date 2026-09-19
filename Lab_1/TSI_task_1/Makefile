TARGET = main
SRC = main.hs

$(TARGET): $(SRC)
	ghc $(SRC) -o $(TARGET)


run: $(TARGET)
	./$(TARGET)
test: main
	@for i in $$(seq 1 10); do \
		./main < tests/task_1_test_$$i.txt > tests/output.tmp; \
		if cmp -s tests/output.tmp tests/task_1_test_$${i}_expected.txt; then \
			echo "Test $$i: SUCCESS"; \
		else \
			echo "Test $$i: FAIL"; \
			echo "Expected:"; \
			cat tests/task_1_test_$${i}_expected.txt; \
			echo "Got:"; \
			cat tests/output.tmp; \
			echo; \
		fi; \
	done
	@rm -f tests/output.tmp

clean_all:
	-rm main.o main.hi main tests/output.tmp 
clean_trash:
	-rm *.o *.hi
