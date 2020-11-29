package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 42
  println(x)

  // vals are immutable (ike const)
  // compiler can infer types

  val aString: String = "Hello"

  val ABoolean: Boolean = false
  val aChar: Char = 'a'
  val aShort: Short = 4444
  val aLong: Long = 555555555555555L
  val aFloat: Float = 2.0f
  val ADouble: Double = 3.14

  //variables
  var aVariable: Int = 4
  aVariable = 5 // side effects
}
