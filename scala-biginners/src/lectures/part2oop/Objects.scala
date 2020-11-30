package lectures.part2oop

object Objects {

  // scala does not have class level functionality ("statics")

  object Person {
    val N_EYES = 2

    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // companions
  class Person(val name: String) {
    // instance level functionality
  }

  def main(arg: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // scala object = singleton instance

    val mary = new Person("mary")
    val john = new Person("john")
    println(mary == john)

    val bobbie = Person(mary, john)

    // scala application = scala object with
    // def main(arg: Array[String]): Unit
  }
}
