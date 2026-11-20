import scala.annotation.tailrec

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

  def main(args: Array[String]): Unit = {
    println("Task 1: Fibonacci")
    println(fibs(10))
  }
}
