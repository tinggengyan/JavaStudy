interface CanFly {
    fun fly()
}


class Bird(f: CanFly) : CanFly by f {

}

class Bat : CanFly {
    override fun fly() {
        println("fly")
    }

    fun ff(): Unit {
        println("ff")
    }

}

fun main(args: Array<String>) {
    var f: CanFly = Bat()
    var b : CanFly = Bird(f)
    b.fly()
}