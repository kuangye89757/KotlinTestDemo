package basic

//泛型类声明
class Box<T>(t: T) {
    var value = t
}

fun main(args: Array<String>) {
    var box1 = Box<Int>(1)
    var box2 = Box(1) //编译器自动判断泛型类型
    var box3 = Box("wsj")
    var box4 = boxIn(true)

    println(box1.value)
    println(box2.value)
    println(box3.value)
    println(box4.value)

    doPrint(box1.value)
    doPrint(box3.value)
    doPrint(box4.value)

    demoFunc()
}


//泛型函数声明
fun <T> boxIn(value: T) = Box(value)

fun <T> doPrint(value: T) {
    when (value) {
        is Int -> println("整型: $value")
        is String -> println("字符串类型转换大写: ${value.toUpperCase()}")
        is Boolean -> println("布尔类型: $value")
    }
}

fun <T : Comparable<T>> sort(list: List<T>) {
    //...
}

fun method() {
    sort(listOf(1, 2, 3)) //Int是 Comparable<Int> 的子类型
//    sort(listOf(HashMap<Int, String>())) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型
}


/**
 * 声明处型变
 *       out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型
 *       in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型
 */
class Noob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

fun demoFunc() {
    var strCo: Noob<String> = Noob("strCo")
    var anyCo: Noob<Any> = Noob("anyCo")
    anyCo = strCo
    println(anyCo.foo())
}
