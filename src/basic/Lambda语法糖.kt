package basic

/**
 *  1.Lambda表达式总是被大括号括着
 *  2.其参数在 -> 前面 声明(参数类型可以省略)
 *  3.函数体在 -> 后面 运行结果即返回值 无需再return

        输入 -> 输出

 *  it是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数
 *  下划线(_)表示未使用的参数，表示不处理这个参数
 */
fun main(args: Array<String>) {
    //方式一的lambda表达式
    val test = { println("无参数") }
    test()

    val test2 = { a: Int, b: Int -> a + b }
    println(test2(1, 2))

    println(test3(10,{it > 5}))
    println(test3(10) {it > 15})//lambda表达式作为参数列表可以移至括号外
    println(test3(10) {bieming -> bieming > 15})//it也可以通过别名 -> 函数体再进行lambda表达式

    //遍历map
    val map = mapOf("key1" to "value1","key2" to "value2","key3" to "value3")
    map.forEach { key, value -> println("$key \t $value") }
    //只显示value
    map.forEach { _, value -> println(value) }



}

// 方式一
//fun test(){
//    println("无参数")
//}


// 方式二
//fun test2(a : Int , b : Int) : Int{
//    return a + b
//}

// 方式三 lambda高阶函数
//bool作为lambda表达式闭包名 (Int) -> Boolean表示lambda表达式的输入和输出
fun test3(num1: Int, bool: (Int) -> Boolean): Int {
    return if (bool(num1)) {
        num1
    } else 0
}


