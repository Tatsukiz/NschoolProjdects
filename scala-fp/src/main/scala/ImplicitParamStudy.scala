object ImplicitParamStudy {

  class Connection {
    def executeQuery(query: String): Unit = println(s"Execute: ${query}")
  }

  def createTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"create title='${title}'")

  def selectTitle(implicit conn: Connection): Unit = conn.executeQuery(s"select")

  def updateTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"update title='${title}'")

  def deleteTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"delete title='${title}'")

}
// ↓出力
/** ImplicitParamStudy.Connection = ImplicitParamStudy$Connection@2864f887 */
// ↓Scala Console
/** implicit val connection = new ImplicitParamStudy.Connection*/



// 暗黙引数を定義
// ↓出力
/** create title='暗黙' */
// ↓Scala Console
/** ImplicitParamStudy.createTitle("暗黙") */

// ↓出力
/** select */
// Scala Console
/** ImplicitParamStudy.selectTitle */

// ↓出力
/** update title='暗黙' */
// ↓ Scala Console
/** ImplicitParamStudy.updateTitle("暗黙") */

// ↓出力
/** delete title='暗黙' */
// ↓Scala Console
/** ImplicitParamStudy.deleteTitle("暗黙") */

// 暗黙引数を利用せず、引数を明示して定義
// ↓出力
/** create title='暗黙' */
// ↓ ScalaConsole
/** ImplicitParamStudy.createTitle("暗黙")(new ImplicitParamStudy.Connection) */
