class RangeSum(a: IntArray) {
  private val rangeSum = a.runningFold(0L) { acc, curr ->
    acc + curr
  }.toLongArray()

  fun getSum(left: Int, right: Int): Long {
    return rangeSum[right] - rangeSum[left]
  }

}

