import scala.annotation.tailrec

val nums = Array(0, 2, 1, 4, 0, 7)
val n = nums.length

@tailrec
def rearrangeArray(idx: Int = 0): Unit = {
  if(idx == n)()
  else if(nums(idx) <= n && nums(idx) > 0 && nums(nums(idx) - 1) != nums(idx)) {
      val (a, b) = (nums(nums(idx) - 1), nums(idx))
      nums(nums(idx) - 1) = b
      nums(idx) = a
      rearrangeArray(idx)
  }
  else rearrangeArray(idx + 1)
}

@tailrec
def getResult(idx: Int = 0): Int = {
      if(idx == n) n + 1
      else if(idx + 1 == nums(idx)) getResult(idx + 1)
      else idx + 1
}

rearrangeArray()
println(nums.mkString("Array(", ", ", ")"))
getResult()