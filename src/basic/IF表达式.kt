package basic

fun main(args: Array<String>) {
    var a:Int = 2
    var b:Int = 3

    //代替三元运算符
    var c = if(a < b) a else b

    // IF 表达式的结果赋值给一个变量
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
    print(max)


    //区间格式为 x..y
    //in 运算符来检测是否在区间内
    val x = 5
    if(x in 1..10){
        println("x 在区间内")
    }
}