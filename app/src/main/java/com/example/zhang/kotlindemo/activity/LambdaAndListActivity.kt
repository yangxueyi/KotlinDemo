package com.example.zhang.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.People

/**
 * Created by YangXueYi
 * Time： 2017/12/6.
 */
class LambdaAndListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lambda()
        //lambda改变局部变量
        val responses = listOf("4251","255","456")
        printProblemCounts(responses)
    }


    /**
   * lambda表达式
   * */
    fun lambda(){
        /*
         * Lambda 表达式的完整语法形式
         * 箭头前面：参数
         * 箭头后面：函数体
         */
        val sum = {x : Int,y : Int -> x + y}
        //把所有可选标注都留下，看起来如下：
        val sum1 : (Int,Int) ->Int = {x,y -> x + y}

        val sum2 = {x : Int , y :Int ->
            println("Computing the sum of $x and $y")
            x+y
        }
        println(sum2(1,2))
        //使用lambda比较认的年龄
        var list = listOf(People("lisi", 20), People("wangwu", 23), People("zhaoliu", 23))
        /*
        * 集合函数式API
        */
        listAPI(list)

        list.maxBy { it.age }
        //直接使用maxBy就可以进行比较，参数就是一个lambda表达式
        println(list.maxBy { it.age })//"it"是自动生成的参数名称
        list.maxBy { p : People -> p.age }//等同于：list.maxBy { it.age }；更简单的模式：People::age,可读性差
        //更简单的模式：People::age,可读性差
        println(People :: age)
        val age = { p : People -> p.age  }//用变量存储lambda是，必须显示的指定参数类型
        list.maxBy { p -> p.age }//自己推导出参数类型,将参数类型移除
        //获取姓名
        list.joinToString (separator = "",transform = {p : People -> p.name})//清晰的表达出lambda用在哪里
        list.joinToString { p : People -> p.name }//简洁但不够清晰

        //bean对象
        val people = People("lisi",12)
        println(people.toString())
        people.name = "zhangsan"
        people.age = 33
        println("$people")


    }
    /*
     * 集合函数式API
     */
    private fun listAPI(list : Collection<People>){

        //filter过滤器：过滤年龄大于20 的人
        list.filter { it.age > 20 }
        //通过map创建一个新的集合：只有名字的集合
        list.map { it.name }//也可以使用成员引用重写：list.map(People::name)
        //打印出年纪大于20岁的人的名字
        list.filter { it.age > 20 }.map { People::name }

        /*
         *如果元素很多，链式就会变得十分低效。可以转换为序列，而不是直接使用集合
         * filter和map的顺序：
         *    1：先map后filter：每个元素都要进行分组后在进行过滤，执行次数会比较多
         *    2：先filter后map：不适合的元素会被尽早的去除，执行次数减少，节省时间
         */
        list.asSequence()  //把集合转换为序列
            .filter { it.age > 20 }
            .map { People :: name }
            .toList() //把序列转换为列表

        /*
        * 创建序列有两种方式：
        *   1，list.asSequence()
        *   2，generateSequence
        */

        //使用序列得到100之内的自然数之和
        val naturalNumber = generateSequence(0) { it + 1 }//获取自然数集合
        val numberTo100 = naturalNumber.takeWhile { it <= 100 }//拿到100之内的自然数集合
        println(numberTo100.sum())//只有调用sum的时候前两步才会执行




        //获取所有年龄最大的人
        val maxAge = list.maxBy(People::age)?.age//获取最大年龄
        list.filter { it.age == maxAge }

        //判断的条件
        val canBeInClub20 = { p: People -> p.age <= 20 }
        //all:所有元素都满足
        println(list.all(canBeInClub20))
        //any:至少有一个满足
        println(list.any(canBeInClub20))
        //count:满足条件的元素的个数
        println(list.count(canBeInClub20))
        //find:返回第一个满足条件的元素；可能为空，所以可以使用同义方法：firstOrNull
        println(list.find(canBeInClub20))// list.firstOrNull(canBeInClub20)
        //groupBy:分组...按照年龄分组
        println(list.groupBy { it.age })
        val list1 = listOf("a", "ab", "b")//按照首字母分组
        println(list1.groupBy { str: String -> str.first() })//结果:{a=[a, ab], b=[b]}
        println(list1.groupBy(String::first))//同上

    }

    /*lambda改变局部变量*/
    fun printProblemCounts(responses : Collection<String>){
        var startNum = 0
        var stopNum = 0  //声明局部变量
        responses.forEach{
            //startsWith : 如果该字符串以指定前缀开始，则返回“真”
            if(it.startsWith("4")){
                startNum++
                //endsWith:如果该字符串以指定后缀结束，则返回“真”
            }else if(it.endsWith("5")){
                stopNum++
            }
        }
        println("startNum ==== $startNum \n stopNum ==== $stopNum")
    }

}