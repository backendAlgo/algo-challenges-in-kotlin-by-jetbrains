import kotlin.math.max

fun maximumPairwiseProduct(a: IntArray): Long {
    val len = a.size
    var res = Long.MIN_VALUE
    for (i in 0 until len) {
        for (j in i + 1 until len) {
            res = max(res, 1L * a[i] * a[j])
        }
    }
    return res
}