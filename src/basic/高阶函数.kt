package basic

/**
 * 将函数用作一个函数的参数或者返回值的函数
 *
 */
fun main(args: Array<String>) {
    val testStr = "abc"
//    val sum = testStr.sumBy ({ it.toInt() })
    /**
     * 当函数中只有一个函数作为参数，并且您使用了lambda表达式作为相应的参数，则可以省略函数的小括号
     */
    val sum = testStr.sumBy { it.toInt() }
    //97 + 98 + 99 = 294
    println(sum)


    //这里会有IDE提示 Lambda argument should be moved out of parentheses 即可以将Lambda参数移动到括号外
    val result1 = resultByOpt(3, 4, { num1, num2 -> num1 - num2 })

    val result2 = resultByOpt(1, 2) { num1, num2 ->
        num1 + num2
    }
    println("result1 = $result1")
    println("result2 = $result2")

    testRun()
    testRun1()
    testRun2()
    testAlso()
    testLet()
    testTakeIf()
    testRepeat()
    //TODO()函数 -- 显式抛出NotImplementedError错误
    TODO("测试TODO函数，是否显示抛出错误")
}


// sumBy函数的源码
// 1.该函数返回一个Int类型的值。并且接受了一个selector()函数作为该函数的参数。其中，selector()函数接受一个Char类型的参数，并且返回一个Int类型的值。
// 2.定义一个sum变量，并且循环这个字符串，循环一次调用一次selector()函数并加上sum。用作累加。其中this关键字代表字符串本身。
inline fun CharSequence.sumBy(selector: (Char) -> Int): Int {
    var sum = 0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

/**
 * 传入两个参数，并传入一个函数来实现他们不同的逻辑
 */
private fun resultByOpt(num1: Int, num2: Int, result: (Int, Int) -> Int): Int {
    return result(num1, num2)
}

/***********************************常用的标准高阶函数Standard.Kt***********************************/
/**
 *  run()函数
 *      public inline fun <R> run(block: () -> R): R {
            return block()
        }
 *
 *      1.作为代码块是独立的 在run()函数中写一些和项目无关的代码，并不会影响项目的正常运行。
 *      2.传进去lambda表达式并返回了执行的结果
 */
private fun testRun() {
    val str = "kotlin"
    run {
        val whatever = "java"
        println("str = $whatever")
    }
    println("str = $str")
}

private fun testRun1() {
    val index = 3
    val num = run {
        when (index) {
            0 -> "kotlin"
            1 -> "java"
            2 -> "php"
            3 -> "javaScript"
            else -> "none"
        }
    }.length
    println("num = $num")
}

/**
 * T.run()函数 是在T类型下扩展的 传入lambda表达式想要使用【当前对象的上下文】的时候，可以使用这个函数
 *      public inline fun <T, R> T.run(block: T.() -> R): R {
            return block()
        }
 *
 *      val mTvBtn = findViewById<TextView>(R.id.text)
        mTvBtn.run{
            text = "kotlin"
            textSize = 13f
            ...
        }
 */
private fun testRun2() {
    val str = "kotlin"
    str.run {
        println("length = ${this.length}")
        println("first = ${first()}")
        println("last = ${last()}")
    }
}

/**
 * with()函数 同T.run()函数
 *      public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
            return receiver.block()
        }
 *
 *
 *      with是正常的高阶函数    T.run()是扩展的高阶函数。
        with函数的返回值指定了receiver为接收者。

   当使用对象可为null时，T.run()比with()函数更简洁
 */
private fun testRun3() {
    val str: String? = "kotlin"
    str?.run {
        println("length = ${this.length}")
        println("first = ${first()}")
        println("last = ${last()}")
    }

    with(str){
        println("length = ${this?.length}")
        println("first = ${this?.first()}")
        println("last = ${this?.last()}")
    }
}

/**
 * T.apply() 同T.run()函数
 *      public inline fun <T> T.apply(block: T.() -> Unit): T {
            block()
            return this
        }
 *
 *      T.run是返回了执行的结果
 *      T.apply返回了自身对象 多用于链式
 *
 *
 *      // 原始方法
        fun newInstance(id : Int , name : String , age : Int) : MimeFragment{
            val fragment = MimeFragment()
            fragment.arguments.putInt("id",id)
            fragment.arguments.putString("name",name)
            fragment.arguments.putInt("age",age)
            return fragment
        }

        // 改进方法
        fun newInstance(id : Int , name : String , age : Int) = MimeFragment().apply {
            arguments.putInt("id",id)
            arguments.putString("name",name)
            arguments.putInt("age",age)
        }
 */

/**
 * T.also()  同T.apply()函数
 *      public inline fun <T> T.also(block: (T) -> Unit): T {
            block(this)
            return this
        }

        T.also中只能使用it调用自身
        T.apply中只能使用this调用自身

        这就是为什么在一些函数中可以使用it,而一些函数中只能使用this的关键所在
 *
 */
private fun testAlso(){
    "kotlin".also {
        println("结果：${it.plus("-java")}")
    }.also {
        println("结果：${it.plus("-php")}")
    }

    "kotlin".apply {
        println("结果：${this.plus("-java")}")
    }.apply {
        println("结果：${this.plus("-php")}")
    }
}


/**
 * T.let() 与T.also()的区别在于返回值不同
 *      public inline fun <T, R> T.let(block: (T) -> R): R {
            return block(this)
        }
 */
private fun testLet(){
    "kotlin".let {
        println("原字符串：$it")         // kotlin
        it.reversed()
    }.let {
        println("反转字符串后的值：$it")     // niltok
        it.plus("-java")
    }.let {
        println("新的字符串：$it")          // niltok-java
    }

    "kotlin".also {
        println("原字符串：$it")     // kotlin
        it.reversed()
    }.also {
        println("反转字符串后的值：$it")     // kotlin
        it.plus("-java")
    }.also {
        println("新的字符串：$it")        // kotlin
    }
}

/**
 * T.takeIf()
 *      public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
            return if (predicate(this)) this else null
        }
 *
 *      传入一个条件，若对象符合则返回自身，反之则返回null
 *
 *
 * T.takeUnless()
 *      public inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? {
            return if (!predicate(this)) this else null
        }
 *
 *      传入一个条件，若对象符合则返回null，反之则返回自身
 *
 */
private fun testTakeIf(){
    val str = "kotlin"
    val result = str.takeIf {
        it.startsWith("k")
    }

    println("result = $result")
}


/**
 * repeat()
 *      public inline fun repeat(times: Int, action: (Int) -> Unit) {
            for (index in 0 until times) {
                action(index)
            }
        }
 *      根据传入的重复次数去重复执行一个函数
 */
private fun testRepeat(){
    repeat(5){
        println("我是重复的第${it + 1}次，我的索引为：$it")
    }
}