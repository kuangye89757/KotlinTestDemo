package basic

/**
 * fool 定义了一个函数
 *      该函数接收另一个函数 body作为参数(这里是一个无参函数)
 *      同时定义一个无参函数 method1

        然后我们调用 fool , 使用 this::method1 作为参数。
 */
class XX{
    fun main(args: Array<String>) {
        fool(this::method1)
    }


    fun fool(body:() -> Unit){
        body()
    }

    fun method1(){
        print("method")
    }
}

