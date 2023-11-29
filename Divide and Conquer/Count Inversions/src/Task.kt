fun <T : Comparable<T>> count(a: List<T>): IntArray {
  val countInversion = InversionCounterAfter1Day(a)
  return countInversion.count()
}

private class InversionCounter<in T : Comparable<T>>(a: List<T>) {
  private val size = a.size
  private val inversions: IntArray = IntArray(a.size)
  private val indexedList = a.mapIndexed { idx, value -> idx to value }.toMutableList()

  fun count(): IntArray {
    mergeSort(0, size - 1)
    return inversions
  }

  private fun mergeSort(start: Int, end: Int) {
    if (start >= end) {
      return
    }
    val mid = (start + end) / 2
    mergeSort(start, mid)
    mergeSort(mid + 1, end)
    merge(start, end)
  }

  private fun merge(start: Int, end: Int) {
    val tempList = mutableListOf<Pair<Int, T>>()

    val mid = (start + end) / 2

    var firstHalfIdx = start
    var secondHalfIdx = mid + 1

    while (firstHalfIdx <= mid && secondHalfIdx <= end) {
      if (indexedList[firstHalfIdx].second <= indexedList[secondHalfIdx].second) {
        tempList += indexedList[firstHalfIdx]
        firstHalfIdx++
      } else {
        tempList += indexedList[secondHalfIdx]
        inversions[indexedList[secondHalfIdx].first] += (mid - firstHalfIdx + 1)
        secondHalfIdx++
      }
    }
    while (firstHalfIdx <= mid) {
      tempList += indexedList[firstHalfIdx]
      firstHalfIdx++
    }
    while (secondHalfIdx <= end) {
      tempList += indexedList[secondHalfIdx]
      inversions[indexedList[secondHalfIdx].first] += (mid - firstHalfIdx + 1)
      secondHalfIdx++
    }
    for ((index, value) in tempList.withIndex()) {
      indexedList[index + start] = value
    }
  }
}

private class InversionCounterAfter1Day<T : Comparable<T>>(a: List<T>) {
  val result: IntArray = IntArray(a.size)
  val listToIndexValue: Array<Pair<Int, T>> = Array(a.size) { it to a[it] }
  fun count(): IntArray {
    mergeSort(0, result.size - 1)
    return result
  }

  fun mergeSort(low: Int, high: Int) {
    if (low >= high) {
      return
    }
    val mid = (low + high) / 2
    mergeSort(low, mid)
    mergeSort(mid + 1, high)
    merge(low, high)
  }

  private fun merge(low: Int, high: Int) {
    val mid = (low + high) / 2
    var firstIndex = low
    var secondIndex = mid + 1

    val mergeArray: Array<Pair<Int, T>?> = Array(high - low + 1) { null }
    var mergedArrayIndex = 0
    while (firstIndex <= mid && secondIndex <= high) {
      if (listToIndexValue[firstIndex].second <= listToIndexValue[secondIndex].second) {
        mergeArray[mergedArrayIndex] = listToIndexValue[firstIndex]
        firstIndex++
      } else {
        mergeArray[mergedArrayIndex] = listToIndexValue[secondIndex]
        result[listToIndexValue[secondIndex].first]++
        secondIndex++
      }
      mergedArrayIndex++
    }
    while (firstIndex <= mid) {
      mergeArray[mergedArrayIndex] = listToIndexValue[firstIndex]
      firstIndex++
      mergedArrayIndex++
    }
    while (secondIndex <= high) {
      mergeArray[mergedArrayIndex] = listToIndexValue[secondIndex]
      result[listToIndexValue[secondIndex].first]++
      secondIndex++
      mergedArrayIndex++
    }
    // make sure all element of merged array is initialized
    check(mergedArrayIndex == high - low + 1)
    for ((index, value) in mergeArray.withIndex()) {
      listToIndexValue[index + low] = value!!
    }
  }
}

fun main() {
  val list = listOf(3, 1, 3, 4, 2)
  val actual = count(list)
  println(intArrayOf(0, 1, 0, 0, 3).contentToString())
}


