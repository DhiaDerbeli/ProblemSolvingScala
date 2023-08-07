import scala.collection.mutable

val buildings: Array[Array[Int]] = Array(Array(2,9,10),Array(3,7,15),Array(5,12,12),Array(15,20,10),Array(19,24,8))

val buildingsReformatted = buildings.flatMap(building => Array((building(0), building(2), 1), (building(1), building(2), -1)))

val sortedBuildings = buildingsReformatted.sorted

val sortedMap: mutable.SortedMap[Int, Int] = mutable.SortedMap(0 -> 1)

val buildingsGroupedByPosition: mutable.SortedMap[Int, List[(Int, Int)]] = mutable.SortedMap.empty

sortedBuildings.map(element => {
  val (pos, height, occ) = element
  val prevList = buildingsGroupedByPosition.getOrElse(pos, List.empty)
  buildingsGroupedByPosition(pos) = (height, occ) :: prevList
})


val ans = buildingsGroupedByPosition.map{ element =>
  val(pos, list) = element
  list.foreach { element =>
    val (height, occ) = element
    val prevOcc = sortedMap.getOrElse(height, 0)
    if(prevOcc + occ == 0) sortedMap.remove(height)
    if(prevOcc + occ > 0) sortedMap(height) = occ + prevOcc
  }
  List(pos, sortedMap.last._1)
}.toList

def removeConsecutiveDuplicates(lst: List[List[Int]]): List[List[Int]] = {
  lst.foldLeft(List.empty: List[List[Int]]) { (result, current) =>
    result match {
      case Nil => List(current)
      case head :: _ if head.last == current.last => result
      case _ => current :: result
    }
  }.reverse
}

removeConsecutiveDuplicates(ans)
