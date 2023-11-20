class PartitionGenerator(private val n: Int) {
    private val partitions = mutableListOf<Partition>()
    private val currentPartition = ArrayDeque<Int>()

    fun generate(): List<Partition> {
        doGenerate(n, 1)
        return partitions.toList()
    }

    private fun doGenerate(n: Int, lastAddend: Int) {
        if (n == 0) {
            partitions.add(Partition(currentPartition.toList()))
            return
        }
        if (n < lastAddend) {
            return
        }


        for (currentAddend in lastAddend..n) {
            currentPartition.addLast(currentAddend)
            doGenerate(n - currentAddend, currentAddend)
            currentPartition.removeLast()
        }
    }
}


fun generatePartitions(n: Int): List<Partition> {
    val generator = PartitionGenerator(n)
    return generator.generate()
}

fun main() {
    println(generatePartitions(4))
//    val map1 = listOf(1, 1, 2, 1).groupingBy { it }.eachCount()
//    val map2 = listOf(1, 1, 1, 2).groupingBy { it }.eachCount()
//    println(map1 == map2)
}
