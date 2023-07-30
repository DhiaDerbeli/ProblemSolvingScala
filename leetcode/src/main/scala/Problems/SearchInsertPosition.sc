import scala.annotation.tailrec

val nums: Array[Int] = Array(1, 5)
val target = 6
@tailrec
def findPos(left: Int = 0, right: Int = nums.length - 1): Int = {
  if(left >= right) right
  else{
    val mid = (left + right) / 2
    if(nums(mid) >= target) findPos(left, mid)
    else findPos(mid + 1, right)
  }
}
val ans = findPos()
println(if(nums(ans) < target) ans + 1 else ans)