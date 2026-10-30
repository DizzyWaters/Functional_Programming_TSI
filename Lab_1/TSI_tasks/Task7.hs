-- Task 7 Binary tree




module Task7 where

data Tree a = Branch a (Tree a) (Tree a) | Leaf
    deriving (Show, Read)

isSearchTree :: Ord a => Tree a -> Bool
isSearchTree = check Nothing Nothing
    where
        check _ _ Leaf = True
        check lower upper (Branch x li re) =
            maybe True (x >) lower
            && maybe True (x <=) upper
            && check lower (Just x) li
            && check (Just x) upper re

insertTree :: Ord a => a -> Tree a -> Tree a
insertTree e Leaf = Branch e Leaf Leaf
insertTree e (Branch x li re)
    | e <= x    = Branch x (insertTree e li) re
    | otherwise = Branch x li (insertTree e re)

property :: Ord a => a -> Tree a -> Bool
property x tree =
    isSearchTree tree && isSearchTree (insertTree x tree)

solve :: String -> String
solve input =
    case lines input of
        ["check", tree] ->
            show (isSearchTree (read tree :: Tree Int))

        ["property", value, tree] ->
            show (property (read value :: Int)
                           (read tree :: Tree Int))

        _ -> error "ERROR: invalid input"
