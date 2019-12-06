val input = 382345..843167

fun getDigits(n: Int) = n
    .toString()
    .toCharArray()
    .map {
        it.toInt()
    }

fun isIncreasing(n: Int) = getDigits(n)
    .zipWithNext()
    .all { (a, b) ->
        a <= b
    }

fun hasMatchingAdjacentDigitPairs(n: Int) = getDigits(n)
    .groupBy { it }
    .any {
        it.value.size == 2
    }

val output = input
    .count {
        isIncreasing(it) && hasMatchingAdjacentDigitPairs(it)
    }

println(output) // 290