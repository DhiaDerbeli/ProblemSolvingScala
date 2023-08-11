import scala.annotation.tailrec

val amount = 5

val coins = Array(1,2,5)

val n = coins.length
val dp = Array.fill(n + 1, amount + 1)(0)
dp(0)(0) = 1

@tailrec
def compute(i: Int = 1, j: Int = 0): Unit = {
  if(i > n) ()
  else if(j == amount + 1) compute(i + 1)
  else {
    val toAdd = if(j >= coins(i - 1)) dp(i)(j - coins(i - 1)) else 0
    dp(i)(j) = dp(i - 1)(j) + toAdd
    compute(i, j + 1)
  }
}

compute()
dp(n)(amount)
