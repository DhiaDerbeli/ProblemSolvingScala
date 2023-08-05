import scala.annotation.tailrec

val heights = Array(2,1,5,6,2,3)
val n = heights.length
case class Element(height: Int, occ: Int = 1)

@tailrec
def getAnswer(stack: List[Element], ans: Int = 0, count: Int = 0): Int = {
  if(stack.isEmpty)  ans
  else getAnswer(stack.tail, ans max (stack.head.height * (stack.head.occ + count)), count + stack.head.occ)
}

@tailrec
def increasingStack(stack: List[Element], element: Element, ans: Int = 0, count: Int = 0): (List[Element], Int, Int) = {
  if(stack.nonEmpty && stack.head.height >= element.height) increasingStack(stack.tail, element, ans max (stack.head.height * (stack.head.occ + count)) , count + stack.head.occ)
  else (stack, ans, count)
}


@tailrec
def getLargestRectangleArea(idx: Int = 0, stack: List[Element] = List.empty, ans: Int = 0): Int = {
  if(idx == n) ans max getAnswer(stack)
  else {
    val (newStack, newAns, count) = increasingStack(stack, Element(heights(idx)))
    getLargestRectangleArea(idx + 1, Element(heights(idx), count + 1) :: newStack, ans max newAns)
  }
}

getLargestRectangleArea()