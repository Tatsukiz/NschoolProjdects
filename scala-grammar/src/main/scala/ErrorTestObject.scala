object ErrorTestObject {

  var map: Map[Int, String] = Map(0 -> "")
}

object Hellos extends App {
  def putHelloToCache(i:Int): Unit = {
    val hellos = ErrorTestObject.map(i)
    ErrorTestObject.map = ErrorTestObject.map + ((i + 1) -> (hellos + "hello!"))
  }

  val count = 10000000
  for (i <- 0 to count) putHelloToCache(i)

  println(ErrorTestObject.map(count))
}