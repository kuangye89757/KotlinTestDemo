package basic

/**
 * 操作符	重载
    +a	    a.unaryPlus()
    -a	    a.unaryMinus()
    !a	    a.not()
    a++	    a.inc()	a = a.also{ a.inc() }
    a--	    a.dec()	a = a.also{ a.dec() }
    ++a	    a.inc()	a = a.inc().also{ a = it }
    --a	    a.dec()	a = a.dec().also{ a = it }
    a + b	a.plus(b)
    a - b	a.minus(b)
    a * b	a.tiems(b)
    a / b	a.div(b)
    a % b	a.rem(b) 或 a.mod(b)
    a .. b	a.rangTo(b)
 */
fun main(args: Array<String>) {
    var a = 1
    var b = -2
    var c = true
    var d = false

    // 操作符实现
    println("+a = ${+a}\t -a = ${-a}\t !c = ${!c}")
    println("+b = ${+b}\t -b = ${-b}\t !d = ${!d}")

    // 操作符重载实现
    println("+a = ${a.unaryPlus()}\t -a = ${a.unaryMinus()}\t !c = ${c.not()}")
    println("+b = ${b.unaryPlus()}\t -b = ${b.unaryMinus()}\t !d = ${d.not()}")
}