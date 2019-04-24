object DayOfWeek {

  def toNum(day: DayOfWeek): Int = {
    day match {
      case Sunday => 1
      case Monday => 2
      case TuesDay => 3
      case Wednesday => 4
      case Thursday => 5
      case Friday => 6
      case Saturday => 7
    }
  }

}

sealed abstract class DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object TuesDay extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

