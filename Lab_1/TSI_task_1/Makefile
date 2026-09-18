TARGET = main
SRC = main.hs

$(TARGET): $(SRC)
	ghc -Wall $(SRC) -o $(TARGET)


run: $(TARGET)
	./$(TARGET)

clean_all:
	-rm main.o main.hi main 
clean_trash:
	-rm main.o main.hi
