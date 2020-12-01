package exercies

import lectures.part2oop.Generics.MyList

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]


  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = if (t.isEmpty) "" + h else h + " " + t.printElements

  /* [1,2,3].filter(n % 2 == 0) =
  =  [2,3].filter(n % 2 == 0) =
  =  new Cons(2, new Cons([3].filter(n % 2 == 0))
  =  new Cons(2, new Cons(Empty.filter(n % 2 == 0))
  =  new Cons(2, new Cons(Empty)
  * */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /* [1,2,3].map(n*2)
  = new Cons(2, [2,3].map(n*2))
  =  new Cons(2, new Cons(4,[3].map(n*2)))
  =  new Cons(2, new Cons(4, new Cons(6,Empty.map(n*2))))
  =  new Cons(2, new Cons(4, new Cons(6,Empty)))
  * */
  def map[B](transformer: A => B): MyList[B] = new Cons(transformer(h), t.map(transformer))

  /*[1,2] ++ [3,4,5]
  * = new Cons(1, [2] ++ {3,4,5])
  * = new Cons(1, new Cons(2, Empty ++ [3,4,5])
  * = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
  * */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  /*
  * [1,2].flatMap(n => [n,n+1])
  * = [1,2] ++ [2].flatMap(n => [n+1])
  * = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  * = [1,2] ++ [2,3] ++ Empty
  * = [1,2,2,3]
  * */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTest extends App {
  val listOfInts: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val cloneListOfInts: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val anotherListOfInts: MyList[Int] = new Cons[Int](4, new Cons[Int](4, Empty))
  val listOfStrings: MyList[String] = new Cons[String]("hello", new Cons[String]("scala", Empty))

  println(listOfInts.toString)
  println(listOfStrings.toString)
  println(listOfInts.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInts.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfInts ++ anotherListOfInts).toString)
  println(listOfInts.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  println(cloneListOfInts == listOfInts)
}
