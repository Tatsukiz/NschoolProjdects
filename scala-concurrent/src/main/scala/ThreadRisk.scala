object ThreadRisk extends App {

  private var counter = 0

  /** synchronizedをつけないと、スレッドセーフにならない。 */
//  def next(): Int = {
//    counter = counter + 1
//    counter
//  }

  def next(): Int = synchronized {
    counter = counter + 1
    counter
  }


  for (i <- 1 to 10) {
    new Thread(() => for(j <- 1 to 100000) println(next())).start()
  }
}

// ４つのスレッドで1から10万まで出力
object QuadNumberPrinter extends App {

  for (i <- 1 to 4) {
    new Thread(() => for(j <- 1 to 100000) println(s"thread ${i}: ${j}")).start()
  }

}

/** 一万個のスレッドが1000ミリ秒後に自分のスレッドの名前を出力 */
/** OutOfMemoryErrorが発生する */
object TenThousandNamePrinter extends App {

  for (i <- 1 to 10000) {
    new Thread(() => {
      Thread.sleep(1000)
      println(Thread.currentThread().getName)
    }).start()
  }
}