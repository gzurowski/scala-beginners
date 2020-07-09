package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailrecFactorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailrecFactorial(n - 1, n * acc)

  val fact10 = tailrecFactorial(10)

  def savePicture(format: String = "jpg",
                  width: Int = 1920,
                  height: Int = 1080): Unit =
    println("something")

  // named arguments
  savePicture(width = 800)
}
