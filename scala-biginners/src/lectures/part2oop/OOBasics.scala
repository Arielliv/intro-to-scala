package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Ariel", 24)
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBY(author))
  println(novel.isWrittenBY(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
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

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def isWrittenBY(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = s"${this.firstName} ${this.surname}"
}

class Counter(val count: Int = 0) {
  def inc = {
    println("inc")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("dec")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
