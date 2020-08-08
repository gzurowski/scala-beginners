package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // CAREFUL!
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  // equivalent:
  val niceIncrementer1: Int => Int = _ + 1

  val niceAdder: (Int, Int) => Int = (a, b) => a + b
  // equivalent:
  val niceAdder1: (Int, Int) => Int = _ + _

  /*
  Exercises:
  1. MyList: Replace all FunctionX calls with lambdas
  2. Rewrite the specialAdder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
