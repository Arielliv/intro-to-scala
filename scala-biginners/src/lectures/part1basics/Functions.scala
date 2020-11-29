package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you need to use loops, use recursion

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(5))

  def fibonacci(n: Int):Int =
    if (n<=2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(8))

  def isPrime(n:Int): Boolean = {
    def isPrimeUtil(t: Int): Boolean =
      if (t <= 1) true
      else n% t !=0 && isPrimeUtil(t-1)

    isPrimeUtil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))
}
