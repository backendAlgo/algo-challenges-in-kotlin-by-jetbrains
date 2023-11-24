fun countSegmentsForEach(points: IntArray, segments: Array<Pair<Int, Int>>): IntArray {
    val leftSorted = segments.map { it.first }.sorted()
    val rightSorted = segments.map { it.second }.sorted()
    val result = IntArray(points.size)
    for ((idx, point) in points.withIndex()) {
        result[idx] = segments.size - before(point, rightSorted) - after(point, leftSorted)
    }
    return result
}

fun after(target: Int, leftSorted: List<Int>): Int {
    var left = 0
    var right = leftSorted.size
    while (left < right) {
        val mid = (left + right) / 2
        if (leftSorted[mid] <= target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
// leftSorted[left] > target && leftSorted[left - 1] <= target

//    println("$target, after count ${leftSorted.size - left}")
    return leftSorted.size - left
}

fun before(target: Int, rightSorted: List<Int>): Int {
    var left = 0
    var right = rightSorted.size
    while (left < right) {
        val mid = (left + right) / 2
        if (rightSorted[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
// rightSorted[left - 1] < target && rightSorted[left] >= target
//    println("$target, before count $left")
    return left
}


