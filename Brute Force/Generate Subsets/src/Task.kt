import java.util.*

// Implement additional functions and classes here
private class BitSetGenerator(
    private val size: Int,
    private val setSize: Int
) {
    private val allSubsets = mutableListOf<BitSet>()
    private val currentBitSet = BitSet(size)

    fun doGenerate(index: Int, currSetSize: Int) {
        if (currSetSize == setSize) {
            allSubsets += currentBitSet.copy()
            return
        }
        if (index < size)
            currentBitSet.run {
                set(index)
                doGenerate(index + 1, currSetSize + 1)
                clear(index)
            }
        if (size - index > setSize - currSetSize) {
            doGenerate(index + 1, currSetSize)
        }
    }

    fun generate(): List<BitSet> {
        doGenerate(0, 0)
        return allSubsets
    }
}

fun generateSubsets(nums: Int, length: Int): List<BitSet> {
    val bitSetGenerator = BitSetGenerator(nums, length)
    return bitSetGenerator.generate()
}

fun BitSet.copy(): BitSet {
    return this.clone() as BitSet
}

