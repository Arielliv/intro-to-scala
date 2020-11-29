package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Ariel", 24)
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")

  // multiple constructors
  def this(name: String) = this(name, 0)
}
// class parameters are not field