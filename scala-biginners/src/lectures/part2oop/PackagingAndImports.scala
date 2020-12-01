package lectures.part2oop

import playground.{Prince => princeOne}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("ariel", "cool", 2020)

  // import the package
  //
  // import playground.Cinderella
  // val princess = Cinderella
  //
  // val princess = playground.Cinderella

  // packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED)

  // imports

  // 1. use FQ names
  // 2. use alias import
  val prince = new princeOne

  // default imports
  // java.lang = String, exceptions, Object
  // scala - Int, Nothing, Function
}
