package basic

/**
 *  Collections.kt
 *
 *  数组类型
 *      数组用类 Array 实现  使用 [] 重载了 get 和 set 方法
 *      ByteArray, ShortArray, IntArray，用来表示各个类型的数组，没有装箱开销
 *
 *      1.用arr[index]的获取元素。
        2.用arr.component1() ... arr.component5()获取数组的前5个元素。不确定元素个数的情况下慎用
        3.用arr.reverse()反转元素

    集合类型
        包含三种类型：它们分别是：List、Set、Map
        (基本同java的地方)
            1.都是接口
            2.都继承至Collection<out E>接口,而Collection又继承Iterable<out T>接口。只实现了isEmpty()、size属性、get()、contains()等函数
            3.分别有存在MutableList<E>、MutableSet<E>、MutableMap<K,V>接口，提供了改变、操作集合的方法。例如add()、clear()、remove()等函数
        (特殊地方)
            一、使用List<E>、Set<E>、Map<K,V> ---【不可变集合】
            二、使用MutableList<E>、MutableSet<E>、MutableMap<K,V> ---【可变集合】

 *
 */
fun main(args: Array<String>) {
    createArray()
    println("========")
    createList()
    println("========")
    createMutableList()
    println("========")
    createSet()
    println("========")
    createMap()

    //大小固定 元素类型不可变
    var arraylist = arrayOf("重庆", "上海", "广州", "深圳", "北京", "上海", "深圳", "北京", "上海")

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
    println("数组是否为空 " + arraylist.isEmpty())

    //获取其中元素：数组名[索引]，首元素：数组名.first，尾元素：数组名.last
    //获取前5个元素的快捷方法.component1到5
    println("========")
    println("首元素: " + arraylist.first())
    println("第二个元素: " + arraylist[1])
    println("第三个元素: " + arraylist.component3())
    println("最后一个元素: " + arraylist.last())

    //mutableList:MutableList<类型>或mutableListof(元素1.元素2，，，元素n)
    //大小可变 类型不变
    var newArraylist = mutableListOf("1", "2")
    var tempList = arrayOf("成都", "武汉")
    newArraylist.add("3")
    newArraylist.addAll(tempList)


    for (item in newArraylist) {
        print(item)
    }
    println("========")

    //移除元素remove，移出指定位置removeAt
    newArraylist.removeAt(0)
    newArraylist.removeAll(tempList)

    for (item in newArraylist) {
        print(item)
    }
    println("========")


    testXB()
}



/**
 * 创建数组的3个函数
 */
fun createArray() {
    //1. 使用函数arrayOf()创建数组
    //[1,2,3]
    val a = arrayOf(1, 2, 3)

    //2. 使用工厂函数创建数组
    //第一个参数表示数组元素的个数，第二个参数则为使用其元素下标组成的表达式
    //[0,2,4]
    val b = Array(3, { index -> index * 2 })

    //3. 创建一个指定数据类型且可以为空元素的数组
    val c = arrayOfNulls<Int>(3)


    for (i in a) {
        print(i)
    }
    println("========")
    for (i in b) {
        print(i)
    }
    println("========")

    for (i in c) {
        print("$i\t")
    }
}



fun sliceArray(list: Array<String>) {
    //获取数组中下标为1~4的数据
    val slice = list.slice(1..4)
    for (item in slice) {
        print(item)
    }
}

fun removeDuplicates(list: Array<String>) {
    //返回一个去重后的数组
    val norepeat = list.distinct()
    for (item in norepeat) {
        print(item)
    }
}

fun foreach(list: Array<String>) {
    for (item in list) {
        print(item)
    }
}


/**
 * 使用listOf()初始化不可变的List类型集合
 */
fun createList() {
    val list1 = listOf(1,2,"3",4.0f,"5") //任意创建
    val list2 = listOf<String>("1","2","3","4","5") //明确类型

    val arr = arrayOf("1","2",3,4,5)
    val list3 = listOf(arr) //传入一个数组

//    以下代码是错误的。因为List<E>只能是不可变集合。而add、remove、clear等函数时MutableList中的函数
//    list1.add()
//    list1.remove

    for (value in list1) {
        print("$value \t")
    }
}

/**
 * 使用mutableListOf()初始化可变的List类型集合
 */
fun createMutableList(){
    val mutableList1 = mutableListOf(1,2,"3",4.0f,"5") //任意创建
    val mutableList2 = mutableListOf<String>("1","2","3","4","5")  // 确定元素的值类型
    val arr = arrayOf("1","2",3,4,5)
    val mutableList3 = mutableListOf(arr) //传入一个数组
    val mutableList : ArrayList<String> = ArrayList() //同java的ArrayList

    mutableList1.add(true)
    mutableList2.add("6")
    mutableList.addAll(mutableList2)
    mutableList.removeAt(3)
    println("mutableList3.size = ${mutableList3.size}")

    for (s in mutableList) {
        print("$s \t")
    }

    mutableList3.clear()
}

/**
 * Set类型 同List的使用 只是有去重效果
 */
fun createSet(){
    val set1 = setOf(1,2,"3","4","2",1,2,3,4,5)
    val set2 = mutableSetOf(1,2,"3","4","2",1,2,3,4,5)

    for (s in set1) {
        print("$s \t")
    }
}

/**
 * Map类型
 */
fun createMap(){
    val map1 = mapOf("key1" to 2,"key2" to 3)
    val map2 = mapOf<String,Int>("key3" to 4,"key4" to 5)
    val mutableMap = mutableMapOf<String,Int>("key1" to 2,"key2" to 3)
    val hashMap = hashMapOf("key1" to 2,"key2" to 3)

    mutableMap.putAll(map2)
    for (s in mutableMap) {
        println("${s.key} \t ${s.value}")
    }
}


/**
 * 集合类型的协变 泛型继承情形
 *    一个集合赋值给另外一个集合时  List<E> 两个集合的类型都是E 没有问题
 *                                       E继承自M时。也可以把List<E>赋值给List<M>
 */
open class Personals(val name:String,val age:Int){
    override fun toString(): String {
        return "Personals(name='$name', age=$age)"
    }
}

class Childrens(name: String,age: Int) : Personals(name, age)

fun testXB(){
    val listChildrens : List<Childrens> = listOf<Childrens>(Childrens("wang",24), Childrens("zhou",25))
    val listPersonals : List<Personals>
    val listAnys : List<Any>

    listPersonals = listChildrens
    listAnys = listChildrens

    listPersonals.forEach {
       println(it.toString())
    }

    listAnys.forEach {
       println(it.toString())
    }


    /**
     * 当集合的类型相同或有继承关系时，一个集合使用MutableList，一个集合使用List的情况
     *
     *  public fun <T> Collection<T>.toMutableList(): MutableList<T> {
            return ArrayList(this)
        }

        public fun <T> Iterable<T>.toMutableList(): MutableList<T> {
            if (this is Collection<T>)
                return this.toMutableList()
            return toCollection(ArrayList<T>())
        }

        牢记toList()、toSet()、toHastSet()、toMutableList()、toSet()、toIntArray()等扩展函数
     *
     */
    val listChildrens1 : List<Childrens> = listOf(Childrens("wang",24), Childrens("zhou",25))
    val listPersonals2 : MutableList<Personals>
    listPersonals2 = listChildrens1.toMutableList() //List转换成了MutableList
    listPersonals2.add(Childrens("zhang",27))

    listPersonals2.forEach {
        println(it.toString())
    }
}