package basic

/**
 * 函数声明关键字为：fun
 *      格式:  可见性修饰符 fun 函数名(参数名 : 类型,...) : 返回值{}
 *
 * fun声明函数时，默认为final修饰，不能被子类重写
 *               默认为public可见性修饰符
 *               没有返回值时可以省略不写,即可以省略Unit
 */
fun main(args: Array<String>) {
    println("hello world !")
    sum0(1, 2)
    sum1(1, 2)
    printSum(2, 3)
    stringFormat()


    defArgs()
    defArgs(2)

    //使用命名参数 具有可读性且不影响其他参数
    defArgs(numA = 3, numC = true)

    //传递参数时，可以一个一个参数的传递
    //传递数组时，使用伸展操作符( * )
    val strArray = arrayOf("aaa", "bbb", "ccc", "ddd", "fff")
    varargFun(1, *strArray)
}

//具有参数的函数定义  使用Pascal表示法定义，即为:name : type  多参数间用逗号隔开
fun sum0(a: Int, b: Int): Int {
    return a + b
}

// 单表达式函数  省略花括号并且在=赋值符号之后指定代码体，返回值由编辑器自动推断
fun sum1(a: Int, b: Int) = a * b

//无返回值函数使用Unit(相当于java中的void 可省略不写)
fun printSum(a: Int, b: Int) {
    println(a + b)
}

//默认参数  有效减少函数重载
fun defArgs(numA: Int = 1, numB: Float = 2f, numC: Boolean = false) {
    println("numA  =  $numA \t numB = $numB \t numC = $numC")
}


//$ 表示一个变量名或者变量值
//$varName 表示变量值
//${varName.fun()} 表示变量的方法返回值:
fun stringFormat() {
    var a = 1
    var s1 = "a = $a"
    println(s1)

    var s2 = "${s1.replace("1", "666")}"
    println(s2)
}

//变长参数
fun varargFun(numA: Int, vararg str: String) {
    for (s in str) {
        println(s)
    }
}
