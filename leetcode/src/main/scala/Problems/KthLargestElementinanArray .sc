import scala.collection.mutable

val nums = Array(3,2,1,5,6,4)
val k = 2

val pq: mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty
val pqMaxSize = nums.length - k + 1

nums.foreach(element => {
  pq.enqueue(element)
  if(pq.length > pqMaxSize) pq.dequeue()
})

pq.head