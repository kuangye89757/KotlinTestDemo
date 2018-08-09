package basic

/**
 *一、基本数值类型: Byte Short Int Long Float Double
      字符类型:Char
      布尔类型:Boolean
  二、字面常量：
       2进制: 0b123
       不支持8进制
       10进制: 123
       16进制: 0x123
       Long类型: 123L(必须大写)
  三、没有基础数据类型  每定义一个变量,会被封装成一个对象 避免空指针
  四、比较两个数字
        三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
  五、类型转换
       不支持隐式转换，每种数据类型都有下面的这些方法用于转换成其他类型
        toByte(): Byte
        toShort(): Short
        toInt(): Int
        toLong(): Long
        toFloat(): Float
        toDouble(): Double
        toChar(): Char
  六、使用下划线增加字面量可读性
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

  七、 Char 不能直接和数字操作，必需是单引号''包含起来
*/
fun main(args: Array<String>) {
    val a = -129
    //切记没有基础类型 这样的操作相当于封装到了新的对象
    val boxA:Int? = a
    val antherBoxA:Int? = a
    println("===比较地址: ${boxA === antherBoxA}") //-128到127以内并没有进行装箱操作
    println("==比较值: ${boxA == antherBoxA}")

    val b:Long = a.toLong()
    println("Long类型b:" + b)

    //有些情况下也是可以使用自动类型转化(根据上下文环境操作符会做相应的重载)
    val c = 1L + 3
    println("Long类型c:" + c)

    println("字符转为数字:" + decimalDigitValue('7'))

    val e = true
    println("e的反为: " + !e)
}

fun decimalDigitValue(c:Char):Int {
    if(c !in '0'..'9'){
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt()
}
