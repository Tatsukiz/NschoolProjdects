import java.text.NumberFormat

object NumberFormatter {

  def format(number: Int): String = {
    NumberFormat.getNumberInstance().format(number)
  }

}