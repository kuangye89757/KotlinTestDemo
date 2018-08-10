package basic

/**
 * 与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现
 *   1.一个类或者对象可以实现一个或多个接口
 *   2.接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
 */
fun main(args: Array<String>) {
    val c = Child()
    c.bar()
    c.foo()
}

interface AA{
//    var tmp:String = "1" 错误 接口中的属性只能是抽象的，不允许初始化值
    var name:String //抽象的

    fun foo() //未实现
    fun bar(){ //已实现
        //函数体
        println("AA")
    }
}

interface BB{
    fun foo(){
        println("foo")
    }
    fun bar(){
        println("BB")
    }
}

class Child:AA,BB{
    override fun foo() {
        super<BB>.foo()
    }

    override fun bar() {
        super<AA>.bar()
        super<BB>.bar()
    }

    //重写属性
    override var name: String = "xxxx"

    //只需要实现未实现的接口方法



}