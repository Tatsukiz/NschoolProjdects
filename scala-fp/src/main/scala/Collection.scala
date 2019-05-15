class Collection {

  // Seq[Int] = List(1, 2, 3)
  val seq = Seq(1, 2, 3)

  // List[Int] = List(1, 2, 3)
  val list = List(1, 2, 3)

  // scala.collection.immutable.Nil.type = List()
  Nil

  // List[Int] = List(3)
  3 :: Nil

  // List[Int] = List(1, 2, 3)
  1 :: 2 :: 3 :: Nil

  // scala.collection.immutable.Range.Inclusive = Range 1 to 5
  1 to 5

  // List[Int] = List(1, 2, 3, 4, 5)
  (1 to 5).toList

  // name: String = tatsuki
  val name = "tatsuki"

  // Char = a
  name(1)

  // String = TATSUKI
  name.map(c => c.toUpper)

  // String tatski
  name.filter(c => c != 'u')

  // scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val s = Set(1, 1, 2, 2, 3, 3)

  // scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  val s1 = Set(1, 2, 3)

  // scala.collection.immutable.Set[Int] = Set(3, 4, 5)
  val s2 = Set(3, 4, 5)

  // scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4)
  s1 ++ s2

  // scala.collection.immutable.Set[Int] = Set(1, 2)
  s1 -- s2

  // scala.collection.immutable.Set[Int] = Set(3)
  s1.intersect(s2)

  // scala.collection.immutable.TreeSet[Int] = TreeSet(1, 2, 3, 4, 5)
  val tree = scala.collection.immutable.TreeSet(1, 2, 3, 4, 5)

  // scala.collection.immutable.TreeSet[Int] = TreeSet(1, 3, 4, 5)
  tree.filter(i => i != 2)

  // scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)
  val m = Map("a" -> 1, "b" -> 2, "c" -> 3)

  // Option[Int] = Some(1)
  m.get("a")

  // Option[Int] = None
  m.get("d")

  // List[(String, Int)] = List((a,1), (b,2), (c,3))
  val mList = m.toList

  // scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)
  mList.toMap

  // scala.collection.immutable.TreeMap[String,Int] = Map(a -> 1, b -> 2, c -> 3)
  val mTreeMap = scala.collection.immutable.TreeMap("a" -> 1, "b" -> 2, "c" -> 3)

  // scala.collection.immutable.TreeMap[String,Int] = Map(a -> 1, c -> 3)
  mTreeMap - "b"

  // scala.collection.immutable.Stack[Nothing] = Stack()
  val stack = scala.collection.immutable.Stack()

  // scala.collection.immutable.Stack[Int] = Stack(1)
  val stack2 = stack.push(1)

  // scala.collection.immutable.Stack[Int] = Stack(2, 1)
  val stack3 = stack2.push(2)

  // (Int, scala.collection.immutable.Stack[Int]) = (1,Stack())
  val stack4 = stack3.pop2

  // scala.collection.immutable.Queue[Nothing] = Queue()
  val queue = scala.collection.immutable.Queue()

  // scala.collection.immutable.Queue[Int] = Queue(1)
  val queue2 = queue.enqueue(1)

  // scala.collection.immutable.Queue[Int] = Queue(1, 2)
  val queue3 = queue2.enqueue(2)

  // (Int, scala.collection.immutable.Queue[Int]) = (1,Queue(2))
  val queue4 = queue3.dequeue

  // (Int, scala.collection.immutable.Queue[Int]) = (2,Queue())
  queue4._2.dequeue

  // scala.collection.mutable.PriorityQueue[Int] = PriorityQueue()
  val q = new scala.collection.mutable.PriorityQueue[Int]

  q.enqueue(3)
  q.enqueue(2)
  q.enqueue(1)
  q.enqueue(7)
  q.enqueue(8)
  q.enqueue(9)

  // Int = 9
  q.dequeue()

  // Int = 8
  q.dequeue()

 // Int = 7
  q.dequeue()

  // Int = 3
  q.dequeue()

  // Int = 2
  q.dequeue()

  // Int = 1
  q.dequeue()

  // java.util.NoSuchElementException: no element to remove from heap
  //    at scala.collection.mutable.PriorityQueue.dequeue(PriorityQueue.scala:222)
  //  ... 24 elided
  q.dequeue()


  // ベンチマークの計測
  def benchmark(f: => Unit) = {
    val begin = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    val formatter = java.text.NumberFormat.getNumberInstance()
    println(s"time: ${formatter.format(end - begin)} ミリ秒")
  }

  // time: 1,894 ミリ秒
  benchmark {
    var list = List[Int]()
    for(i <- 0 to 10000){
      list = list :+ i
    }
  }

  // time: 119 ミリ秒
  benchmark{
    var array = Array[Int]()
    for(i <- 0 to 10000){
      array = array :+ i
    }
  }

  // time: 21 ミリ秒
  benchmark {
    var list = List[Int]()
    for(i <- 0 to 10000){
      list = i +: list
    }
  }

  // time: 123 ミリ秒
  benchmark {
    var array = Array[Int]()
    for(i <- 0 to 10000){
      array = i +: array
    }
  }

  // List[Int] = List(1, 2, 3, 4)
  1 :: 2 :: 3 :: 4 :: Nil

  // List[Int] = List(1, 2, 3, 4)
  List(1, 2) ++ List(3, 4)

  // List[Int] = List(1, 3, 4, 5)
  List(1) ++ List(3,4,5)

  // List[Int] = List(3, 4, 5, 1)
  List(3, 4, 5) ++ List(1)

  // String = 12345
  List(1, 2, 3, 4, 5).mkString

  // String = 1,2,3,4,5
  List(1, 2, 3, 4, 5).mkString(",")

  // String = [1,2,3,4,5]
  List(1, 2, 3, 4, 5).mkString("[", ",", "]")

  // (1 * 2) + (1 * 3) + (1 * 4)と言う風に畳み込みながら計算されている。
  // Int = 24
  List(2, 3, 4).foldLeft(1)((x, y) => x * y)




}