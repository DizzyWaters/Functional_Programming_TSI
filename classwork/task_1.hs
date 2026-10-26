a,b :: Integer
a=3; b=a+1
main :: IO ()
main=do {mapM_ print [10,5+3+4,9-1];
    print (6/2::Rational);
    print (2*4+4-6);
    print $ a==b;
    print $ if b>a && b<a*b then a else b;
    print $ if a==4 then 6 else if b==4 then 6+7+a else 25}
