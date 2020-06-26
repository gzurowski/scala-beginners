package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // ... side effect
  println(aVariable)

  // instructions (do/execute) vs. expressions (value/evaluate)

  // if expression (vs. if condition)
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  // NEVER WRITE THIS AGAIN!
  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // *everything* in Scala is an expression
  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue)

  // side-effects always return `Unit` in Scala

  // side effects are: println(), while, reassigning of variables

  // code blocks: type of the block is the type of the last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" and println("hello world")
  // 2. someValue = true (Boolean), someOtherValue = 42 (Int)
  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 234 else 986
    42
  }
  println(someOtherValue)

}
