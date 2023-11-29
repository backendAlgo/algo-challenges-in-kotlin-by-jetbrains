// Write additional classes and functions here

fun generateDerangements(n: Int): List<Derangement> {
  val prefix = mutableSetOf<Int>()
  return generate(n, prefix)
}

fun generate(n: Int, prefix: MutableSet<Int>): List<Derangement> {
  if (n == prefix.size) {
    return listOf(Derangement(prefix.toIntArray()))
  }
  val result = mutableListOf<Derangement>()
  for (num in 0 until n) {
    if (num !in prefix && num != prefix.size) {
      val list = prefix.run {
        add(num)
        val ans = generate(n, prefix)
        remove(num)
        ans
      }
      result += list
    }
  }
  return result
}
