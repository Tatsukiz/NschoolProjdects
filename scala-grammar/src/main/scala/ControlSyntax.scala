object ControlSyntax {

  def bar(): String = {
    "bar"
  }

  def printOver18(age: Int) = {
    val message = if (age < 18) {
      "18才未満です"
    } else {
      "18才以上です"
    }
    println(message)
  }

  def printWhileResult(): Unit = {
    var i = 0
    val result = while (i < 10) i = i + 1
    println(result)
  }

  def doubleLoop(): Unit = {
    for (x <- 1 to 5; y <- 1 until 5 if x != y) {
      println("x = " + x + "y = " + y)
    }
  }

  def collectionLoop(): Unit =
    for(e <- Seq("A", "B", "C", "D", "E")) println(e)

  def generateCollection(): Seq[String] =
  // yieldを指定する事で、戻り値に指定したコレクションの型で返却している。
    for(e <- Seq("A", "B", "C", "D", "E")) yield  "Pre" + e

  def printIsBaby(age: Int, isSchoolStarted: Boolean): Unit = {
    if(age <= 6 && isSchoolStarted) {
      println("幼児です")
    } else {
      println("幼児ではありません")
    }
  }

  def loopFrom0To9(): Unit = {
    var i = 0
    do {
      println(i)
      i += 1
    } while(i <= 10 )
  }

  def printRightTriangles(): Unit =
    for (a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if a * a == b * b + c * c) println((a, b, c))

}