import scala.annotation.tailrec

// dependencies for task 6
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

// Task 1: Fibonacci

object Lab3 {
  @tailrec
  def fibs(ct: Int, n1: Int = 0, n2: Int = 1,
           acc: Vector[Int] = Vector.empty): Seq[Int] = {

    if (ct <= 0) acc
    else {
      val next = n1 + n2
      fibs(ct - 1, n2, next, acc :+ next)
    }
  }

// tests to task 1

def testTask1(): Unit = {
  assert(fibs(10) == Vector(1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
  assert(fibs(5) == Vector(1, 2, 3, 5, 8))
  assert(fibs(1) == Vector(1))
  assert(fibs(0) == Vector.empty[Int])

  println("Task 1: All tests passed!")
}

// Task 2: flatMap and map

case class Address(street: String, city: String,
                   state: String, zipCode: String)

case class Person(first: String, last: String,
                  address: Option[Address])

def task2(): Seq[String] = {
  val p1 = Some(Person("Fred", "Bloggs", None))

  val p2 = Some(Person("Simon", "Jones",
    Some(Address("123 Main", "Fakesville", "AZ", "12345"))))

  val p3: Option[Person] = None

  val optPeople = Some(Seq(p1, p2, p3))

  val result = optPeople.toSeq
    .flatMap(people => people)
    .flatMap(personOpt => personOpt.toSeq)
    .flatMap(person => person.address.toSeq)
    .map(address => address.zipCode)
  result
}
// Tests to task 2
def testTask2(): Unit = {
  assert(task2() == Seq("12345"))
  println("Task 2: All tests passed!")
}

// Task 3: Return type inference

def safeDiv(n: Int, d: Int) =
  if (d == 0) None else n / d

// Tests for Task 3

def testTask3(): Unit = {
  assert(safeDiv(10, 2) == 5)
  assert(safeDiv(10, 0) == None)
  assert(safeDiv(9, 3) == 3)

  println("Task 3: All tests passed!")
}

// Task 4: Option[Int]

def safeDivOption(n: Int, d: Int): Option[Int] =
  if (d == 0) None else Some(n / d)

def task4(): List[Int] = {
  List(0, 1, 2).map(safeDivOption(5, _)).flatten
}

// Tests for Task 4

def testTask4(): Unit = {
  assert(safeDivOption(10, 2) == Some(5))
  assert(safeDivOption(10, 0) == None)
  assert(safeDivOption(9, 3) == Some(3))
  assert(task4() == List(5, 2))

  println("Task 4: All tests passed!")
}

// Task 5: Pattern matching with guards

def describeSign(n: Int): String = n match {
  case 0 => "Zero"
  case x if x > 0 => "Positive"
  case _ => "Negative"
}


// Tests for Task 5

def testTask5(): Unit = {
  assert(describeSign(0) == "Zero")
  assert(describeSign(10) == "Positive")
  assert(describeSign(-5) == "Negative")
  assert(describeSign(1) == "Positive")
  assert(describeSign(-1) == "Negative")

  println("Task 5: All tests passed!")
}

// Task 6: Asynchronous programming with Futures

def task6(): Future[String] = {

  val fa = Future { 1 }
  val fb = Future { 2 }
  val fc = Future { 3 }
  val fs = Future { "The answer is" }

  for {
    a <- fa
    b <- fb
    c <- fc
    s <- fs
  } yield {
    val sum = a + b + c
    s"$s $sum"
  }
}


// Tests for Task 6

def testTask6(): Unit = {
  val result = Await.result(task6(), 10.seconds)

  assert(result == "The answer is 6")

  println("Task 6: All tests passed!")
}

// ********** main ***********

def main(args: Array[String]): Unit = {
  println("Task 1: Fibonacci")
  println(fibs(10))
  testTask1()

  println("\nTask 2: flatMap and map")
  println("Task 2: " + task2())
  testTask2()

  println("\nTask 3: Return type inference")
  println("10 / 2 = " + safeDiv(10, 2))
  println("10 / 0 = " + safeDiv(10, 0))
  testTask3()

  println("\nTask 4: Option[Int]")
  println("10 / 2 = " + safeDivOption(10, 2))
  println("10 / 0 = " + safeDivOption(10, 0))
  println("Flatten result: " + task4())
  testTask4()

  println("\nTask 5: Pattern matching")
  println("0: " + describeSign(0))
  println("10: " + describeSign(10))
  println("-5: " + describeSign(-5))
  testTask5()

  println("\nTask 6: Asynchronous Futures")

  val result6 = Await.result(task6(), 10.seconds)

  println(result6)

testTask6()

}
}
