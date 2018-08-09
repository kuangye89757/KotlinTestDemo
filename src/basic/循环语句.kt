package basic

fun main(args: Array<String>) {
    //for 循环可以对任何提供迭代器（iterator）的对象进行遍历
    val array = arrayOf("1", "2", "3")
    for (item in array) {
        print(item)
    }
    println("================")

    //"区间上遍历"会编译成优化的实现而不会创建额外对象
    //通过索引遍历
    val arrayList = arrayListOf("apple", "banana", "orange")
    for (i in arrayList.indices) {
        print(arrayList[i])
    }

    println("================")
    for((index,value) in arrayList.withIndex()){
        println("索引${index}对应的值为$value")
    }
}

/**
 * 范围遍历
 */
fun rangeToFunc(){
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    //    for(i in 4..1) print(i)  //不输出任何东西
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}