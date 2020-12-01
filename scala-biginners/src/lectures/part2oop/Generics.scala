package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // use the type A
  }

  class MyListCovariant[+A] {
    def add[B >: A](element: B): MyListCovariant[B] = ???

    /*
    A = Cat
    B = Animal
    * */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = covariance
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? hard question -  we return list of Animals

  // 2. no = invariance
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. No no! contravariant
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)


}
