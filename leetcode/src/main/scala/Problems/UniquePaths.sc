val n = 3
val m = 7
val grid: Array[Array[Int]] = Array.fill(n)(Array.fill(m)(1))
(1 until n).foreach(i => {
  (1 until m).foreach(j => {
    grid(i)(j) = grid(i - 1)(j) + grid(i)(j - 1)
  })
})
grid.last.last