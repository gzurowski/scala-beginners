package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory methods
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // ^^ COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object is a SINGLETON instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary != john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2) // point to same object

  val bobbie = Person(mary, john) // construct with apply method

  // Scala applications = Scala object with
  // def main(args: Array[String]): Unit
}
