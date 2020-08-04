package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String =
      s"$name is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // exercises
    def +(nickname: String): Person =
      new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(s: String): String = s"$name learns $s"
    def learnsScala(): String = learns("Scala")
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // infix notation = operator notation (syntactic sugar)
  // only works with method with a single parameter
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))
  // => ALL OPERATORS ARE METHODS!

  // prefix notation
  val x = -1 // equivalent 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent to mary.apply()

  /*
    EXERCISES:
    1. Overload the + operator
       mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
       Add a unary + operator => new Person with the age + 1
       +mary => mary with the age incremented

    3. Add a "learns" method in the Person call => "Mary learns Scala"
       Add a learnScala method, calls the learns method with "Scala" as parameter.
       Use it in postfix notation.

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */

  // 1.
  println((mary + "the Rockstar")())

  // 2.
  println((+mary).age)

  // 3.
  println(mary learns "Scala")
  println(mary learnsScala)

  // 4.
  println(mary(2))
}
