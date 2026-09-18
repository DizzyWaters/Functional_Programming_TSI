module Task1 (solve) where

-- helpers
toNumbers :: String -> [Int]
toNumbers x  =
    map read (words x)

toString :: [Int] -> String
toString x =
    unwords (map show x)    

addtList :: [Int] -> [Int]
addtList x = map (+1) x

-- main task
solve :: String -> String

solve x = toString(addtList(toNumbers(x)))
