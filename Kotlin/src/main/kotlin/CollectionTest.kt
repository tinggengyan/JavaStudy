fun main(args: Array<String>) {
//    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
//
//    val any = list.any {
//        it % 2 == 0
//    }
//    println(any)
//
//    val all = list.all {
//        it < 10
//    }
//    println(all)
//
//    val count = list.count {
//        it % 2 == 0
//    }
//    println(count)
//
//
//    val fold = list.fold(4) { total, next ->
//        total + next
//    }
//    println(fold)
//
//
//    list.forEach {
//        println(it)
//    }
//
//    list.forEachIndexed(
//            { index, value ->
//                println("$index : " + value)
//
//            }
//    )
//
//
//    println("max:" + list.max())
//
//
//    val maxBy = list.maxBy {
//        -it
//    }
//    println("maxBy:" + maxBy)
//
//
//    val drop = list.drop(4)
//    println(drop)


//    val list2 = listOf(1, 2, 3, 4)
//    val flatMap = list2.flatMap {
//        val listOf = listOf(it, it * 2)
//        listOf
//    }
//    println(flatMap)


//    val list3 = listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7)
//    val groupBy = list3.groupBy {
//        if (it % 2 == 0) "even" else "odd"
//    }
//    println(groupBy)
//
//    // 返回符合给定函数的单个元素，如果没有符合或者超过一个，则返回null。
//    val single = list3.singleOrNull() {
//        it % 5 == 0
//    }
//    println(single)


    val list4 = listOf(1, 2, 3, 4, 5, 6)
    val list5 = listOf(9, 8, 7)

    // 把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条
    // 件返回 true  的元素组成，第二个集合是由原集合每一项元素匹配给定函数条件返
    // 回 false  的元素组成。
    val partition = list4.partition {
        it % 2 == 0
    }
    println(partition)


    val zip1 = list4.zip(list5)
    println(zip1)
    val unzip1 = zip1.unzip()
    println(unzip1)

}