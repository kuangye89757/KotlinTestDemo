package basic

/**
 *  数组用类 Array 实现  使用 [] 重载了 get 和 set 方法
 *  ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作效率更高
 */
fun main(args: Array<String>) {
    //使用函数arrayOf()创建数组
    //[1,2,3]
    val a = arrayOf(1,2,3)
    //使用工厂函数创建数组
    //[0,2,4]
    val b = Array(3,{i -> i*2 })

    for (i in a){
        print(i)
    }
    println("========")
    for (i in b){
        print(i)
    }
    println("========")

    //大小固定 元素类型不可变
    var arraylist = arrayOf("重庆","上海","广州","深圳","北京","上海","深圳","北京","上海")

    //遍历
    foreach(arraylist)
    println("========")

    //去重
    removeDuplicates(arraylist)
    println("========")
    foreach(arraylist)

    //切割数组
    println("========")
    sliceArray(arraylist)

    //元素个数
    println("========")
    println("元素个数 " + arraylist.count())
    println("数组是否为空 " +arraylist.isEmpty())

    //获取其中元素：数组名[索引]，首元素：数组名.first，尾元素：数组名.last
    //获取前5个元素的快捷方法.component1到5
    println("========")
    println("首元素: " + arraylist.first())
    println("第二个元素: " + arraylist[1])
    println("第三个元素: " + arraylist.component2())
    println("最后一个元素: " + arraylist.last())

    //mutableList:MutableList<类型>或mutableListof(元素1.元素2，，，元素n)
    //大小可变 类型不变
    var newArraylist = mutableListOf("1","2")
    var tempList = arrayOf("成都","武汉")
    newArraylist.add("3")
    newArraylist.addAll(tempList)


    for(item in newArraylist){
        print(item)
    }
    println("========")

    //移除元素remove，移出指定位置removeAt
    newArraylist.removeAt(0)
    newArraylist.removeAll(tempList)

    for(item in newArraylist){
        print(item)
    }
    println("========")
}

fun sliceArray(list: Array<String>) {
    //获取数组中下标为1~4的数据
    val slice = list.slice(1..4)
    for(item in slice){
        print(item)
    }
}

fun removeDuplicates(list: Array<String>) {
    //返回一个去重后的List
    val norepeat = list.distinct()
    for(item in norepeat){
        print(item)
    }
}

fun foreach(list: Array<String>) {
    for(item in list){
        print(item)
    }
}
