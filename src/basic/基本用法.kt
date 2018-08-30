package basic


/**
 * 1.关键字 变量名: 数据类型 = xxx
 *      var 可变变量   相当于Java中普通变量
 *      val 不可变变量 相当于Java中用final修饰的变量
 *
 *
 * 2.代码的结束可以省略掉分号;
 *
 * 3.声明后期初始化属性
 *      1.使用lateinit关键字
        2.必须是var声明的变量
        3.不能声明于可空变量
        4.不能声明于基本数据类型变量。例：Int、Float、Double等，注意：String类型是可以的。
        5.声明后，在使用该变量前必须赋值，不然会抛出UninitializedPropertyAccessException异常。

        例子:
            private lateinit var mTabLayout : TabLayout
            mTabLayout = find(R.id.home_tab_layout)
            mTabLayout.setupWithViewPager(mViewPager)

    4.声明延迟初始化属性
        1.使用lazy{}高阶函数，不能用于类型推断。且该函数在变量的数据类型后面，用by链接。
        2.必须是val声明的变量

        例子:
            private val mStr : String by lazy{
                "我是延迟初始化字符串变量"
            }

    5.注释嵌套
        /*
            第一层块注释
            /*
                第二层块注释
                /*
                    第三层块注释
                    意义不大
                */
            */
        */
 *  6.Kotlin中冒号(:)使用的地方很多：
        用于变量的定义
        用于继承
        用于接口
        方法的返回类型声明
 *
 *
 *
 */

//立即初始化
var var_a: Int = 10


//推导出类型
var var_b = 5

//未初始化必须声明类型 (类中声明变量 必须初始化)
var var_c: Float = 12.3f

fun main(args: Array<String>) {
    //未初始化必须声明类型 (局部变量编译器初始化)
    var var_d: Float
    var_d = 12.3f
    var_d += 1
    //var_d = null 但不能赋值为null

    println("NUM_A => $NUM_A")
    println("NUM_B => ${TestConst.NUM_B}")
    println("NUM_C => ${TestClass.NUM_C}")
}


/**
 * 声明常量的三种正确方式
 *      const只能修饰val，不能修饰var
 */
//1.顶层声明
const val NUM_A : String = "顶层声明"

//2.object修饰的类中
object TestConst{
    const val NUM_B = "object修饰的类中"
}

//3.伴生对象中
class TestClass{
    companion object {
        const val NUM_C = "伴生对象中"
    }
}