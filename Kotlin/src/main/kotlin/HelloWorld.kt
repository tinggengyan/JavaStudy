import java.util.function.Consumer

/**
 * Created by yantinggeng on 2016/2/23.
 */

fun main(args: Array<String>) {

    val result = 3.triple()
    print(result)
}

//打印日志
fun printLog() {
    print("steve yan")
    println("steve yan")
}

// 定义常量和变量的方法
fun value() {
    val name = "steveyan"
    var nickName = "genggeng"
    nickName = "genggeng007"
}


fun nullValueDeclare() {
    var name: String?
    name = null
}

fun nullValueJudge(text: String?) {
    text?.let {
        var length = text.length
        print("length:" + length)
    }
}


fun stringLine() {
    val firstName = "steve"

    val lastName = "yan"

    val message = "my name is : $firstName $lastName"

    print(message)
}

fun newline() {

    val text = """
    |FirstLine
    |SecondLine
    |ThirdLine """
            .trimMargin()

    print(text)
}


fun ternaryExpression(x: Int) {
    val text =
            if (x > 5) {
                "x>5"
            } else {
                "x<=5"
            }
    print(text)
}


fun typeDec(value: Any) {
    if (value is Int) {
        val intValue = value as Int
        val intValue2 = value // smart convert
        print("intValue:" + intValue)
    }
    if (value is Double) {
        val doubleValue = value as Double
        val doubleValue2 = value  // smart convert
        print("doubleValue" + doubleValue)
    }

}


fun mutiCondition(value: Int) {
    if (value in 0..30) {
        print("在0到30之间")
    } else {
        print("超出了")
    }
}


fun case(score: Int) {

    var grade = when (score) {
        9, 10 -> {
            "Excellent"
        }
        in 6..8 -> {
            "Good"
        }
        4, 5 -> {
            "OK"
        }
        else -> {
            "Failed"
        }
    }
    print(grade)
}


fun cycle() {
    val intValue = 10

    for (i in 0..intValue) {
        //
        println("i:" + i)
    }

    for (i in 0..intValue step 2) {
        println("i:" + i)
    }

    val names = ArrayList<String>()
    for (i in 0..intValue) {
        names.add("a" + i)
    }

    for (a in names) {
        print(a)
    }


    var keyvalue = HashMap<Int, String>()
    for (i in 0..intValue) {
        keyvalue.put(i, "value" + i)
    }

    for ((key, value) in keyvalue) {
        println("key:" + key + "value:" + value)
    }
}


fun collection() {

    val listNumber = listOf<Int>(1, 23, 4, 5)
    val keyValue = mapOf<Int, String>(
            1 to "Amit",
            2 to "Ali",
            3 to "Min"
    )

    listNumber.forEach {
        println(it)
    }

    listNumber.forEach(Consumer {
        println("Consumer:" + it + 200)
    })


    listNumber.filter {
        it > 2
    }.forEach {
        println("filter:" + it)
    }


    keyValue.forEach { k, v ->
        println("k:" + k + "v:" + v)
    }

}


fun getAge(): Int {

    return 18
}

fun add(a: Int, b: Int) = a + b


fun testConstruct() {
    val u = Utils
    print(u.getScore(2))
}


fun Int.triple(): Int {
    return this * 3;
}











