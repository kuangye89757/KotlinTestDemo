package basic


/**
 * Kotlin 中的两种不同的延迟初始化的实现
 *
 *      lateinit 只用于变量 var，而 lazy 只用于常量 val
 *          1.lazy 应用于单例模式(if-null-then-init-else-return)，而且当且仅当变量被第一次调用的时候，委托方法才会执行
 *          2.lateinit 则用于只能生命周期流程中进行获取或者初始化的变量，比如 Android 的 onCreate()
 *
 */



fun main(args: Array<String>) {
    println("第一次")
    println(lazyValue)
    println("第二次")
    println(lazyValue)
}


/**
 * lazy()是接收一个 lambda 并返回一个 Lazy <T> 实例的函数，
 *      返回的实例可以作为实现延迟属性的委托：
 *          get()会执行已传递给lazy() 的 lambda 表达式并记录结果，
 *          后续调用 get() 只是返回记录的结果
 */
val lazyValue:String by lazy{
    println("computed!")
    "hello"
}


/**
 * //kotlin 封装：
        fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
        viewFinder(id) as V
        }

   //activity中扩展调用
        private val Activity.viewFinder: Activity.(Int) -> View?
        get() = { findViewById(it) }
        

   //在activity中的使用姿势
        val mTextView by bindView<TextView>(R.id.text_view)
        mTextView.text="执行到我时，才会进行控件初始化"

 */
