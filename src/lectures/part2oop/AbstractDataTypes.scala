package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val createType: String = "wild"
    def eat: Unit // = abstract method / not implemented
  }

  class Dog extends Animal {
    override val createType: String = "Canine"
    def eat: Unit = println("crunch crunch") // override is optional
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // non-abstract member!!!
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val createType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit =
      println(s"I'm a crock and I'm eating ${animal.createType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = "behavior", abstract class = "thing"
}
