-- task 4 variant 4-5 due st83655

-- seems factorial function aka !n

module Task2 where

fac :: Integer -> Integer

fac n
    | n < 0     = error "Factorial can't be solved for negative integers input"
    | n == 0    = 1
    | otherwise = n * fac (n - 1)

solve :: String -> String
solve = show . fac . read
