import scala.annotation.tailrec

val citations = Array(3,0,6,1,5)

val n = citations.length

citations.sortInPlace()

@tailrec
def getAns(idx: Int = 0, ans: Int = 0): Int = {
  if(idx == n) ans
  else{
    val rest = n - idx
    println(rest, citations(idx), ans)
    getAns(idx + 1, ans max rest min citations(idx))
  }
}

getAns()