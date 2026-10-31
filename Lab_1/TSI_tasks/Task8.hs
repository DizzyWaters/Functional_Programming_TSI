module Task8 where

-- Task 8
-- Prove the following law:
--
-- map f . concat = concat . map (map f)
--
-- This means that:
--
-- map f (concat xs) = concat (map (map f) xs)
--
-- We can prove this using induction on the list xs.


-- 1. Base case
--
-- Let xs = []
--
-- Left side:
-- map f (concat [])
-- = map f []
-- = []
--
-- Right side:
-- concat (map (map f) [])
-- = concat []
-- = []
--
-- Both sides are equal, so the base case is correct.


-- 2. Induction hypothesis
--
-- Assume that the law is true for xs:
--
-- map f (concat xs) = concat (map (map f) xs)


-- 3. Induction step
--
-- Now we need to prove it for (x:xs).
--
-- Start with the left side:
--
-- map f (concat (x:xs))
--
-- = map f (x ++ concat xs)              -- definition of concat
--
-- = map f x ++ map f (concat xs)        -- map distributes over ++
--
-- = map f x ++ concat (map (map f) xs)  -- induction hypothesis
--
-- = concat (map f x : map (map f) xs)   -- definition of concat
--
-- = concat (map (map f) (x:xs))         -- definition of map
--
-- We got the right side, so the induction step is correct.


-- 4. Additional property
--
-- In the proof we used:
--
-- map f (a ++ b) = map f a ++ map f b
--
-- This can also be proved by induction on a.
--
-- If a = []:
--
-- map f ([] ++ b)
-- = map f b
-- = [] ++ map f b
-- = map f [] ++ map f b
--
-- If a = (y:ys), assume the property holds for ys:
--
-- map f ((y:ys) ++ b)
-- = map f (y : (ys ++ b))
-- = f y : map f (ys ++ b)
-- = f y : (map f ys ++ map f b)
-- = map f (y:ys) ++ map f b
--
-- So this property is also correct.


-- 5. Conclusion
--
-- We proved the base case and the induction step.
-- Therefore, the law is true for all finite lists:
--
-- map f . concat = concat . map (map f)


-- Check the law using Haskell
law :: Eq b => (a -> b) -> [[a]] -> Bool
law f xs =
    map f (concat xs) == concat (map (map f) xs)


-- Process input for tests
solve :: String -> String
solve input = show (law (*2) (read input :: [[Int]]))
