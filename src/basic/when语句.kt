package basic

/**
 * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件
      1.当做表达式，符合条件的分支的值就是整个表达式的值
      2.当做语句， 则忽略个别分支的值

   不仅可以替代掉Java语句中的swicth语句。甚至可以替换掉if语句
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

    //和逗号结合使用，相当于switch语句中的不使用break跳转语句
    //返回值接收的情况
    var result = when(x){
        1,2 -> {
            print("x == 1 or x == 2")
            "1"
        }
        else -> {
            print("others")
            "2"
        }
    }
    println("result = $result")

    //同if表达式效果
    when(x > 1){
        true -> {
            println("x > 1")
        }
        false ->{
            println("x <= 1")
        }
    }

    //使用in检测区间 (只适用于数值类型)
    var arrayList1 = arrayOf(1,2,3)
    when(x){
        in 1..4,6 -> print("x在该区间[1-4][6]内")
        in arrayList1 -> print("x在数组arrayList1内")
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