import scala.annotation.tailrec


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

}
}
