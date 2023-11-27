// Implement additional functions and classes here
fun <T : Comparable<T>> findInversions(a: List<T>): IntArray {
    val countInversion = CountInversion(a)
    return countInversion.findInversions()
}

private class CountInversion<in T : Comparable<T>>(a: List<T>) {
    private val size = a.size
    private val inversions: IntArray = IntArray(a.size)
    private val indexedList = a.mapIndexed { idx, value -> idx to value }.toMutableList()

    fun findInversions(): IntArray {
        doFindInversions(0, size - 1)
        return inversions
    }

    private fun doFindInversions(start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val mid = (start + end) / 2
        doFindInversions(start, mid)
        doFindInversions(mid + 1, end)
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


