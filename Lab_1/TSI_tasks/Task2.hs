module Task2 where

reverseName :: String -> String

reverseName [] = []


-- Bad aproach
-- Max -> aMx -> axM -> xaM
-- Raxy -> aRxy -> axRy -> axyR -> xayR -> xyaR -> yxaR


-- much better one
-- Raxy -> yaxR -> yxaR



reverseName (x:xs) = reverseName xs ++ [x]


solve :: String -> String
-- this is needed for automated testing, bash eats one space so tests fails without it
-- it can be omited if using manually!
solve input = reverseName (takeWhile (/= '\n') input)
