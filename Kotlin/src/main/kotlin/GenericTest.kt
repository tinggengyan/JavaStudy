class TypeClass<T : Any>(parameter: T) {
    val value: T = parameter

    fun <T> typedFunction(item: T): List<T> {
        return listOf<T>(item)
    }

}


fun testLet(int: TypeClass<Int>): Int? {
    if (int.value > 0) {
        return int.value
    } else {
        return -2
    }
}


fun main(args: Array<String>) {
    var intV = TypeClass(0)
    var stringValue = TypeClass("string")

    println(stringValue.value)

    for (s in stringValue.typedFunction("hello")) {
        println(s)
    }



    val let = intV?.let {
        testLet(intV)
    }

    println("let:" + let)


}