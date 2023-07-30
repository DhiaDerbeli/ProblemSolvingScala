import scala.annotation.tailrec

val nums: Array[Int] = Array( 7, 8, 1, 3, 5, 6)
@tailrec
def findPos(left: Int = 0, right: Int = nums.length - 1): Int = {
  if(nums(left) <= nums(right)) left
  else {
    val mid = (left + right) / 2
    if(nums(mid) <= nums(right)) findPos(left, mid)
    else findPos(mid + 1, right)
  }
}
println(nums(findPos()))