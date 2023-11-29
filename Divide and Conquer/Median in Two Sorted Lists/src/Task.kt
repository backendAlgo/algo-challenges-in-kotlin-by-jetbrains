fun main() {
  println(getMedian(listOf(1, 2, 5), listOf(3, 4, 6)))
}


fun <T : Comparable<T>> getMedian(first: List<T>, second: List<T>): T {
  val mergeAndFinder = MergeAndFinderBetter(first, second)
  return mergeAndFinder.findMedian()

}

/**
 * TIME COMPLEXITY: O(log(min(x, y)))
 */
class MergeAndFinderBetter<T : Comparable<T>>(private val first: List<T>, private val second: List<T>) {
  fun findMedian(): T {
    lateinit var first: List<T>
    lateinit var second: List<T>
    if (this.first.size > this.second.size) {
      first = this.second
      second = this.first
    } else {
      first = this.first
      second = this.second
    }
    val x = first.size
    val y = second.size
    var low = 0
    var high = x
    val halfSize = (x + y + 1) / 2
    while (low <= high) {
      val m1 = (low + high) / 2
      val m2 = halfSize - m1
      val l1 = if (m1 == 0) null else first[m1 - 1]
      val r1 = if (m1 == x) null else first[m1]
      val l2 = if (m2 == 0) null else second[m2 - 1]
      val r2 = if (m2 == y) null else second[m2]
      val maxLeft = if (l1 == null) l2!! else if (l2 == null) l1 else maxOf(l1, l2)
      val minRight = if (r1 == null) r2!! else if (r2 == null) r1 else minOf(r1, r2)
      if (maxLeft <= minRight) {
        return maxLeft
      } else if (l1 != null && r2 != null && l1 > r2) {
        high = m1 - 1
      } else {
        low = m1 + 1
      }
    }
    throw IllegalStateException("if both arrays sorted and input is valid, then cannot be here")
  }
}

/**
 * TIME COMPLEXITY: O(log(m) + log(n))
 */

class MergeAndFinder<T : Comparable<T>>(val first: List<T>, val second: List<T>) {
  fun getValue(k: Int): T {
    return solve(0, first.size - 1, 0, second.size - 1, k)
  }

  fun solve(
    firstStart: Int,
    firstEnd: Int,
    secondStart: Int,
    secondEnd: Int,
    k: Int
  ): T {
    //WHEN SEGMENT IS EMPTY, WE ARE DONE
    if (firstStart > firstEnd) {
      return second[k - firstStart]
    } else if (secondStart > secondEnd) {
      return first[k - secondStart]
    }

    val firstMid = (firstStart + firstEnd) / 2
    val secondMid = (secondStart + secondEnd) / 2

    return if (k > firstMid + secondMid) {
      if (first[firstMid] > second[secondMid]) {
        solve(firstStart, firstEnd, secondMid + 1, secondEnd, k)
      } else {
        solve(firstMid + 1, firstEnd, secondStart, secondEnd, k)
      }
    } else {
      if (first[firstMid] > second[secondMid]) {
        solve(firstStart, firstMid - 1, secondStart, secondEnd, k)
      } else {
        solve(firstStart, firstEnd, secondStart, secondMid - 1, k)
      }
    }
  }
}
