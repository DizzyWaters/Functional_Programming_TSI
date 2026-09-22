
TARGET = main
SRC = main.hs

$(TARGET): $(SRC)
	ghc -Wall $(SRC) -o $(TARGET)


run: $(TARGET)
	./$(TARGET)

clean:
	-rm *.o *.hi main 
