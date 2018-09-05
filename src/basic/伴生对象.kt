package basic

/**
 *  伴生对象内的成员相当于 【Java 中的静态成员】，其生命周期伴随类始终，
 *  在伴生对象内部可以定义变量和函数，这些变量和函数可以直接用类名引用。

对于伴生对象扩展函数，有两种形式，一种是在类内扩展，一种是在类外扩展，
有以下特点：
    （1）类内扩展的伴随对象函数和类外扩展的伴随对象可以同名，它们是两个独立的函数，互不影响；
    （2）类内扩展的伴随对象函数和类外扩展的伴随对象同名时，对于类内其它成员函数来说，类内扩展屏蔽类外扩展；
    （3）类内扩展的伴随对象函数只能被类内的函数引用
    （4）类外扩展的伴随对象函数可以被伴随对象内的函数引用
 */
class MyDemo {
    companion object {
        val myClassField1: Int = 1
        var myClassField2 = "this is myClassField2"
        fun companionFun1() {
            println("this is 1st companion function.")
            foo()
        }

        fun companionFun2() {
            println("this is 2st companion function.")
            companionFun1()
        }
    }

    fun MyDemo.Companion.foo() {
        println("伴随对象的扩展函数（内部）")
    }

    fun test2() {
        MyDemo.foo()
    }

    init {
        test2()
    }
}

val MyDemo.Companion.no: Int
    get() = 10

fun MyDemo.Companion.foo() {
    println("foo 伴随对象外部扩展函数")
}

fun main(args: Array<String>) {
    println("no:${MyDemo.no}")
    println("field1:${MyDemo.myClassField1}")
    println("field2:${MyDemo.myClassField2}")
    MyDemo.foo()
    MyDemo.companionFun2()
    println("=================================")
    MyDemo() //执行初始化代码块
}