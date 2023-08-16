
import scala.annotation.tailrec
import scala.collection.immutable.HashSet

val nums = Array(4,4,4,5,6)

val n = nums.length

@tailrec
def getAns(idx: Int = 0, dp: HashSet[Int]= HashSet(0)): Boolean = {
  if(idx == n && dp.contains(idx)) true
  else if(idx == n) false
  else if(!dp.contains(idx)) getAns(idx + 1, dp)
  else{
    val newDp1 = if(idx < n - 1 && nums(idx) == nums(idx + 1)) dp + (idx + 2) else dp
    val newDp2 = if(idx < n - 2 && nums(idx) == nums(idx + 1) && nums(idx) == nums(idx + 2)) newDp1 + (idx + 3) else newDp1
    val newDp3 = if(idx < n - 2 && nums(idx) == nums(idx + 1) - 1 && nums(idx) == nums(idx + 2) - 2) newDp2 + (idx + 3) else newDp2
    getAns(idx + 1, newDp3)
  }
}

getAns()