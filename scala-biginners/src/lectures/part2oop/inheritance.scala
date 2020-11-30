package lectures.part2oop

object inheritance extends App {

  //single class inheritance
  sealed class Animal {
    val creatureType = "wild"

    //    protected def eat = println("nommon")
    def eat = {
      println("nommon")
    }
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCart: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

  // override vs overload

  // super

  // preventing overrides
  // 1. final - use on the member
  // 2. final - use on the class
  // 3. seal the class = extend in this file, prevent extension in other files
}
