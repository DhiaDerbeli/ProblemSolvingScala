package DataStructure

trait SegmentTree[+T]{
  def value: T
  def isEmpty: Boolean

  def search(low: Int, high: Int): Option[T]

}

object Empty extends SegmentTree[Nothing] {
  def value = throw new NoSuchElementException
  override def isEmpty: Boolean = true

  override def search(low: Int, high: Int) : Option[Nothing] = None
}

case class Cons[T](element: T, leftChild: SegmentTree[T], rightChild: SegmentTree[T], leftBound: Int, rightBound: Int, operation: (T, T) => T)  extends SegmentTree[T]{
  override def value: T = element

  override def isEmpty: Boolean = false

  def search(low: Int, high: Int): Option[T] = {
    val res = if(low <= leftBound && high >= rightBound) Some(value)
    else if(low > rightBound || high < leftBound) None
    else {
      val leftSearch = leftChild.search(low, high)
      val rightSearch = rightChild.search(low, high)
      (leftSearch, rightSearch) match {
        case (Some(l), Some(r)) => Some(operation(r, l))
        case (Some(l), _) => Some(l)
        case (_, Some(r)) => Some(r)
        case _ => None
      }
    }
    println(leftBound, rightBound, res)
    res
  }
}

object SegmentTree extends App {
  def apply[T](array: Array[T], operation: (T, T) => T): SegmentTree[T] = {
    def constructTree(leftBound: Int, rightBound: Int): SegmentTree[T] = {
      if(leftBound >= rightBound) Cons(array(leftBound), Empty, Empty, leftBound, rightBound, operation)
      else {
        val mid = (leftBound + rightBound) / 2
        val leftChild = constructTree(leftBound, mid)
        val rightChild = constructTree(mid + 1, rightBound)
        Cons(operation(leftChild.value, rightChild.value), leftChild, rightChild, leftBound, rightBound, operation)
      }
    }
    constructTree(0, array.length - 1)
  }

  val array = Array(1, 2, 3, 2, 3, 4)
  val min: (Int, Int) =>  Int = (x, y) => if(x < y) x else y
  val segmentTree = SegmentTree[Int](array, min)
  println(segmentTree.search(0, 1))
}