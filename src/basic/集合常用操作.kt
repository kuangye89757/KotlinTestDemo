package basic

/**
 * 转换为数组
 *     集合类提供了toIntArray()、toDoubleArray()、toFloatArray()、toBetArray()等高阶函数去处理
 *
 *      public fun Collection<Int>.toIntArray(): IntArray {
            val result = IntArray(size)
            var index = 0
            for (element in this)
                result[index++] = element
            return result
        }

   转换为集合
        调用toXXX()转换成不可变集合。调用toMutableXXX()转换为可变集合
        集合类提供了toList()、toMutableList()、toSet()、toMutableSet()、toHashSet()、toMap()等高阶函数去处理

        public fun <T> Iterable<T>.toList(): List<T> {
            if (this is Collection) {
                return when (size) {
                    0 -> emptyList()
                    1 -> listOf(if (this is List) get(0) else iterator().next())
                    else -> this.toMutableList()
                }
            }
            return this.toMutableList().optimizeReadOnlyList()
        }

   元素操作符
        contains(元素) : 检查集合中是否包含指定的元素，若存在则返回true，反之返回false
        elementAt(index) : 获取对应下标的元素。越界会抛出IndexOutOfBoundsException（下标越界）异常，同get(index)
        elementAtOrElse(index,{...}) : 获取对应下标的元素。越界返回默认值
        elementAtOrNull(index) :       获取对应下标的元素。越界返回null

        first() : 获取第一个元素，空集合抛出NoSuchElementException异常
        first{} : 获取指定元素的第一个元素。若不满足条件，则抛出NoSuchElementException异常

        firstOrNull() : 获取第一个元素，空集合返回null
        firstOrNull{} : 获取指定元素的第一个元素。若不满足条件，返回null

        getOrElse(index,{...}) : 同elementAtOrElse一样
        getOrNull(index) : 同elementAtOrNull一样

        last() : 同first()相反
        last{} : 同first{}相反

        lastOrNull{} : 同firstOrNull()相反
        lastOrNull() : 同firstOrNull{}相反

        indexOf(元素) : 返回指定元素的下标，不存在返回-1
        indexOfFirst{...} : 返回第一个满足条件元素的下标，若不存在，则返回-1
        indexOfLast{...} : 返回最后一个满足条件元素的下标，若不存在，则返回-1

        single() : 若集合的长度等于0,则抛出NoSuchElementException异常，若等于1，则返回第一个元素。反之，则抛出IllegalArgumentException异常
        single{} : 找到集合中满足条件的元素，若元素满足条件，则返回该元素。否则会根据不同的条件，抛出异常。这个方法慎用

        singleOrNull() : 若集合的长度等于1,则返回第一个元素。否则，返回null
        singleOrNull{} : 找到集合中满足条件的元素，若元素满足条件，则返回该元素。否则返回null

        forEach{...} : 遍历元素。一般用作元素的打印
        forEachIndexed{index,value} : 遍历元素，可获得集合中元素的下标。一般用作元素以及下标的打印
        componentX() ： 这个函数在前面的章节中提过多次了。用于获取元素。其中的X只能代表1..5

   顺序操作符
        reversed() : 反序 (调用的是Java中的reversed()函数)
        sorted() : 升序
        sortedBy{} : 根据条件升序     满足条件的放在后面
        sortedDescending() : 降序
        sortedByDescending{} : 和sortedBy{}相反

   映射操作符
        map{...} : 把每个元素按照特定的方法进行转换，组成一个新的集合
        mapNotNull{...} : 同map{}，过滤掉转换之后为null的元素
        mapIndexed{index,result} : 同map{}，可同时操作下标(index)
        mapIndexedNotNull{index,result} : 同mapIndexed{}，过滤掉转换之后为null的元素
        flatMap{...} : 根据条件合并两个集合，组成一个新的集合。
        groupBy{...} : 分组。根据条件把集合拆分为为一个Map<K,List<T>>类型的集合

   过滤操作符
        filter{...} : 把不满足条件的元素过滤掉
        filterIndexed{...} : 同filter{}，可操作元素下标（index）
        filterNot{...} : 同filter{}相反
        filterNotNull() : 过滤掉集合中为null的元素

        take(num) : 返回集合中【前】num个元素组成的集合
        takeWhile{...} : ，从【第一个】元素开始遍历集合，出现不满足条件元素时退出遍历。然后把满足条件所有元素组成集合返回
        takeLast(num) : 返回集合中【后】num个元素组成的集合
        takeLastWhile{...} : 从【最后一个】元素开始遍历集合，出现不满足条件元素时退出遍历。然后把满足条件所有元素组成集合返回

        drop(num) : 过滤集合中前num个元素
        dropWhile{...} : 相同条件下，和执行takeWhile{...}函数后得到的结果相反
        dropLast(num) : 过滤集合中后num个元素
        dropLastWhile{...} : 相同条件下，和执行takeLastWhile{...}函数后得到的结果相反

        distinct() : 去重
        distinctBy{...} : 根据操作元素后的结果去除重复元素
        slice : 过滤掉所有不满足执行下标的元素 （切片）

   生产操作符
        plus() : 合并两个集合中的元素，组成一个新的集合。也可使用符号+
        zip : 由两个集合按照相同下标组成一个新集合。新集合的类型是：List<Pair>
        unzip : 和zip的作用相反。把一个类型为List<Pair>的集合拆分为两个集合
        partition : 判断元素是否满足条件把集合拆分为有两个Pair组成的新集合

   统计操作符
        any() : 至少有一个元素则返回true 为空返回false,  若不是集合，则返回hasNext
        any{...} : 至少有一个满足条件元素则返回true,否则返回false
        all{...} : 所有元素都满足条件  则返回true,否则返回false
        none() : 和any()函数的作用相反
        none{...} : 和all{...}函数的作用相反 所有元素都不满足条件  则返回true,否则返回false

        max() : 获取集合中最大的元素，空集合返回null
        maxBy{...} : 获取函数处理后 结果最大的所对应那个元素的原值，没有则返回null

        min() : 获取集合中最小的元素，若为空元素集合，则返回null
        minBy{...} : 获取方法处理后返回结果最小值对应那个元素的初始值，没有则返回null

        sum() : 计算出集合元素累加结果
        sumBy{...} : 根据元素运算操作后的结果，计算出累加的值 (Int类型数据)
        sumByDouble{...} : 同sumBy{}，Double类型数据

        average() : 获取平均数
        reduce{...} : 从集合中的第一项到最后一项的累计操作
        reduceIndexed{...} : 和reduce{}作用相同，可操作元素下标
        reduceRight{...} : 从集合中的最后一项到第一项的累计操作
        reduceRightIndexed{...} : 和reduceRight{}作用相同，可操作元素下标
        fold{...} : 和reduce{}类似，但是fold{}有一个初始值
        foldIndexed{...} : 和reduceIndexed{}类似，但是foldIndexed{}有一个初始值
        foldRight{...} : 和reduceRight{}类似，但是foldRight{}有一个初始值
        foldRightIndexed{...} : 和reduceRightIndexed{}类似，但是foldRightIndexed{}有一个初始值
 */
