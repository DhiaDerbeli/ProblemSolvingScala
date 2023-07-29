import scala.annotation.tailrec

val nums: Array[Int] = Array(1, 2, 3, 2, 3, 4)
val n = nums.length
val dp = Array.fill(n)(1)
@tailrec
def LongestIncreasingSubsequence(i: Int = 0, j: Int = 0): Unit = {
  println(i, j)
  if(i == n) ()
  else if(j == i) LongestIncreasingSubsequence(i + 1)
  else {
    println(nums(i), nums(j), dp(i), dp(j))
    if(nums(i) > nums(j)) dp(i) =  dp(i) max dp(j) + 1
    LongestIncreasingSubsequence(i, j + 1)
  }
}
LongestIncreasingSubsequence()
dp.max
