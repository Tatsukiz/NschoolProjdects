object CheckThenAct extends App {
  for (i <- 1 to 100) {
    new Thread(() => println(SingletonProvider.get)).start()
  }
}

object SingletonProvider {
  private[this] var singleton: BigObject = null

  def get: BigObject = {
    if (singleton == null) {
      singleton = new BigObject()
    }
    singleton
  }
}

class BigObject() {
  Thread.sleep(1000)
}


// 遅延初期化は修飾子のlazyでも実装可能
//object CheckThenAct extends App {
//  for (i <- 1 to 100) {
//    new Thread(() => println(SingletonProvider.get)).start()
//  }
//}
//
//object SingletonProvider {
//  lazy val get: BigObject = new BigObject()
//}
//
//class BigObject() {
//  Thread.sleep(1000)
//}