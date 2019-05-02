trait A {
  val foo: String
}

trait B extends A {
  // lazyを付ける事で、値に初めてアクセスされた時に内容が評価されるようにできる。
  lazy val bar = foo + "World"
}

class LazyTest extends B {
  val foo = "Hello"

  def printBar(): Unit = println(bar)
}
