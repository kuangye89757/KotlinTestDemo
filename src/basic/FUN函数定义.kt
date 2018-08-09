package basic

fun main(args: Array<String>) {
    println("hello world !")
    sum0(1, 2)
    sum1(1, 2)
    sum2(1, 2)
    printSum(2, 3)
    stringFormat()
}

//函数定义使用关键字 fun，参数格式为  参数: 类型   返回值 Int
fun sum0(a: Int, b: Int): Int {
    return a + b
}

//表达式作为函数体，返回类型自动推断
fun sum1(a: Int, b: Int) = a + b

// public 方法则必须明确写出返回类型
public fun sum2(a: Int, b: Int): Int = a * b

//无返回值函数使用Unit(相当于java中的void 可省略不写)
fun printSum(a: Int, b: Int) {
    println(a + b)
}


//$ 表示一个变量名或者变量值
//$varName 表示变量值
//${varName.fun()} 表示变量的方法返回值:
fun stringFormat(){
    var a = 1
    var s1 = "a = $a"
    println(s1)

    var s2 = "${s1.replace("1","666")}"
    println(s2)
}
