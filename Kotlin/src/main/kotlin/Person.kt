package com.steve.kotlinweather

/**
 * Created by SteveYan on 2017/12/15.
 */
class Person {
    var name: String = ""
        get() = field.toUpperCase()
        set(value) {
            field = "Name: $value"
        }
}

fun main(args: Array<String>) {
    val p = Person()
    p.name = "steve"
    println(p.name)
}