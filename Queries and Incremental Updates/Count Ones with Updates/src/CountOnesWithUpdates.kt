class CountOnesWithUpdates(seq: CharSequence) {
    private val seq = CharArray(seq.length) { seq[it] }
    private var counter = seq.count { it == '1' }
    fun countOnes(): Int = counter

    fun flip(index: Int) {
        require(index < seq.size)
        val num = seq[index] - '0'
        if (num == 1)
            counter--
        else
            counter++
        seq[index] = ((num xor 1) + '0'.code).toChar()
    }
}
