package lectures.part1basics

object CallByNameVSCallByValue extends App {

  def calledByValue(x: Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  // "=>" call by name (for lazy evaluation)
  def calledByName(x: => Long): Unit = {
    println(s"by name: $x")
    println(s"by name: $x")
  }

  calledByValue(System.nanoTime())

  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite()) // infinite() not used and never called
}
