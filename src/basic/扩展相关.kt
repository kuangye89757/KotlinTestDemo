package basic

/**
 * 对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator(装饰者) 模式
 */
fun main(args: Array<String>) {
//    extendFunc()
//    extendFunc1()
//    extendFunc2()
//    extendFunc3()
//    extendFunc4()
//    extendFunc5()
    extendFunc6()
}

/**
 * 扩展函数可以在已有类中添加新的方法，【不会对原类做修改】
 *      fun receiverType.functionName(params){

        }

        1.receiverType：扩展函数的对象
        2.functionName：扩展函数的名称
        3.params：扩展函数的参数，可以为NULL
 */

class User(var name:String)

//扩展函数
fun User.print(){
    println("User类的扩展函数 : name = $name")
}

//扩展内置函数
fun MutableList<Int>.swap(index1:Int,index2:Int){
    //this关键字指代 扩展函数对象receiverType
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun extendFunc(){
    val c = User("wsj")
    c.print()

    val m = mutableListOf(1,2,3)
    m.swap(0,2)
    println(m.toString())

}

/**
 * 扩展函数是静态解析的
 *      调用扩展函数时，被调用的是哪一个函数，由调用函数的对象表达式来决定的，而不是动态类型决定: (不同于多态)
 */
open class CC

class DD:CC()

//扩展函数1 -- 扩展CC类的函数foo
fun CC.foo(){
    println("cc")
}

//扩展函数2 -- 扩展DD类的函数foo
fun DD.foo(){
    println("dd")
}

fun printFoo(cc: CC){
    println(cc.foo())
}

fun extendFunc1(){
    printFoo(DD())
}

/**
 * 扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数
 */
class Demo{
    fun foo(){
        println("成员函数")
    }
}

fun Demo.foo(){
    println("扩展函数")
}

fun extendFunc2(){
    val d = Demo()
    d.foo()
}

/**
 * 扩展一个空对象 (这样任何类不重写toString方法都会执行Any的扩展方法)
 */
fun Any?.toString():String{
    if(this == null) return "我是一个空对象"
    return toString()
}

fun extendFunc3(){
    val e = null
    println(e.toString())
}

/**
 * 扩展属性
 *      1.不允许定义在函数中
 *      2.因为属性没有后端字段field 所以不允许被初始化，只能由显式的getter/setter 定义
 *      3.只能被声明为val
 */
val Demo.bar: Int
    get() = 1

//val Demo.bar = "222"  错误 扩展属性不能有初始化器

/**
 * 伴生对象的扩展  【伴生对象相当于 Java 中的静态成员，其生命周期伴随类始终】
 *      一个类定义有一个伴生对象 ，也可以为其定义扩展函数和属性
 */
class MyClass{
    companion object {
        //伴生对象
    }
}

fun MyClass.Companion.foo(){
    println("我是伴生对象的扩展函数")
}

val MyClass.Companion.bar: String
    get() = "我是伴生对象的扩展属性"


fun extendFunc4(){
    println("bar = ${MyClass.bar}")
    MyClass.foo()
}

/************************************扩展作用域**********************************/
/**
 * 扩展函数或属性定义在顶级包下:
        package foo.bar

        fun Baz.goo() { …… }

   要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:
        package com.example.usage

        import foo.bar.goo // 导入所有名为 goo 的扩展
        // 或者
        import foo.bar.*   // 从 foo.bar 导入一切

        fun usage(baz: Baz) {
            baz.goo()
        }
 */


/************************************扩展声明为成员**********************************/
/**
 * 在C类内，创建了D类的扩展。此时，C被成为分发接收者，而D为扩展接收者
 *   1.扩展函数中，可以调用分发接收者C的成员函数
 *   2.调用C类和D类都有的函数 扩展接收者D优先
 */
class D{
    fun bar(){
        println("D bar")
    }

    fun method(){
        println("D method")
    }
}

class E{
    fun method(){ //与D类的method同名
        println("E method")
    }

    fun baz(){
        println("E baz")
    }

    //在C类中扩展D类函数
    fun D.foo(){
        bar()
        baz()

        method()        //调用 D.method()，扩展接收者优先 可以通过ctrl+点击查看是否跳转到D方法的声明处
        this@E.method() //调用 E.method()，使用限定的this加标签指定
    }

    fun caller(d: D){
        d.foo()
    }
}

fun extendFunc5(){
    val e = E()
    e.caller(D())
}

/*********************分发接收者虚拟解析 **** 扩展接收者静态解析******************************/
open class F{
}

class F_Child :F(){

}

//分发接收者
open class G{
    open fun F.foo(){
        println("F.foo in G")
    }

    open fun F_Child.foo(){
        println("F_Child.foo in G")
    }

    fun caller(f:F){
        f.foo() //由于扩展的是F 永远是静态解析的是F类的foo函数
    }
}

//分发接收者
class G_Child:G(){
    override fun F.foo(){
        println("F.foo in G_Child")
    }

    override fun F_Child.foo(){
        println("F_Child.foo in G_Child")
    }
}

fun extendFunc6(){
    G().caller(F())       //F.foo in G              动态解析后相当于 调用的是 G的caller函数
    G_Child().caller(F()) //F.foo in G_Child        动态解析后相当于  调用的是 G_Child的caller函数

    G().caller(F_Child()) //F.foo in G              动态解析后相当于 调用的是 G的caller函数        但扩展的是F 是静态解析跟其他类无关
    G_Child().caller(F_Child())//F.foo in G_Child   动态解析后相当于 调用的是 G_Child的caller函数  但扩展的是F 是静态解析跟其他类无关
}