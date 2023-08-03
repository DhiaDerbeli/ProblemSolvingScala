import scala.annotation.tailrec

val nums = Array(1, 3, 4, 3, 4, 2, 4)
val numsList = nums.toList

@tailrec
def maxProfit(l: List[Int], a: Int = 0, b: Int = 0): Int= {
    if(l.tail.isEmpty) a max b + l.head
    else maxProfit(l.tail, a max b + l.head, a)
}

println(maxProfit(numsList))

