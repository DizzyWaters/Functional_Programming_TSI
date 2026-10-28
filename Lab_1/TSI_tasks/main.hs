{-# LANGUAGE CPP #-}
-- the global idea is to make a main module that will accept other modeles for different tasks
-- It should accept manual tests from the shell, also take a files as I/O for auto tests

-- let's try

module Main where

-- if in same folder compiler aka linker don't need additional flags - nice
import qualified Task1
import qualified Task_1_var_1
-- ok, here start some fuzzy crap, IO in hasskel :: IO () is something like void, but not exactly because it
-- breaks the paradigm, so they called it here the "monad" it roots that it's some deep philosophy crap... after it for sure megrated to math
-- and as the Hasskel is more math languge it came here. I don't want to follow this deeper.
    -- But anyway monads, here is something that goes out of pure functions and it may have effect of how the code is assambled.
manualMode :: IO ()
manualMode = do
    putStrLn "Manual mode enabled."
    putStrLn "Enter input:"
    input <- getLine
    
    -- later we can add here the block that will manipulate and parse the input as we need.
    
    -- for now let's try to just send back to stdout the stdin, later let's reverse the input, just for testing.

    putStrLn input

-- End of manual mode

 -- just a blank will try to read files, parse it. and tast it via Makefile
readFileMode :: IO ()
readFileMode = do
    let fileName = "task_1.txt"
    putStrLn ("testing next file" ++ fileName)

    input <- readFile fileName

    putStrLn "output from file:"
    putStrLn input

-- Ok, I found out getContent function that can be used instead of all the thing that are up there.

superMode :: IO ()
superMode = do
    input <- getContents
    putStrLn  (Task1.solve(input)) -- takes string and should return string

-- End of filereading module


-- Ok after few days I found the way make all this thing with main = interact.
-- Probobly this is best way to make a program as I wanted.

--                  *** Enerty point ***

--  ## I can use C preprocessor !

-- here we can comment manual part and vise-versa with readFile part for manual and auto test the tasks
main :: IO ()
#ifdef MANUAL
main = do
    manualMode
#elif READM
main = do 
    readFileMode
#elif SUPERM
main = do 
    superMode
#else
main = interact Task_1_var_1.solve  
#endif
