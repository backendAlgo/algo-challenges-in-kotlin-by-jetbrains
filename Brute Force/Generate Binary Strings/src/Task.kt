// Implement additional functions and classes here if required
fun generateBinaryStrings(
  length: Int, current: StringBuilder = StringBuilder(""), currLength: Int = 0
): List<String> {
  if (length == currLength) {
    return listOf(current.toString())
  }
  return current.run {
    append("0")
    val left = generateBinaryStrings(length, this, currLength + 1)
    removeLast()
    append("1")
    val right = generateBinaryStrings(length, this, currLength + 1)
    removeLast()
    left + right
  }
}

fun StringBuilder.removeLast(): StringBuilder {
  return deleteAt(lastIndex)
}
