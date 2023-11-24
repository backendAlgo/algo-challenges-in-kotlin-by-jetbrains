fun main() {
    val lower = 1
    val upper = 1000000
    guess(1, 1000000)
}

fun guessRandomly() {
    do {
        val guess = readln().toInt()
        val c = query(guess)
    } while (c != '=')
}

fun guess(lower: Int, upper: Int) {
    val middle = (lower + upper) / 2
    val result = query(middle)
    println(result)
    if (result == '=') {
        return
    } else if (result == '<') {
        println('<')
        guess(lower, middle - 1)
    } else {
        println('>')
        guess(middle + 1, upper)
    }
}

val x = 8993  // Change this value for testing
fun query(y: Int): Char {
    val res = if (x == y) {
        '='
    } else if (x < y) {
        '<'
    } else {
        '>'
    }
    println("Query: X = $y?, response: X $res $y")
    return res
}


























