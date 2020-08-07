package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString, ...
   */

  case class Person(name: String, age: Int)

  // 1. all class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim)

  // 3. equals and hashCode implemented OOB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method of companion object

  // 6. are serializable (Akka)

  // 7. have extractor patterns = can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Exercises:
  MyList - use case classes and case objects
 */
}
