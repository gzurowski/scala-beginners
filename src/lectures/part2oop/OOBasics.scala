package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print()
  counter.inc.inc.inc.print()
  counter.inc(10).print()
}

// constructor:
// class parameters are not members/fields!
// i.e. can't access name or age externally.
// Need to add `val` to class parameters to make it a field.
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // field

  // expression
  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple/auxiliary constructors can only call other constructors!
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
 Novel and a Writer

 Writer: first name, last name, year
 - method fullname

 Novel: name, year of release, author
 - authorAge (ago of author at year of release)
 - isWrittenBy(author)
 - copy (new year of release) = new instance of Novel with new year of release
 */

class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName = s"$firstName $lastName"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge: Int = releaseYear - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(year: Int): Novel = new Novel(name, year, author)
}

/*
 Counter class
 - receives an Int value
 - method current count
 - method to increment and decrement counter by 1 => new Counter
 - overload inc/dec to receive an amount => new Counter
 */

class Counter(val count: Int = 0) {
  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n + 1)
  }

  def print(): Unit = println(count)
}
