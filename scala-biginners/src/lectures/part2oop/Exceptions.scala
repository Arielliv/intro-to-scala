package lectures.part2oop

import java.nio.BufferOverflowException

object Exceptions extends App {
  val x: String = null
  //this will crash with NPE
  //  println(x.length)

  // throwing an catching exceptions

  // 1. throwing exceptions

  //  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    //code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed no matter what
    // optional
    // doesn't influence the return type
    println("finally")
  }

  //3. hoe to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  // throw exception

  // OOM
  //  val array = Array.ofDim(Int.MaxValue)

  // SO
  //  def infinite: Int = 1+ infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalcException extends RuntimeException("Div by zero")

  object PocketCalc {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def sub(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multi(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }


    def div(x: Int, y: Int) = {
      if (y == 0) throw new MathCalcException
      else x / y
    }
  }

  //  println(PocketCalc.add(Int.MaxValue, 10))
  //  println(PocketCalc.div(2, 0))
}
