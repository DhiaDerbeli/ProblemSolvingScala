import scala.collection.mutable
import scala.math.abs

val nums = Array(1,5,9,1,5,9)
val indexDiff = 1
val valueDiff = 2
val map: mutable.SortedMap[Int, Int] = mutable.SortedMap.empty
val n = nums.length

def containsDuplicate(idx: Int = 0): Boolean = {
  if(idx == n) false
  else{
    if(idx > indexDiff) {
      val removedElement = nums(idx - indexDiff - 1)
      val occ = map(removedElement)
      if(occ == 1) map.remove(removedElement)
      else map(removedElement) = occ - 1
    }
    val target = map.rangeFrom(nums(idx) - valueDiff)
    val ans = target.headOption match {
      case Some((x, _)) => if(abs(x - nums(idx)) <= valueDiff) true else false
      case _ => false
    }
    map(nums(idx)) = map.getOrElse(nums(idx), 0) + 1
    ans || containsDuplicate(idx + 1)
  }
}

containsDuplicate()