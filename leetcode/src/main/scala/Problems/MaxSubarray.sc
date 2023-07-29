import scala.annotation.tailrec

val nums = Array(1, 2, 4, -29, 2, 3, -3, 4, -7)


// Optimized for using lists because Array.tail method has an o(n) time complexity,
// however List.head has an o(1) time complexity
@tailrec
def maxSubarray(arr: List[Int], accum: Int = 0, answer: Int = 0): Int = {
  if(arr.isEmpty) answer
  else {
    val new_accum = 0 max accum + arr.head
    val new_answer = new_accum max answer
    maxSubarray(arr.tail, new_accum, new_answer)
  }
}
maxSubarray(nums.toList)