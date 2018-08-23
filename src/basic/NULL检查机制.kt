package basic

/**
 * NULL检查机制
 *      当可以确定这个属性或变量可能为空时，就把它声明为可空变量
 *      var/val 变量名 : 类型? = null/确定的值
 *
 *  Kotlin的空安全设计
 *      1.字段后加!!像Java一样抛出空异常
 *      2.字段后加?可不做处理返回值为 null
 *      3.?:做空判断处理
 */
fun main(args: Array<String>) {
    //定义一个不可为空的变量，用var修饰的变量可以被重新赋值，用val修饰的变量则不能，但是不能赋值为null
    var a : Int = 12
    a = 20
    // a = null 不能复制为null

    //声明可空变量 后面加上?,即变量可以被赋值为null
    var age: String? = null
    println(age)
//    val ages = age!!.toInt() //转换失败抛异常
//    val ages = age?.toInt() //不做处理返回 null
//    val ages = age?.toInt()?: -1 //age为空返回-1
    val ages = age as? Int //age强转失败返回null
    println("ages = $ages")

    val e = null
    println(e.toString())


    val builder:Builder? = Builder().setName("wsj")?.setAge(18)?.setSex(true)
    print(builder.toString())


    letFunc()
}

/**
 * 判断可空类型的两种使用方式
 *      1.if...else...判断 (同java)
 *      2.使用符号?.判断
 *          可空类型变量?.属性/方法  可以大量用于链式操作且避免空指针 只要链式其中的一个为null，则整个表达式都为null
 *
 *
 */

class Builder{
    private var name:String? = "tom"
    private var age:Int? = 0
    private var sex:Boolean? = null

    fun setName(name:String?) : Builder?{
        this.name = name
        return this
    }

    fun setAge(age : Int?) : Builder?{
        this.age = age
        return null//模拟此处为null
    }

    fun setSex(sex: Boolean?) : Builder?{
        this.sex = sex
        return this
    }

    override fun toString(): String {
        return "Builder(name=$name, age=$age, sex=$sex)"
    }
}

/**
 * 使用?.去返回一个值，那么方法的返回值的类型后面也要加上?符号
 */
fun funNullMethod() : Int? {
    val str : String? = "123456"
    return str?.length
}

/**
 * let操作符 变量为null时排除
 *      变量?.let{ ... }
 */
fun letFunc(){
    val arrTest : Array<Int?> = arrayOf(1,2,null,3,null,5,6,null)
    for (index in arrTest) {
        index?.let {
            println("不为null的值有: $it")
        }
    }
}
