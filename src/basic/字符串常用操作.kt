package basic

/**
 * 字符串模板 -- 美元符（$）开头 花括号扩起来的任意表达式
 */
fun main(args: Array<String>) {

    // 三个引号 """ 扩起来的字符串
    val text = """
        多行字符串
        多行字符串
        """
    println(text)

    // 字面值 $ 字符（它不支持反斜杠转义）
    val price = """
    ${'$'}9.99
    """
    println(price)

    subFunc()
    findFunc()
    replaceFunc()
    splitFunc()

    val str = "111::"
//  过滤后影响长度
//    val msg = str.split("::".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val msg = str.split("::".toRegex())
    println("msg.size = ${msg.size}")
}

/**
 * 字符串查找
 *      字符串为空串时，first()函数会抛出异常，而firstOrNull()函数会返回null 同理lastOrNull
 */
fun findFunc() {
    val str = "kotlin very good"
    println("${str.first()}  <=>   ${str[0]}   <=>   ${str.get(0)}")

    // 直接用length属性获取
    println("str.length => ${str.length}")

    // 用count()函数获取
    println("str.count() => ${str.count()}")
    // 统计重复字符
    val count = str.count{it == 'o'}
    println("重复的o的count : $count")

    // 查找某一个字符的第一个元素
    val f =str.first { it == 'o' }
    println("第一个元素 : $f")

    // 查找对应元素的下标
    println(str.indexOfFirst { it == 'o' })
    println(str.indexOfLast { it == 'o' })
    println(str.indexOf('o', 0))
    println(str.indexOf("very", 0))
    println(str.lastIndexOf('o'))
    println(str.lastIndexOf("good"))
}


/**
 * 字符串截取
 */
fun subFunc() {
    //用subString()函数截取
    val str = "Kotlin is a very good programming language"

    println("s = ${str.substring(10)}")  // 当只有开始下标时，结束下标为length - 1 即从第9个位置往后截取
    println(str.substring(0,15))
    println(str.substring(IntRange(0,15)))
}

/**
 * 字符串替换
 */
fun replaceFunc() {
    val str = "Kotlin is a very good programming language"

    //替换所有'a'的内容为A
    println(str.replace('a','A'))
    println(str.replaceFirst('a','A'))
    println(str.replaceFirst( "Kotlin","Java"))

    //替换'a'之前的内容为AA
    val str1 = "Kotlin is a very good programming a language"
    println(str1.replaceBefore('a',"AA"))
    println(str1.replaceBefore("Kotlin","Java"))

    //替换'a'之前的内容为AA  从最后开始
    val str2 = "Kotlin is a very good programming language"
    println(str2.replaceBeforeLast('a',"AA"))
    println(str2.replaceBeforeLast("Kotlin","Java"))

    //替换'a'之后的内容为AA
    val str3 = "Kotlin is a very good programming language"
    println(str3.replaceAfter('a',"AA"))
    println(str3.replaceAfter("Kotlin","Java"))

    //替换'a'之后的内容为AA  从最后开始
    val str4 = "Kotlin is a very good programming language"
    println(str4.replaceAfterLast('a',"AA"))
    println(str4.replaceAfterLast("Kotlin","Java"))
}

/**
 * 字符串分割
 */
fun splitFunc(){
    val str = "1 kotlin 2 java 3 Lua 4 JavaScript"
    val list = str.split(Regex("[0-9]+"))
    for (item in list){
        print("$item \t")
    }

    println()

    //多个分割因子
    val str3 = "a b c d e f g h 2+3+4+5"
    val list5 = str3.split(' ','+')
    for (item in list5){
        print("$item \t")
    }
}

/**
 * 验证字符串
 */
fun valiteFunc(){
    val str : String? = "kotlin"

    // str为可空变量，isNullOrEmpty()isNullOrBlank()可直接调用而不做任何处理，而其他的函数则不行
    println(str?.isEmpty())
    println(str?.isNotEmpty())
    println(str.isNullOrEmpty())
    println(str?.isBlank())
    println(str?.isNotBlank())
    println(str.isNullOrBlank())
}

/**
 * 字符串连接和反转 起始和结尾
 */
fun otherFunc(){
    val str = "kotlin"
    println("字符串反转："+ str + " very good")
    println("字符串反转：${str.reversed()}")

    println(str.startsWith("Kot"))                // 是否由字符串`kot`起始
    println(str.startsWith("lin",3))    // 当起始位置为3时，是否由字符串`lin`起始
    println(str.endsWith('n'))    // 是否由字符`n`结尾

}
