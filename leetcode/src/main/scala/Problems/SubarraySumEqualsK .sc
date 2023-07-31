import scala.annotation.tailrec

val nums: Array[Int] = Array(1, 3, 2, 3, 4, 5)
val k = 4

@tailrec
def subArraySum(list: List[Int] = nums.toList, map: Map[Int, Int] = Map(0 -> 1), sm: Int = 0, ans: Int = 0): Int = {
  if(list.isEmpty) ans
  else {
    val newSum = sm + list.head
    val target = newSum - k
    val targetOcc = map.getOrElse(target, 0)
    val newMap = map + (newSum -> (map.getOrElse(newSum, 0) + 1))
    subArraySum(list.tail, newMap, newSum, ans + targetOcc)
  }
}

println(subArraySum())