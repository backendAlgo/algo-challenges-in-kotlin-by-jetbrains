data class Partition(val terms: List<Int>) {
    val counterMap: Map<Int, Int> = terms.groupingBy { it }.eachCount()
    override fun equals(other: Any?): Boolean {
        other as Partition
        return this.counterMap == other.counterMap
    }

    override fun hashCode(): Int {
        return counterMap.hashCode()
    }
}