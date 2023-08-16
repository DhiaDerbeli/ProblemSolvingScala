val obstacleGrid = Array.fill(5, 5)(0)

val n = obstacleGrid.length
val m = obstacleGrid(0).length
val grid: Array[Array[Int]] = Array.fill(n, m)(0)
grid(0)(0) = 1
(0 until n).foreach(i => {
  (0 until m).foreach(j => {
    obstacleGrid(i)(j) match {
      case 1 => grid(i)(j) = 0
      case _ if i > 0 && j > 0 => grid(i)(j) = grid(i)(j - 1) + grid(i - 1)(j)
      case _ if j > 0 => grid(i)(j) = grid(i)(j - 1)
      case _ if i > 0 => grid(i)(j) = grid(i - 1)(j)
      case _ => ()
    }
  })
})
grid.last.last