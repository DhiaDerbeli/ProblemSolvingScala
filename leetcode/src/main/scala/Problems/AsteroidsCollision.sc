import scala.annotation.tailrec

val asteroids: Array[Int] = Array(2, 3, 3, -5, 2)

@tailrec
def removeElements(l: List[Int], element: Int): List[Int] = {
  l.headOption match {
    case None => List(element)
    case Some(_) if element > 0 => element :: l
    case Some(x) if x * element < 0 && x.abs < element.abs => removeElements(l.tail, element)
    case Some(x) if x * element < 0 && x.abs == element.abs => l.tail
    case Some(x) if x * element < 0 => l
    case _ => element :: l
  }
}
asteroids.foldLeft[List[Int]](List.empty)(removeElements).reverse.toArray