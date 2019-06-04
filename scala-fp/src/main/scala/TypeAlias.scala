class TypeAlias {

  // defined type alias Entry
  type Entry = (Int, String)

  // defined type alias EntryList
  type EntryList = List[Entry]

  // List[(Int, String)] = List((1,one), (2,two), (3,three))
  List(1 -> "one", 2 -> "two", 3 -> "three")
}
