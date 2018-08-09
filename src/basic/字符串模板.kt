package basic

/**
 * 字符串模板 -- 美元符（$）开头 花括号扩起来的任意表达式
 */
fun main(args: Array<String>) {

    //三个引号 """ 扩起来的字符串
    val text = """
        多行字符串
        多行字符串
        """.trimMargin("")
    println(text)

    //字面值 $ 字符（它不支持反斜杠转义）
    val price = """
    ${'$'}9.99
    """
    println(price)

}