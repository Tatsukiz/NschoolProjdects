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



}
