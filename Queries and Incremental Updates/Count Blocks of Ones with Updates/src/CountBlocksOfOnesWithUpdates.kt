class CountBlocksOfOnesWithUpdates(seq: CharSequence) {
    val seq = CharArray(seq.length) { seq[it] }
    var ones = seq.count { it == '1' }
    var blockOnes = fun(): Int {
        var index = 0
        val len = seq.length
        var counter = 0
        while (index < len) {
            if (seq[index] == '1') {
                counter++
                while (index + 1 < len) {
                    if (seq[index + 1] != '1')
                        break
                    index++
                }
            }
            index++
        }
        return counter
    }()

    fun countOnes(): Int = ones

    fun countBlocksOfOnes(): Int = blockOnes

    fun flip(index: Int) {
        require(index < seq.size)
        // update ones
        val num = seq[index] - '0'
        if (num == 1)
            ones--
        else
            ones++
        // update blockOnes
        var prev = if (index == 0) '0' else seq[index - 1]
        val current = seq[index]
        var next = if (index == seq.size - 1) '0' else seq[index + 1]
        if (prev == '1') {
            val temp = prev
            prev = next
            next = temp
        }
        if (current == prev && current == next) {
            blockOnes++
        } else if (current == '1' && next == '0') {
            blockOnes--
        } else if (prev == '1' && current == '0') {
            blockOnes--
        }
        //flip
        seq[index] = ((num xor 1) + '0'.code).toChar()
        /*
        0 0 0+
        0 0 1
        0 1 0
        0 1 1
        1 1 1+
         */
    }
}
