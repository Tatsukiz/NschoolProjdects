object Main extends App {
  val a = 2
  val z = 3
  printMutli

  println(s"a = ${a}")

  private def printMutli = {
    println(s"答えは${a * z}")
  }
}
