fun countInRange(a: IntArray, l: Int, r: Int): Int {
  val left = lowerBound(a, l)
  val right = lowerBound(a, r + 1)

  return right - left
}

fun lowerBound(a: IntArray, target: Int): Int {
  var left = 0
  var right = a.size
  while (left < right) {
    val mid = (left + right) / 2
    if (a[mid] < target) {
      left = mid + 1
    } else {
      right = mid
    }
  }
  return left
}


fun main() {
  println(countInRange(intArrayOf(2, 3, 5, 8, 10), 3, 9))
}
