package basic


fun main(args: Array<String>) {
    //无需对抽象类或抽象成员标注open注解
    var student = SwimStudent("wsj", 28, "bj", 140F)
    var child = SwimChild()
}


/**
 * 抽象父类
 */
abstract class SwimPerson : Any() {
    val TAG = this.javaClass.simpleName  // 自身的属性
    /**
     *  1. 抽象属性在抽象类中不能被初始化 【只有定义，没有实现】
        2. 子类没有主构造函数，要对抽象属性，手动初始化。
           子类中有主构造函数，抽象属性可以在主构造函数中声明
     */
    abstract var addr: String
    abstract val weight: Float

    /**
     *  1.抽象方法必须用abstract关键字进行修饰
        2.抽象方法不用手动添加open，默认被open修饰
        3.抽象方法没有具体的实现
        4.含有抽象方法的类成为抽象类，必须由abtract关键字修饰
     */
    abstract fun doSwim()

    fun doFly() {
        println("doFly")
    }

    fun doEach() {
        println("doEach")
    }
}

//有主构造函数，抽象属性可以在主构造函数中声明
class SwimStudent(name: String, age: Int, override var addr: String, override val weight: Float) : SwimPerson() {
    override fun doSwim() {

    }
}

//没有主构造函数，要对抽象属性，手动初始化。
class SwimChild : SwimPerson() {
    override var addr: String
        get() = ""
        set(value) {}
    override val weight: Float
        get() = 1F

    override fun doSwim() {

    }

}