package basic

/**
 * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件
      1.当做表达式，符合条件的分支的值就是整个表达式的值
      2.当做语句， 则忽略个别分支的值
 */
fun main(args: Array<String>) {
    var x = 1
    //类似switch操作符 else同switch的default
    when(x){
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("其他")
        }
    }
    println("==================")
    //多分支相同处理方式
    when(x){
        1,2 -> print("x == 1 or x == 2")
        else -> print("others")
    }

    //使用in检测区间
    when(x){
        in 1..4 -> print("x在该区间[1-4]内")
        !in 6..10 -> print("x不在该区间[6-10]内")
    }

    //作为语句 则条件成立的语句作为代替的值
    var content = hasPrefix("prefixA")
    println("====================")
    println("是否包含前缀prefix " + content)

    //不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支
    val items = setOf("apple","banana","kiwi")
    when{
        "apple" in items -> println("this is apple")
        else -> println("其他")
    }
}

fun hasPrefix(x:Any) = when(x){
    //使用is判断
    is String -> x.startsWith("prefix")
    else -> false
}