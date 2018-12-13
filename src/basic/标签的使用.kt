package basic

/**
 * 任何表达式都可以用标签（label）来标记
 * 格式为标识符后跟 @ 符号 【在此跳出到标签处】
 */
fun main(args: Array<String>) {
    foo()
}


fun foo() {
    val ints = arrayListOf(7, 8, 9, 0, 4, 5)

    //从最直接包围它的函数即 basic.foo 中返回 (同java)
    //输出结果 789
    ints.forEach {
        if (it == 0) return
        print(it)
    }

    //当遍历到0时 从 lambda 表达式中跳出
    //输出结果 78945
    ints.forEach lit@ {
        if (it == 0) return@lit
        print(it)
    }

    //隐式标签更方便。 该标签与接受该 lambda 的函数同名 (同上效果)
    //输出结果 78945
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }

    //匿名函数替代 lambda 表达式。
    //匿名函数内部的 return 语句将从该匿名函数自身返回
    //输出结果 78945
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        print(value)
    })
    println("===============")


    //标签的用处就是 跳出到标签所在处后再执行
    //例子一
    val arrayA = Array(5, { a -> a })
    val arrayB = Array(5, { a -> a })

    loopOuter@ for (a in arrayA) {
        loopInner@ for (b in arrayB) {
//            if (b > 2) break@loopInner//相当于只是内循环break不影响外循环
            if (b > 2) break@loopOuter //相当于在外循环使用了break
            println("b is $b")
        }
        println("外层循环次数: 第${a}次")
        println("===============")
    }

    //例子二
    returnTest()
}


fun returnTest(){
    val array = Array(5,{i -> i+1 })
    array.forEach {a->
//        if(a == 3) return@forEach //输出1245参考点
        if(a == 3) return@returnTest //输出12
        print(a)
    }
    print("参考点")
}