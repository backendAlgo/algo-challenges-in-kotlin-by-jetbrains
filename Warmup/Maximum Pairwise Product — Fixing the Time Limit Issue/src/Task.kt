fun maximumPairwiseProduct(a: IntArray): Long {
  var firstMax = Int.MIN_VALUE
  var secondMax = Int.MIN_VALUE
  for (num in a) {
    if (num > firstMax) {
      secondMax = firstMax
      firstMax = num
    } else if (num > secondMax) {
      secondMax = num
    }
  }
  return 1L * firstMax * secondMax

}
