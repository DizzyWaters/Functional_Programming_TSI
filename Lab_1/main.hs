main :: IO ()


myFunc ::  Int -> Int -> Int
myFunc x y = x*y 
main = do
    let var1 = 2
    let var2 = 3
    putStrLn "test"
    print(var1 + var2)
    putStrLn "test 2"
    print [1..25]
    print(myFunc 2 4)
