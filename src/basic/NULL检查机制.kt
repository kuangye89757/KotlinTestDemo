package basic

/**
 * NULL检查机制
 *
 * Kotlin的空安全设计
 * 字段后加!!像Java一样抛出空异常
 * 字段后加?可不做处理返回值为 null
 * ?:做空判断处理
 */
fun main(args: Array<String>) {
    var age: String? = null
    println(age)
//    val ages = age!!.toInt() //转换失败抛异常
//    val ages = age?.toInt() //不做处理返回 null
    val ages = age?.toInt()?: -1 //age为空返回-1
    println("ages = $ages")

}