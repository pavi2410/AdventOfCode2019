fun eval(intcode: MutableList<Int>): List<Int> {
//Opcode 3 takes a single integer as input and saves it to the position given by its only parameter.
// For example, the instruction 3,50 would take an input value and store it at address 50.
//Opcode 4 outputs the value of its only parameter.
// For example, the instruction 4,50 would output the value at address 50
    loop@ for ((i, opcode) in intcode.withIndex()) {
        if (i % 4 == 0) {
            when (opcode) {
                1 -> intcode[intcode[i + 3]] = intcode[intcode[i + 1]] + intcode[intcode[i + 2]]
                2 -> intcode[intcode[i + 3]] = intcode[intcode[i + 1]] * intcode[intcode[i + 2]]
                3 -> intcode[intcode[i + 1]] = 5
                4 -> intcode[intcode[i + 1]]
                99 -> break@loop
            }
        }
    }

    return intcode
}