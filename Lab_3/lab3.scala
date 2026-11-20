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

// Task 2: flatMap and map

case class Address(street: String, city: String,
                   state: String, zipCode: String)

case class Person(first: String, last: String,
                  address: Option[Address])

def task2(): Unit = {

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

  println("Task 2: " + result)
}

// ********** main ***********

  def main(args: Array[String]): Unit = {
    println("Task 1: Fibonacci")
    println(fibs(10))
    task2()
  }


}
