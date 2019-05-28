class Stre {

  // scala.collection.immutable.Stream[Int] = Stream(1, ?)
  val s = 1 #:: 2 #:: 3 #:: 4 #:: Stream.empty

  // Int = 1
  s(0)

  // res1: Int = 2
  s(1)

  // List[Int] = List(1, 2, 3, 4)
  s.toList

  // Stream[Int] = Stream(8, ?)
  val eights: Stream[Int] = 8 #:: eights

  // 遅延評価
  // Int = 8
  eights(100)

  // Int = 8
  eights(10000)

  // 余再帰
  // scala.collection.immutable.Stream[Int] = Stream(1, ?)
  val str = Stream.iterate(1) {
    n =>
      println("Calculate! 3 + " + n)
      3 + n
  }

  // Int = 1
  str(0)

  // Calculate! 3 + 1
  // Int = 4
  str(1)

  // s(2)
  // Calculate! 3 + 4
  str(2)

  // 遅延初期化
  // ten: Int = <lazy>
  lazy val ten = {
    println("Calculate! ten")
    2 * 5
  }

  // Calculate! ten
  // Int = 10
  ten

  // Int = 10
  ten

  // List[(Int, Int)] = List((1,10), (2,20), (3,30))
  List(1, 2, 3).zip(List(10, 20, 30))

  // フィボナッチ数列
  // fibs: Stream[Int] = Stream(0, ?)
  val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  // 0
  //  1
  //  1
  //  2
  //  3
  //  5
  //  8
  //  13
  //  21
  //  34
  fibs.take(10).foreach(println)

  // benchmark: [T](f: => T)T
  def benchmark[T](f: => T) = {
    val begin = System.currentTimeMillis()
    val result = f
    val end = System.currentTimeMillis()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)} ミリ秒")
    result
  }

  // time: 13 ミリ秒
  // Int = 564
  benchmark{
    fibs.filter(x => x % 2 == 0).map(x => x * 3).take(5).foldLeft(0)(_ + _)
  }

  // 暗黙 //
  // import scala.language.implicitConversions
  import scala.language.implicitConversions

  // intToBoolean: (arg: Int)Boolean
  implicit def intToBoolean(arg: Int): Boolean = arg != 0

  // 1は真なり
  if(1) println("1は真なり")


}

// pimp my library パターンの実装

// ↓出力
/** defined class RichString */

// scala コンソールの入力値↓
/** implicit class RichString(val src: String) {
  def smile: String = src + ":-)"
}
  */

  //出力↓
  /** String = Hi, :-) */
  // scala コンソールの入力値↓
  /** "Hi, ".smile */
