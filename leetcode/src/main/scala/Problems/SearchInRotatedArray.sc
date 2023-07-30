import scala.annotation.tailrec

val nums: Array[Int] = Array(8, 9, 1, 5)
val target = 2

val n = nums.length
@tailrec
def findMinPos(left: Int = 0, right: Int = n - 1): Int = {
  if(nums(left) <= nums(right)) left
  else {
    val mid = (left + right) / 2
    if(nums(mid) <= nums(right)) findMinPos(left, mid)
    else findMinPos(mid + 1, right)
  }
}

val minPos = findMinPos()
@tailrec
def findTarget(left: Int = minPos, right: Int = minPos + n - 1): Int = {
  println(left, right)
  if(left>= right) left
  else {
    val mid = (left + right) / 2
    if(nums(mid % n) < target) findTarget(mid + 1, right)
    else findTarget(left, mid)
  }
}

val ans = findTarget()
println(if (nums(ans % n) == target) ans % n else -1)