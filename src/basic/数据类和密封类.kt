package basic

import javax.swing.text.View

fun main(args: Array<String>) {
//    copyFunc()
    parseFunc()
//    eval()
//    run(view, ui) // 最终调用
}

/**
 * 编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：(已经被定义或超类继承就不再生成)
 *      equals() / hashCode()
        toString() 格式如 "User(name=John, age=42)"
        componentN() functions 对应于属性，按声明顺序排列
        copy() 函数

    保证生成代码的一致性且有意义,有如下要求:
        1.主构造函数至少包含一个参数
        2.所有【主构造函数参数】必须标识为val或var
        3.数据类不可声明为 abstract, open, sealed 或 inner;
        4.数据类不能继承其他类 (可以实现接口)
        5.data为声明数据类的关键字，必须书写在class关键字之前。
        6.在没有结构体的时候，大括号{}可省略
        7.约定俗成的规定  参数过多时一个参数的定义占据一行

 */
data class UserBean(val name:String,val age:Int,val sex:String)


/**
 * 修改数据类的属性使用copy函数
 * 复制对象并修改
 */
fun copyFunc(){
    val user = UserBean("wsj",28,"male")
    val newUser = user.copy(name = "zf",sex = "female")
    println(user)
    println(newUser)
}

/**
 * 数据类的解构声明
 */
fun parseFunc(){
    val user = UserBean("wsj",28,"male")
//    val (name,sex,age) = user //解析顺序会错位
    val (name,age,sex) = user
    println("name = $name age = $age sex = $sex")
}


/**
 * 密封类 类似于枚举的扩展
 *      使用 sealed 修饰类 所有的子类都必须要内嵌在密封类中或必须存在于密封类的同一文件
 *      不能修饰 interface ,abstract class
 *
 *      枚举类的每一个枚举常量都只能存在一个实例
 *      密封类的子类可以存在多个实例
 */
sealed class Expr
//所有子类
data class Const(val number:Double):Expr()
data class Sum(val e1:Expr,val e2:Expr):Expr()
object NotANumber :Expr() //单例

fun eval(expr:Expr):Double = when(expr){
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

/**
 * 一种专门用来配合 when 语句使用的类
 */
//sealed class UiOp {
//    object Show: UiOp()
//    object Hide: UiOp()
//    class TranslateX(val px: Float): UiOp()
//    class TranslateY(val px: Float): UiOp()
//}


//// 先封装一个UI操作列表
//class Ui(val uiOps: List = emptyList()) {
//    operator fun plus(uiOp: UiOp) = Ui(uiOps + uiOp)
//}


//// 定义一组操作
//val ui = Ui() +
//        UiOp.Show +
//        UiOp.TranslateX(20f) +
//        UiOp.TranslateY(40f) +
//        UiOp.Hide

//// 定义调用的函数
//fun run(view: View, ui: Ui) {
//    ui.uiOps.forEach { execute(view, it) }
//}

//fun execute(view: View, op: UiOp) = when (op) {
//    UiOp.Show -> view.visibility = View.VISIBLE
//    UiOp.Hide -> view.visibility = View.GONE
//    // 这个 when 语句分支不仅告诉 view 要水平移动，
//    // 还告诉 view 需要移动多少距离，这是枚举等 Java 传统思想不容易实现的
//    is UiOp.TranslateX -> view.translationX = op.px
//    is UiOp.TranslateY -> view.translationY = op.px
//}

//    run(view, ui) // 最终调用