fun main(args: Array<String>) {
    listToArray()
    arrayToList()
    setToList()
    mapFunc()
    filterFunc()
    statisticalFunc()
}


fun listToArray(){
    val list = listOf<Int>(1,2,3,4,5,6)         // 声明一个Int类型的List
    val listArray = list.toIntArray()           // 转换

    println(list.javaClass.toString())          // 打印list的类型
    println(listArray.javaClass.toString())     // 打印listArray的类型
}

fun arrayToList() {
    val arr = arrayOf(1,3,5,7,9)
    val list = arr.toList()
    println("变量arr的类型为：${arr.javaClass}")
    println("变量list的类型为：${list.javaClass}")
    println(list[1])
}


fun setToList(){
    val set = setOf(1)
    val setTolist = set.toList()

    println("变量set的类型为：${set.javaClass}")
    println("变量setTolist的类型为：${setTolist.javaClass}")
    println(setTolist[0])
}

private fun methodF(){
    val list = listOf("kotlin","Android","Java","PHP","Python","IOS")

    println("  ------   contains -------")
    println(list.contains("JS"))

    println("  ------   elementAt -------")

    println(list.elementAt(2))
    println(list.elementAtOrElse(10,{it}))
    println(list.elementAtOrNull(10))

    println("  ------   get -------")
    println(list.get(2))
    println(list.getOrElse(10,{it}))
    println(list.getOrNull(10))

    println("  ------   first -------")
    println(list.first())
    println(list.first{ it == "Android" })
    println(list.firstOrNull())
    println(list.firstOrNull { it == "Android" })

    println("  ------   last -------")
    println(list.last())
    println(list.last{ it == "Android" })
    println(list.lastOrNull())
    println(list.lastOrNull { it == "Android" })

    println("  ------   indexOf -------")
    println(list.indexOf("Android"))
    println(list.indexOfFirst { it == "Android" })
    println(list.indexOfLast { it == "Android" })

    println("  ------   single -------")
    val list2 = listOf("list")
    println(list2.single())     // 只有当集合只有一个元素时，才去用这个函数，不然都会抛出异常。
    println(list2.single { it == "list" }) //当集合中的元素满足条件时，才去用这个函数，不然都会抛出异常。若满足条件返回该元素
    println(list2.singleOrNull()) // 只有当集合只有一个元素时，才去用这个函数，不然都会返回null。
    println(list2.singleOrNull { it == "list" }) //当集合中的元素满足条件时，才去用这个函数，不然返回null。若满足条件返回该元素

    println("  ------   forEach -------")
    list.forEach { println(it) }
    list.forEachIndexed { index, it -> println("index : $index \t value = $it") }

    println("  ------   componentX -------")
    println(list.component1())  // 等价于`list[0]  <=> list.get(0)`
    println(list.component2())  // 等价于`list[1]  <=> list.get(1)`
    println(list.component3())  // 等价于`list[2]  <=> list.get(2)`
    println(list.component4())  // 等价于`list[3]  <=> list.get(3)`
    println(list.component5())  // 等价于`list[4]  <=> list.get(4)`
}

