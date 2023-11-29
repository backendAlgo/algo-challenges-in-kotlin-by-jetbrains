fun countBlocksOfOnes(seq: CharSequence): Int {
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
}
