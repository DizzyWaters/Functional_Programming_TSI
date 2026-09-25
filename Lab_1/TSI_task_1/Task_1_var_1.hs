-- Task sort the list in descending order
-- Print the first number

-- First number of what? of sorted list?.. ok.

module Task_1_var_1 (solve) where

-- one iteration of bubble sort

bubble :: [Int] -> [Int]
bubble [] = [] -- check empty list
bubble [x] = [x] -- check same
bubble (x:y:xs)
    | x < y = y : bubble (x:xs)
    | otherwise = x : bubble (y:xs)

bubbleSort :: [Int] -> [Int]
bubbleSort xs
    | bubble xs == xs = xs
    | otherwise = bubbleSort (bubble xs)


solve :: String -> String 
solve x = unwords $ map show $ bubbleSort $ map read (words x) 

