package lectures.part2oop

object MethodsNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${this.name} wtf?"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is ${this.name} and i like ${favoriteMovie}"
  }

  val mary = new Person("mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))
  println(1.+(2))

  // -all operators are methods-
  // akka actors have ! ?

  //prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only work with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
//  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent
}
