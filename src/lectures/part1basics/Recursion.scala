package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(f"Computing factorial of $n - I first need factorial of ${n - 1}")
      val result = n * factorial(n - 1)
      println(f"Computed factorial of $n")
      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator
      else
        factorialHelper(x - 1, x * accumulator) // tail recursion = use recursive call as the last expression

    factorialHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 1 * 2 * 3 * 4 ... * 10)
  = 1 * 2 * 3 * 4 ... * 10
   */
  println(anotherFactorial(25000))

  // when need loops, use tail recursion
  // 1. Concatenate a string n time
  // 2. IsPrime, function tail recursive
  // 3. Fibonacci function, tail recursive

  // 1.
  def repeatString(s: String, n: Int): String = {
    @tailrec
    def repeatStringHelper(s: String, accumulator: String, n: Int): String =
      if (n < 1) accumulator
      else repeatStringHelper(s, s + accumulator, n - 1)

    repeatStringHelper(s, "", n)
  }
  println(repeatString("hello", 3))

  // 2.
  def prime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, isStillPrime = true)
  }

  println(prime(2003))
  println(prime(629))

  // 3.
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTrailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTrailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTrailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
