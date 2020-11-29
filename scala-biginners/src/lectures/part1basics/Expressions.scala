package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  //! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=

  // Instructions (DO) vs Expressions (VALUE)

  //if expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // if expression
  println(aConditionValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (1 < 10) {
    println(i)
    i += 1
  }

  // everything in scala is expression!
  val aWeirdValue = (aVariable = 3) // unit === void
  println(aWeirdValue)

  //code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
}
