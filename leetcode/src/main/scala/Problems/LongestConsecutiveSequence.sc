import scala.annotation.tailrec

val nums = Array(1, 4, 6, 2)

nums.sortInPlace()
val n = nums.length

@tailrec
def getAns(idx: Int = 1, ans: Int = 1, count: Int = 1): Int = {
  if(idx >= n) ans
  else {
    val newCount = nums(idx) match {
      case x if x == nums(idx - 1) => count
      case x if x == nums(idx - 1) + 1 => count + 1
      case _ => 1
    }
    getAns(idx + 1, ans max newCount, newCount)
  }
}
if(n == 0) 0 else getAns()