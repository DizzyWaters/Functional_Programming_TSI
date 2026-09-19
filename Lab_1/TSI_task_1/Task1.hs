module Task1 (solve) where

import Data.Char (intToDigit)

-- helpers
toNumbers :: String -> [Int]
toNumbers x  =
    map read (words x)

listString :: [Int] -> String
listString x =
    unwords (map show x)    

intString :: Int -> String
intString x =
    [intToDigit x]
    

addtList :: [Int] -> [Int]
addtList x = map (+1) x

maximumInList :: [Int] -> Int
maximumInList [x] = x
maximumInList (x:xs) =
    let i = maximumInList xs
    in
      if x > i
      then x
      else i

-- main task
solve :: String -> String
--solve x = listString(addtList(toNumbers(x)))
solve x = intString(maximumInList(toNumbers(x)))








