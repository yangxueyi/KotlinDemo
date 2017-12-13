package com.example.zhang.kotlindemo.activity



//要想直接使用布局文件中的控件，必须添加这一句
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.Person

/**
 * Created by YangXueYi
 * Time： 2017/12/12.
 */
@SuppressLint("LongLogTag")
class LambdaNullTypeActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        //可控性

        //安全调用运算符："?."
        val strLength = getStrLength(null)
        Log.e("LambdaTypeSystemActivity","strLength = "+strLength)
        pringtAllCaps("abc")

        //Elvis运算符："?:"
        foo(null)

        val length = strLength("123")
        val length1 = strLength(null)
        Log.e("LambdaTypeSystemActivity","length = "+length)
        Log.e("LambdaTypeSystemActivity","length = "+length1)

        //非空断言："!!"
        ignoreNulls("111")

        //"let"函数
        var email : String? = "123456@qq.com"//可空参数
        email?.let { sendEmailTo(it) }//不为空才执行。。。使用it代替参数
        email = null                  //lambda: email -> sendEmailTo(email) 等同于sendEmailTo(it)
        email?.let { sendEmailTo(it) }//为空就不执行lambda

        yellAtSafe(Person(null))
    }

    /*
    * 可空性
    */

    /**
     *安全调用运算符："?."
     */
    fun getStrLength(s : String?) = s?.length //等同于：if(s != null) s.length else null
    fun pringtAllCaps(s : String?){
        val str = s?.toUpperCase() //str可能为空
        println("str = $str")
    }

    /**
     * Elvis运算符："?:"  用其他值代替null
     * 含义：如果字符串不为空就输出自己，如果为空就输出第二个运算数
     */
    fun foo(s : String?){
        val str : String = s ?: "00"
        Log.e("LambdaTypeSystemActivity",str)
    }
    /**
     *"?."与"?:"一起使用
     * 字符串可以为空，如果不为空就输出字符串的长度，如果为空字符串长度就为0
     */
    fun strLength (s : String?) = s ?.length ?: 0


    /**
     * 安全转换："as?"
     * 含义：尝试把值转换为给定类型，如果类型不对就返回null
     */

    /**
     * 非空断言："!!"
     * 含义：如果值为空，可显式的抛出异常:kotlin.KotlinNullPointerException
     * 但是抛出异常的位置不是使用这个值的一行；而是非空断言所在的一行
     */
    fun ignoreNulls(s : String?) {
        val strNotNull = s!!
        println(strNotNull.length)
    }

    /**
     * "let"函数
     * 含义：安全调用"let"只在表达式不为null的时候执行（?.let{}）
     * let函数必须和安全运算符?.一起使用
     */
    fun sendEmailTo(email : String){//这个方法只接受非空参数
        println("email = $email")
    }

    fun yellAtSafe(people : Person){
        println((people.name ?: "knbhekJ").toUpperCase())
    }

}