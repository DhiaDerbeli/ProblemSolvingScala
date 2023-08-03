import scala.annotation.tailrec

val nums = Array(1, 3, 4, 3, 4, 2, 4)
val numsList = nums.toList

def maxProfit(l: List[Int]): (Int, Int) = {
    if(l.tail.isEmpty) (l.head, 0)
    else {
      val (a, b) = maxProfit(l.tail)
      (a max b + l.head, a)
    }
}

println(maxProfit(numsList)._1)

