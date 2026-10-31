-- Task 5 : take list split the duplicates to sublists

module Task5 where

groupDuplicates :: Eq a => [a] -> [[a]]
groupDuplicates [] = []
groupDuplicates (x:xs) =
    let (same, rest) = span (== x) xs
    in (x:same) : groupDuplicates rest


solve :: String -> String
solve input = show (groupDuplicates (read input :: [Int]))
