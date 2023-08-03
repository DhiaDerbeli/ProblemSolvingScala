package DataStructure

import scala.annotation.tailrec

final case class SegmentTree(initialArray: Array[Int], operation: (Int, Int) => Int) {


  val n: Int = initialArray.length

  private val treeArraySize: Int = 4 << SegmentTree.leftMostSetBit(n)
  private val treeArrayHalfSize: Int = treeArraySize / 2

  private val tree: Array[Int] = Array.fill(treeArraySize)(0)

  @tailrec
  def initializeTree(idx: Int = 0): Unit = {
    if(idx == n) ()
    else {
      tree(idx + treeArrayHalfSize) = initialArray(idx)
      initializeTree(idx + 1)
    }
  }


  def buildTree(idx: Int = 1): Unit = {
    if(idx >= treeArrayHalfSize) tree(idx)
    else {
      buildTree((idx << 1) + 1)
      buildTree(idx << 1)
      tree(idx) = operation(tree((idx << 1) + 1), tree(idx << 1))
    }
  }

  def updateTree(idx: Int, value: Int): Unit = {
    tree(idx + treeArrayHalfSize) = value
    @tailrec
    def updateNode(nodeIndex: Int): Unit = {
      if(nodeIndex == 0) ()
      else {
        tree(nodeIndex) = operation(tree(nodeIndex << 1), tree((idx >> 1) + 1))
        updateNode(nodeIndex >> 1)
      }
    }
    updateNode((idx + treeArrayHalfSize) >> 1)
  }

  def rangeQuery(left: Int, right: Int, start: Int = 0, finish: Int = treeArrayHalfSize - 1, root: Int = 1): Int = {
    if(start >= left && finish <= right) tree(root)
    else if(start > right || finish < left) 0
    else {
      val mid = (start + finish) / 2
      operation(rangeQuery(left, right, start, mid, root << 1), rangeQuery(left, right, mid + 1, finish, (root << 1) + 1))
    }
  }
}


object SegmentTree {

  @tailrec
  private def leftMostSetBit(x: Int, pos: Int = 0): Int = {
    if (x == 0) pos
    else leftMostSetBit(x >> 1, pos + 1)
  }

}