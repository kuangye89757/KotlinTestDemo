package basic

/**
 * for 循环可以对任何提供迭代器（iterator）的对象进行遍历
 */
fun main(args: Array<String>) {
    //循环数组被编译为一个基于索引的循环，它不会创建一个迭代器对象
    val array = arrayOf("1", "2", "3")
    for (item in array) {
        print(item)
    }
    println("================")

    //使用数组的indices(指数)属性遍历
    val arrayList = arrayListOf("apple", "banana", "orange")
    for (i in arrayList.indices) {
        print(arrayList[i])
    }
    println("================")

    //使用数组的withIndex()方法遍历
    for((index,value) in arrayList.withIndex()){
        println("索引${index}对应的值为$value")
    }
}

/**
 * 范围遍历
 */
fun rangeToFunc(){

    //递增的循环的另外一种操作  符号( .. )表示 至
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

    // 使用 until 函数排除结束元素
    print("使用 until：")
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}

/**
 * 使用列表或数组的扩展函数遍历
 *      1.数组或列表有一个成员或扩展函数iterator()实现了Iterator<T>接口，且该接口提供了next()与hasNext()两个成员或扩展函数
        2.其一般和while循环一起使用
 */
fun iteratorFunc(){
    var arrayList1 = arrayOf(2,'a',3,false,9)
    var iterator:Iterator<Any> = arrayList1.iterator()

    while (iterator.hasNext()){
        println(iterator.next())
    }
}
