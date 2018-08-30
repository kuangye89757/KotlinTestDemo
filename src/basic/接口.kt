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
//    val tmp1:String = "1" //错误 接口中的属性只能是抽象的，不允许初始化值
    val tmp:String
        get() = "1" //可以通过提供访问器实现

    var name:String //抽象的 修饰符只能是public
//    internal var name:String
//    private var name:String
//    protected var name:String

    //接口的私有方法 仅接口内使用
    private fun privateFunc(){}

    fun foo() //未实现
    fun bar(){ //已实现
        //函数体
        privateFunc()
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

    fun fun4() : String{
        return "fun4"
    }
}

class Child:AA,BB{
    override fun foo() {
        super<BB>.foo()
    }

    override fun bar() {
        //super<接口名>.方法名来区分
        super<AA>.bar()
        super<BB>.bar()
    }

    //重写属性
    override var name: String = "xxxx"

    //只需要实现未实现的接口方法

}