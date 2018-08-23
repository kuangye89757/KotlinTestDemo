package basic

/**
 * 关键字 class 声明类，后面紧跟类名
 *
 */
fun main(args: Array<String>) {
    classFunc()
//    classNestFunc()
//    classInnerFunc()
//    classAnonymousFunc()


    /**
     * 类的修饰符包括
     *      classModifier类属性修饰符
     *          abstract    // 抽象类
                final       // 类不可继承，默认属性
                enum        // 枚举类
                open        // 类可继承，类默认是final的
                annotation  // 注解类

     *      accessModifier访问权限修饰符
     *          private     // 仅在同一个文件中可见
                protected   // 同一个文件中或子类可见
                public      // 所有调用的地方都可见
                internal    // 同一个模块中可见
     */
}

/**
 * 类相关实例代码
 */
private fun classFunc() {
    val site = Runoob() //没有 new 关键字
    println(site.name)
    println(site.age)

    val person = Person("666",2)//主构造
    val person1 = Person("666", 3,18)//次构造1
    val person2 = Person("666", 3,18,100)//次构造2
    println("person1次构造成员age = ${person1.age}")
//    println("person2次构造成员age = ${person2.score}")  //报错: score非成员属性

    println("延时加载name = ${person.name}")
    person.lastName = "wang"
    println("lastName = ${person.lastName}")

    person.no = 8
    println("no小于10 = ${person.no}")
    person.no = 11
    println("no大于10 = ${person.no}")

//    person.height = 123F //外部类不能访问
    println("height = ${person.height}")
}

/************************************类定义**********************************/


class Runoob { // 类名

    //成员属性 var 声明为可变的 val 声明为不可变(只读 不能设置setter)
    var name: String = "wsj"
    var age: Int = 28
    var city: String = "bj"


    //成员函数
    fun foo() {
        print("FOO")
    }
}

class Empty //空类

/************************************构造函数**********************************/


/**
 * 允许有一个主构造函数和多个二级构造函数（辅助构造函数）
 *      1.主构造器位于类名之后
 *          无注释符或默认修饰符(public)时constructor关键字可省略  构造函数中的参数若不是var 默认是val只读
 *      2.二级构造器/辅助构造器
 *          constructor(参数列表)
 *
 */
class Person(var simple: String,sex:Int) {
    //  var allByDefault: Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法
    var initialized = 1 //类型为Int 默认实现setter 和 getter
    //  val simple: String? // 错误: 必须在构造函数中初始化  类型为String 默认实现getter
    val inferredType = 1   // 类型为 Int 类型,默认实现 getter
    lateinit var name: String

    /**
     *  因为Kotlin会使用null来对每一个用lateinit修饰的属性做初始化
     *  基础类型是没有null类型
     *
     *  lateinit不能修饰原始类型
     */
//  lateinit var age:Int  //错误
    var age:Int? = 0


    /**
     * 次构造函数 (晚于init初始化代码块)
     *      类已有主构造，则每个辅助构造需要通过另一个辅助构造直接或间接地委派给主构造
     *      使用this关键字对同一类的另一个构造函数进行委派
     */
    constructor(simple: String,sex: Int, age: Int) : this(simple,sex) {
        println("次构造函数1 ${age}")
        this.age = age + 1
    }

    /**
     * 构造函数参数列表设置默认值 用法同python
     */
    constructor(simple: String,sex: Int,age: Int,score:Int = 120):this(simple, sex, age){
        println("次构造函数2 ${score}")
    }

    /**
     * 初始化代码段 使用init关键字 可以使用构造函数中的参数
     */
    init {
        simple = "重命名"
//        sex = 2 //只读
        name = simple
        println("初始化代码块: simple = ${simple} sex = ${sex} age = ${age} name = $name")
    }


    /************************************setter and getter**********************************/
    /**
     * 两个可变变量 lastName 和 no， field表示接收的变量 用于属性的访问器
     * lastName 修改了 getter 方法，
     * no 修改了 setter 方法
     *
     * “一个变量后边加等于号”这种形式的时候 如 no: Int = 100 编译器翻译成调用setter方法
     * 出现 no 变量的地方都会被编译器翻译成 getter 方法
     *
     * 所以若在setter或getter中使用的话会出现死循环 所以使用field
     */
    var lastName: String = "zhang"
        get() = field.toUpperCase()
        set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 145.4f
        private set //私有化


}

/************************************嵌套类**********************************/
class Outer{
    private val bar:Int = 1
    class Nested{
        fun foo() = 2
        fun testFunc() {
            var ot = Outer() //需要访问创建外部类对象
            println(ot.bar)
        }
    }
}

fun classNestFunc(){
    var demo = Outer.Nested().foo() //嵌套类，Outer后边没有括号
    print("嵌套类函数 demo的值为: $demo")
}

/************************************内部类**********************************/

/**
 * 内部类使用 inner 关键字来表示
 *      构造内部类的对象，必须先构造外部类的对象
 *
 * 为了消除歧义，要访问来自外部作用域的this，
 * 使用this@label，其中 @label 是一个 代指 this 来源的标签
 * 即this的来源是外部类实例
 *
 *
 * 内部类可以直接通过 this@ 外部类名 的形式引用外部类的成员变量
 */

class Outer2{
    var bar = 1
    val v = "成员属性"
    inner class Inner{
        fun foo() = bar //访问外部类成员
        fun testFunc() : String{
            return this@Outer2.v //访问外部类成员
        }
    }
}

fun classInnerFunc(){
    var demo = Outer2().Inner().foo() // 内部类，Outer2后边有括号
    println("内部类函数 demo的值为 $demo")

    var demo1 = Outer2().Inner().testFunc()
    println("内部类可以引用外部类的成员，例如：$demo1")
}


/************************************匿名内部类**********************************/
/**
 * 使用对象表达式来创建匿名内部类
 */
class Test{
    var v = "成员属性"
    fun setInterfaceTest(test: InterfaceTest){
        test.test()
    }
}


interface InterfaceTest{
    fun test()
}

/**
 * object 是 Kotlin 的关键字 不能随意替换
 */
fun classAnonymousFunc(){
    var demo = Test()
    demo.setInterfaceTest(object: InterfaceTest {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}