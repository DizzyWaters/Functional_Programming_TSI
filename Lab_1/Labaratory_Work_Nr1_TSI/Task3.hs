-- task 3, variant 5 due st83655


module Task3 where

import Data.Char (toUpper)

capitalizeWord :: String -> String
capitalizeWord [] = []
capitalizeWord (x:xs) = toUpper x : xs

reducer :: String -> String -> String
reducer current word 
    | null current = capitalizeWord word
    | otherwise = current ++ " " ++ capitalizeWord word

solve :: String -> String
solve input = foldl reducer "" (words input)