fun sortFunc(){
    val list1 = listOf(-1,-3,1,3,5,6,7,2,4,10,9,8)

    println(list1.reversed())

    println(list1.sorted())

    println(list1.sortedBy { it % 2 == 0})

    println(list1.sortedDescending())

    println(list1.sortedByDescending { it % 2 == 0 })
}

fun mapFunc(){
    val list1 = listOf("kotlin","Android","Java","PHP",null,"JavaScript")

    println(list1.map { "str-".plus(it) })

    println(list1.mapNotNull { "str-$it" })

    println(list1.mapIndexed { index, str ->
        index.toString().plus("-").plus(str)
    })

    println(list1.mapIndexedNotNull { index, str ->
        index.toString().plus("-").plus(str)
    })

    println( list1.flatMap { listOf(it,"new-".plus(it)) })

    val list2 = listOf("kotlin","Android","Java","PHP","JavaScript")
    println(list2.groupBy { if (it.startsWith("Java")) "big" else "latter" })
}

fun filterFunc(){
    val list1 = listOf(-1,-3,1,3,5,6,7,2,4,10,9,8)
    val list2 = listOf(1,3,4,5,null,6,null,10)
    val list3 = listOf(1,1,5,2,2,6,3,3,7,4,4,8)

    println("  ------   filter -------")
    println(list1.filter { it > 1  })
    println(list1.filterIndexed { index, result ->
        index < 5 && result > 3
    })
    println(list1.filterNot { it > 1 })
    println(list2.filterNotNull())

    println("  ------   take -------")
    println(list1.take(5))
    println(list1.takeWhile { it < 5 })
    println(list1.takeLast(5))
    println(list1.takeLastWhile { it > 5 })

    println("  ------   drop -------")
    println(list1.drop(5))
    println(list1.dropWhile { it < 5 })
    println(list1.dropLast(5))
    println(list1.dropLastWhile { it > 5 })

    println("  ------   distinct -------")
    println(list3.distinct())
    println(list3.distinctBy { it + 2 })

    println("  ------   slice -------")
    println(list1.slice(listOf(1,3,5,7)))
    println(list1.slice(IntRange(1,5)))
}

fun rebuildListFunc(){
    val list1 = listOf(1,2,3,4)
    val list2 = listOf("kotlin","Android","Java","PHP","JavaScript")

    println(list1.plus(list2))
    println(list1 + list2)

    println(list1.zip(list2))
    println(list1.zip(list2){       // 组成的新集合由元素少的原集合决定
        it1,it2-> it1.toString().plus("-").plus(it2)
    })

    val newList = listOf(Pair(1,"Kotlin"),Pair(2,"Android"),Pair(3,"Java"),Pair(4,"PHP"))
    println(newList.unzip())

    println(list2.partition { it.startsWith("Ja") })
}


fun statisticalFunc(){
    val list1 = listOf(1,2,3,4,5)

    println("  ------   any -------")
    println(list1.any())
    println(list1.any{it > 10})

    println("  ------   all -------")
    println(list1.all { it > 2 })

    println("  ------   none -------")
    println(list1.none())
    println(list1.none{ it > 2})

    println("  ------   max -------")
    println(list1.max())
    println(list1.maxBy { it + 2 })

    println("  ------   min -------")
    println(list1.min())        // 返回集合中最小的元素
    println(list1.minBy { it + 2 })

    println("  ------   sum -------")
    println(list1.sum())
    println(list1.sumBy { it + 2 })
    println(list1.sumByDouble { it.toDouble() })

    println(" ------  average -----")
    println(list1.average())

    println("  ------   reduce  -------")
    println(list1.reduce {
        result, next ->
        result  + next
    })

    /**
     * index = 1  result = 1, next = 2  	 1+1+2=4
     * index = 2  result = 4, next = 3  	 2+4+3=9
     * index = 3  result = 9, next = 4  	 3+9+4=16
     * index = 4  result = 16, next = 5  	 4+16+5=25
     *
     * 25
     */
    println(list1.reduceIndexed { index, result, next ->
        print("index = $index  result = $result, next = $next  \t")
        index + result + next
    })
    println(list1.reduceRight { result, next -> result  + next })
    println(list1.reduceRightIndexed {index, result, next ->
        index + result + next
    })

    println("  ------   fold  ---有个初始值 这里是3 故结果都比reduce函数结果多3--")
    println(list1.fold(3){result, next -> result  + next})
    println(list1.foldIndexed(3){index,result, next ->
        index + result  + next
    })
    println(list1.foldRight(3){result, next -> result  + next})
    println(list1.foldRightIndexed(3){index,result, next ->
        index + result  + next
    })
}