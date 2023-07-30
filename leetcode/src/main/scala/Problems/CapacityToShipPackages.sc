import scala.annotation.tailrec

val weights: Array[Int] = Array(1,2,3,4,5,6,7,8,9,10)
val days = 5

val mn_cap = weights.max
val mx_cap = weights.sum

@tailrec
def getMinCap(mn: Int, mx: Int): Int = {
  if(mn >= mx) mx
  else {
    val mid = (mn + mx) / 2

    @tailrec
    def getNumbreOfDays(w: List[Int], accum: Int = 0, ans: Int = 0): Int = {
      if(w.isEmpty) if(accum > 0) ans + 1 else ans
      else if(accum + w.head > mid) getNumbreOfDays(w, ans = ans + 1)
      else getNumbreOfDays(w.tail, accum + w.head, ans)
    }

    val nbDays = getNumbreOfDays(weights.toList)
    if(nbDays > days) getMinCap(mn = mid + 1, mx)
    else getMinCap(mn, mid)
  }
}

println(getMinCap(mn_cap, mx_cap))