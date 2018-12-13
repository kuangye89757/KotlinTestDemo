package basic

/**
 *一、基本数值类型: Byte(8) Short(16) Int(32) Long(64) Float(32) Double(64)
      字符类型:Char
      布尔类型:Boolean
  二、字面常量：
       2进制: 0b123
       8进制: 不支持
       10进制: 123
       16进制: 0x123
       Long类型: 123L(必须大写)
  三、没有基础数据类型  每定义一个变量,会被封装成一个对象(真正地万般皆对象) 避免空指针
        数值类型+? 就是一个装箱过程 由于没有基础数据类型 不存在拆箱

  四、比较两个数字
        === 表示比较对象地址
        == 表示比较两个值大小  字符串同理 尽量确定的字符串在前

  五、类型转换
       【不支持隐式转换】，每种数据类型都有下面的这些方法用于转换成其他类型
            toByte(): Byte
            toShort(): Short
            toInt(): Int
            toLong(): Long
            toFloat(): Float
            toDouble(): Double
            toChar(): Char

      类型是从上下文推断出来的，即算术运算则被重载为适当的转换
        // 30L + 12 -> Long + Int => Long
        val num = 30L + 12


  六、使用下划线增加字面量可读性
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010

  七、 Char 不能直接和数字操作，必需是单引号''包含起来
  八、 逻辑操作符（与Java相同）
*/
fun main(args: Array<String>) {
    val a = -129
    //切记没有基础类型 这样的操作相当于封装到了新的对象
    val boxA:Int? = a
    val antherBoxA:Int? = a

    //这是`kotlin`的缓存策略导致的，而缓存的范围是` -128 ~ 127 ` 该范围外的内存地址是不同的
    println("===比较地址: ${boxA === antherBoxA}")
    println("==比较值: ${boxA == antherBoxA}")

    val b:Long = a.toLong()
    println("Long类型b:" + b)

    //有些情况下也是可以使用自动类型转化(根据上下文环境操作符会做相应的重载)
    val c = 1L + 3
    println("Long类型c:" + c)

    println("字符转为数字:" + decimalDigitValue('7'))

    val e = true
    println("e的反为: " + !e)


    convertNum()
}

fun decimalDigitValue(c:Char):Int {
    if(c !in '0'..'9'){
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt()
}

fun convertNum(){
    var numA: Int = 97
    println(numA.toByte())
    println(numA.toShort())
    println(numA.toInt())
    println(numA.toLong())
    println(numA.toFloat())
    println(numA.toDouble())
    println(numA.toChar())
    println(numA.toString())
}