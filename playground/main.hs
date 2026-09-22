main :: IO ()
main = interact myFunc 

-- sum of two numbers
myFunc :: String -> String
myFunc input = show(mySum $ numbers(input))

numbers :: String -> [Int]
numbers input = map read (words input) 

mySum :: [Int] -> Int
mySum[] = 0
mySum(x:xs) = x + mySum xs 
