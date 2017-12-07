package com.example.zhang.kotlindemo.activity




//要想直接使用布局文件中的控件，必须添加这一句
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.User
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("UNREACHABLE_CODE")
/**
 * Created by yang
 * Time 2017/11/21.
 */
var x  =  222
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //可以直接使用布局文件中定义的id
        tv.text = "kotlin demo"

        toast("Hello Kotlin")
        val max = getMax(2, 3)
        println( "max====$max")
//        println( "max1====$max1")

//        getMax1(3,4)
        forOf("Number")

        //在 kotlin 中访问顶级类的属性，我们也可以使用 :: 操作符
        println(::x.get())
        ::x.set(123456)
        println(x)



        println("rgb = ${Color.BLUE.rgb()}")

        /*
        * downTo:倒序输出
        * step:指定任意步长
        * .. 两个点表示 范围区间 :  1 <= x <= 10
        * */
        for (x in 9 downTo 0 step 3) {
            println(x)
        }
        for (x in 1..10 step 2) {
            println("x===== $x")

        }


        val ddd = Nested().foo()
        println("ddd = $ddd")

        val fff = KotlinActivity().Nested1().foo()
        println("fff = $fff")


        mixOptimized(Color.RED, Color.YELLOW)

        printX("ooo")





        val name : String = "kkab.cll"
        val name1 : String = "abc"
        if(name1 in name){//Java:  name.contins(name1)
            println("name==== $name and $name1")
        }else{
            println("*******")
        }

        println(name.split(""))


        val l = if(name != null) name.length else -1
        //Elvis 操作符  ?:
        val length = name.length ?: -1//等同于上式
        //!! 操作符   返回一个非空的 b 或者抛出一个 b 为空的 NPE
        val length1 = name !!.length



        val user = User(1,"lisi","6543210")
        user.saveUser(user)


    }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG){
        Toast.makeText(this,message,length).show()
    }

    //创建单例
    object Resource {
        val name = "Name"
    }

    //if传统用法/
    fun getMax(a : Int,b : Int): Int {

       /*  if (a > b) {
            return a
         } else {
            return b
         }*/

        val max = if(a > b) a else b

       return max
    }

    //使用 if 作为表达式:
    fun getMax1(a : Int, b :Int) =  if(a > b) a else b


    //for循环
    fun forOf(number : String){
        val list = arrayListOf("1","2","3","4")
        val list1 = listOf(0,1,2,3,4,5)
        val li = ArrayList<String>()
        li.add("hellttttt")
        println("li ===== ${li[0]}")

        //创建map
        val map = mapOf(1 to "one" , 2 to "two" ,3 to "three")

        //forEach比普通的for循环更简洁
        list.forEach { println("$number ==== $it") }

        for (str in list){
            Log.e("KotlinActivity",str)
        }

        for (index in list.indices){
            //String 内插 : index = $index
            println("index = $index; item =  ${list[index]}")
        }

        //index角标    element对应的元素
       for ((index,element) in list.withIndex()){
           println("$index : $element")
       }


        //过滤 list
//        val positives = list1.filter { x -> x > 0 }
        val positives = list1.filter { it > 1 }
        println("positives = $positives size = ${positives.size}")


        println(list.joinToString(" "))

//        val compare : (x: T,y: T) -> Int =

    }


    /*
    * “try/catch”表达式
    * */
    fun test() {
        val result = try {
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }

    }

    /*
    * “if”表达式
    * */
    fun foo(index : Int){
        val result = if(index == 1){
            "one"
        }else if (index == 2){
            "two"
        }else{
            "three"
        }
    }

    /*
    * "when"表达式：类似于Java中的switch
    * */
    fun transform(color: String?) {

        when (color) {
            "Red" ->  0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    private val bar: Int = 1
    //嵌套类
    class Nested {
        fun foo() = 2
    }
    //内部类： inner 这样就可以访问外部类的成员。内部类拥有外部类的一个对象引用：
    inner class Nested1{
        fun foo() = bar
    }


    enum class Color(val r :Int,val g : Int,val b : Int){
        RED(255,0,0),ORANGE(255,165,0),YELLOW(255,255,0),GREEN(0,255,0),
        BLUE(0,0,255),INDIGO(75,0,130);

        fun rgb() = (r * 255 + g) * 255 + b
    }

    fun mixOptimized(c1 : Color, c2 : Color){
        when{
            (c1 == Color.RED && c2 == Color.BLUE || c2 == Color.RED && c1 == Color.BLUE) -> println("true11111")
            else -> println("false")
        }
    }

    fun printX(x : Any){
        when(x){
            is Int -> println(x)
            is String -> println("length = ${x.length}")
            else -> println("000000")
        }
    }

}

