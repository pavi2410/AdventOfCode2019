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

fun hasMatchingAdjacentDigits(n: Int) = getDigits(n)
    .zipWithNext()
    .any { (a, b) ->
        a == b
    }

val output = input
    .count {
        isIncreasing(it) && hasMatchingAdjacentDigits(it)
    }

println(output) // 460