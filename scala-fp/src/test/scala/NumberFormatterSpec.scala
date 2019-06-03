import org.scalatest._

class NumberFormatterSpec extends FlatSpec with DiagrammedAssertions {
  // scalastyle:off
  it should "整数をフォーマットできる" in {
    import NumberFormatter._
    assert(format(1) === "1")
    assert(format(0) === "0")
    assert(format(-1) === "-1")
    assert(format(100) === "100")
    assert(format(-100) === "-100")
    assert(format(1000) === "1,000")
    assert(format(-1000) === "-1,000")
  }
  // scalastyle:on

}
