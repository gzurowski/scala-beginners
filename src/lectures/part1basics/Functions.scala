package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction) // call without parenthesis
  println(aParameterlessFunction())  // call with parenthesis

  def aRepeatedFunction(aString: String, n: Int): String = { // MUST specify return type on recursive functions!
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // when need loops, use recursion!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old
  2. Factorial function 1 * 2 * 3 * .. * n
  3. Fibonacci numbers // 1 1 2 3 5 8 13 21
     f(1) = 1
     f(2) = 1
     f(n) = f(n - 1) + f(n - 2)
   4. Function tests if a number is a prime
   */

  // 1
  def greet(name: String, age: Int) = f"Hi, my name is $name and I am $age years old"
  println(greet("Larry", 40))

  // 2
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  println(f"factorial of 5 is ${factorial(5)}")

  // 3
  def fibonacci(n: Int): Int =
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(f"fibonacci of 8 is ${fibonacci(8)}")

  // 4
  def prime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(prime(37))
  println(prime(2003))
  println(prime(37 * 17))
}
