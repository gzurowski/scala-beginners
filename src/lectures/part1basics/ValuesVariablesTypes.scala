package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x = 42 // compiler inters types (Int in this case)
  println(x)

  // x = 2 <-- cannot reassign => vals are immutable

  val y: Int = 25

  val aString: String = "hello"
  val anotherString = "bye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4321
  val aLong: Long = 55443311909876543L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects
  
}
