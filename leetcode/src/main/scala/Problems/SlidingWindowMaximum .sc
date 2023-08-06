import scala.annotation.tailrec
import scala.collection.mutable

val nums = Array(1,3,-1,-3,5,3,6,7)
val k = 3
val n = nums.length
val ans = Array.fill(n - k + 1)(0)
val map: mutable.SortedMap[Int, Int] = mutable.SortedMap.empty

@tailrec
def initMap(idx: Int = 0): Unit = {
  if(idx == k - 1) ()
  else {
    map(nums(idx)) = map.getOrElse(nums(idx), 0) + 1
    initMap(idx + 1)
  }
}

@tailrec
def getAns(idx: Int = k - 1): Unit = {
  if(idx == n) ()
  else {
    map(nums(idx)) = map.getOrElse(nums(idx), 0) + 1
    val (mx, _) = map.last
    ans(idx - k + 1) = mx
    val occ = map(nums(idx - k + 1))
    if(occ == 1) map.remove(nums(idx - k + 1)) else map.update(nums(idx - k + 1), occ - 1)
    getAns(idx + 1)
  }
}

initMap()
getAns()

println(ans.mkString("Array(", ", ", ")"))

