package basic

/**
 *      1.不需要实例化枚举类就可以访问枚举常量
 *
 *      2.每个枚举常量都包含两个属性：name（枚举常量名）和ordinal（枚举常量位置）
 */
fun main(args: Array<String>) {
    ConsoleColor.BLACK.print()

    println("name = " + ConsoleColor.RED.name + "\tordinal = " + ConsoleColor.RED.ordinal)
    println("name = " + ConsoleColor.WHITE.name + "\tordinal = " + ConsoleColor.WHITE.ordinal)
    println("name = " + ConsoleColor.BLACK.name + "\tordinal = " + ConsoleColor.BLACK.ordinal)
    println("name = " + ConsoleColor.GREEN.name + "\tordinal = " + ConsoleColor.GREEN.ordinal)

    //使用enumValues<T>()和 enumValueOf<T>()访问
    println(enumValues<ConsoleColor>().joinToString { it.name })
    println(enumValueOf<ConsoleColor>("RED"))
}

/**
 * 枚举常量的匿名类
 *      1.要实现枚举常量的匿名类，则必须提供一个抽象方法（必须重写的方法）。且该方法定义在枚举类内部。而且必须在枚举变量的后面。
        2.枚举变量之间使用逗号（,）分割开。但是最后一个枚举变量必须使用分号结束。不然定义不了抽象方法。
        3.每一个枚举常量就是一个对象。
 */
enum class ConsoleColor(var argb : Int){
    RED(0xFF0000){
        override fun print() {
            println("我是枚举常量 RED ")
        }
    },
    WHITE(0xFFFFFF){
        override fun print() {
            println("我是枚举常量 WHITE ")
        }
    },
    BLACK(0x000000){
        override fun print() {
            println("我是枚举常量 BLACK ")
        }
    },
    GREEN(0x00FF00){
        override fun print() {
            println("我是枚举常量 GREEN ")
        }
    };

    abstract fun print()
}
