-- Task 6, var 4-5 due st83655.
-- Implement the function split 

module Task6 where

split :: Int -> [a] -> [[a]]
split n xs  
    | n <= 0    = error "ERROR: invalid group size"
    | null xs   = []
    | otherwise = first : split n rest
    where
        (first, rest) = splitAt n xs

solve :: String -> String
solve input = show (split n xs)
    where
        n = read (head (lines input)) :: Int
        xs = read (lines input !! 1) :: [Int]
