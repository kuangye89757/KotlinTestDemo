package basic

/**
 * 类型检测及自动类型转换
 */
fun main(args: Array<String>) {
    var a = "23"
    println("长度个数为 : ${getStringLength(a)}")
}

fun getStringLength(obj:Any): Int? {

    //方式一
//    if(obj is String){
//        // 做过类型判断以后，obj会被系统自动转换为String类型
//        return obj.length
//    }
//    return null

    //方式二
//    if(obj !is String){
//        return null
//    }
//    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
//    return obj.length

    //方式三
    if(obj is String && obj.length > 0){
        //&&右边会自动转换为String
        return obj.length
    }
    return null


}
