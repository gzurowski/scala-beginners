package lectures.part3fp

object WhatsAFunction extends App {
  // Use functions as first class elements
  // Problem: OOP
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTION ARE OBJECTS

  val stringConcatenator: (String, String) => String =
    new Function2[String, String, String] {
      override def apply(s1: String, s2: String): String = s1 + s2
    }

  println(stringConcatenator("Hello", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] =
    new Function[Int, Function1[Int, Int]] {
      override def apply(x: Int): Int => Int = new Function1[Int, Int] {
        override def apply(y: Int): Int = x + y
      }
    }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B = ???
}

/*
Exercises:

1. a function which takes 2 strings and concatenates them
2. MyList: transform the MyPredicate and MyTransformer into function types
3. define a function takes an Int and returns another function which takes an int and returns an int
  - what's the types of the function
  - how to do it
 */
