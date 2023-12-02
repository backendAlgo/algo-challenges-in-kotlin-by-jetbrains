fun countSegmentsForEach(points: IntArray, segments: Array<Pair<Int, Int>>): IntArray {
  val solveUsingBeforeAfterForEachPoint = SolveUsingBeforeAfterForEachPointResolveAfter6Days(points, segments)
  return solveUsingBeforeAfterForEachPoint.count()

}

class SolveUsingBeforeAfterForEachPointResolveAfter6Days(private val points: IntArray, private val segments: Array<Pair<Int, Int>>) {
  fun count(): IntArray {
    val starts = segments.map { it.first }.sorted()
    val ends = segments.map { it.second }.sorted()
    val segmentsSize = segments.size
    return points.map { segmentsSize - countSegmentsBeforePoint(it, ends) - countSegmentsAfterPoint(it, starts) }
      .toIntArray()
  }

  private fun countSegmentsBeforePoint(point: Int, ends: List<Int>): Int {
    var low = 0
    var high = ends.size
    while (low < high) {
      val mid = (low + high) / 2
      if (ends[mid] < point) {
        low = mid + 1
      } else {
        high = mid
      }
    }
    return low
  }

  private fun countSegmentsAfterPoint(point: Int, starts: List<Int>): Int {
    var low = 0
    var high = starts.size
    while (low < high) {
      val mid = (low + high) / 2
      if (starts[mid] <= point) {
        low = mid + 1
      } else {
        high = mid

      }
    }
    return starts.size - low
  }
}


