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
solve input = reverseName (takeWhile (/= '\n') input)

