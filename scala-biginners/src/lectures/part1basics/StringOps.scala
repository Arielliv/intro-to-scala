package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning scala"

  // java
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // scala specific

  // s- interpolators

  val name = "Ariel"
  val age = 24

  val greetings = s"Hello, my name is $name and I am $age years old"
  println(greetings)
  val anotherGreetings = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreetings)

  // f- interpolators

  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw- interpolators

  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
