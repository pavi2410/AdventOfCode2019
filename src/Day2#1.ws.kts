val input =
    "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,2,9,19,23,1,9,23,27,2,27,9,31,1,31,5,35,2,35,9,39,1,39,10,43,2,43,13,47,1,47,6,51,2,51,10,55,1,9,55,59,2,6,59,63,1,63,6,67,1,67,10,71,1,71,10,75,2,9,75,79,1,5,79,83,2,9,83,87,1,87,9,91,2,91,13,95,1,95,9,99,1,99,6,103,2,103,6,107,1,107,5,111,1,13,111,115,2,115,6,119,1,119,5,123,1,2,123,127,1,6,127,0,99,2,14,0,0"

fun eval(intcode: MutableList<Int>): List<Int> {

    loop@ for ((i, opcode) in intcode.withIndex()) {
        if (i % 4 == 0) {
            when (opcode) {
                1 -> intcode[intcode[i + 3]] = intcode[intcode[i + 1]] + intcode[intcode[i + 2]]
                2 -> intcode[intcode[i + 3]] = intcode[intcode[i + 1]] * intcode[intcode[i + 2]]
                99 -> break@loop
            }
        }
    }

    return intcode
}

fun find(noun: Int, verb: Int) = eval(
    input.split(",")
        .map { it.toInt() }
        .toMutableList()
        .apply {
            this[1] = noun
            this[2] = verb
        }
).first()

val output = find(12, 2)

println(output) // 9581917

/* --- Test --- */

val testcases = mapOf(
    "1,0,0,0,99" to "2,0,0,0,99",
    "2,3,0,3,99" to "2,3,0,6,99",
    "2,4,4,5,99,0" to "2,4,4,5,99,9801",
    "1,1,1,4,99,5,6,0,99" to "30,1,1,4,2,5,6,0,99"
)

fun eval(s: String): String {
    val intcode = s
        .split(",")
        .map { it.toInt() }
        .toMutableList()

    return eval(intcode)
        .joinToString(",")
}

testcases.forEach { (i, f) -> println("[${i}] [$f] ${eval(i) == f}") }