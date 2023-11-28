fun main() {
//    println())
    getMedian(listOf(1, 2, 5), listOf(3, 4, 6))
//    println(getMedian(listOf(3, 4, 6), listOf(1, 2, 5)))
}


fun <T : Comparable<T>> getMedian(first: List<T>, second: List<T>): T {
    val mergeAndFinder = MergeAndFinder(first, second)
    for (i in 0 until (first.size + second.size)) {
        println(mergeAndFinder.getValue(i))
    }
    return mergeAndFinder.getValue(first.size - 1)

}

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
