import language.experimental.macros
import scala.reflect.macros.blackbox.Context

object MacroStudy {
  def accessor(obj: Any, property: String): Any = macro impl_accessor

  def impl_accessor(c: Context)(obj: c.Expr[Any], property: c.Expr[String]) = {
    import c.universe._
    val Expr(Literal(Constant(propString: String))) = property
    Select(obj.tree, TermName(propString))
  }
}

// 以下、REPLで入力した値と結果

// defined class User
// case class User(name: String

// User = User(taro)
// val user = User("taro")

// Any = taro
// MacroStudy.accessor(user, "name")
