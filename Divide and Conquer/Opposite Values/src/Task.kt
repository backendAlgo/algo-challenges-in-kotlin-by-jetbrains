fun findAnyOccurrenceOf01(str: CharSequence): Int {
    return doFindAnyOccurrenceOf01(str)
}

fun doFindAnyOccurrenceOf01(str: CharSequence): Int {
    var left = 0
    var right = str.lastIndex
    while (left + 1 < right) {
        val mid = (left + right) / 2
        if (str[mid] == '0') {
            left = mid
        } else {
            right = mid
        }
    }
    return left
}
