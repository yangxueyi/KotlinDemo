package com.example.zhang.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.OS
import com.example.zhang.kotlindemo.bean.People
import com.example.zhang.kotlindemo.bean.Person
import com.example.zhang.kotlindemo.bean.SiteVisit

/**
 * Created by YangXueYi
 * Time： 2017/12/20.
 */
class KotlinGaoJieActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        twoAndThree { a, b -> a + b}
        twoAndThree { a, b -> a * b }

        val people = listOf(People("lisi",20), People("bod",30))
        lookForAlice(people)

    }


    /*
    *定义一个简单的高阶函数
    */
    fun twoAndThree(operation : (Int , Int) -> Int){//定义一个函数类型的参数
        val result = operation(2, 3)//调用函数类型的参数
        println("result = $result")


        val list = listOf("1","2","3","4")
        list.slice(0..2)
        println(list.joinToString(separator = ",,",prefix = "*",postfix = "!",transform = {it.toUpperCase()}))
        clearRepeat()
    }

    /*
    * 通过lambda去除重复代码
    */
    fun clearRepeat(){
        val logs = listOf(
                SiteVisit("/",32.0,OS.WINDOWS),
                SiteVisit("/",22.0,OS.MAC),
                SiteVisit("/logion",12.0,OS.WINDOWS),
                SiteVisit("/",8.0,OS.IOS),
                SiteVisit("/signup",16.3,OS.ANDROID)
                )

        val number = logs.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) }
        println("number = $number")

        val num = logs.averageDurationFor { it.os == OS.ANDROID && it.path == "/signup" }
        println("num = $num")

        mutableListOf<Person>()

    }

    fun List<SiteVisit>.averageDurationFor(predicate : (SiteVisit) -> Boolean) =
            filter(predicate) //根据lambda表达式去除不需要元素
                    .map(SiteVisit::duration) //拿到参数duration的集合
                    .average() //求平均值



    /*
    * 匿名函数
    */
    fun lookForAlice(list: List<People>){
        list.forEach(fun (person){ //使用匿名函数取代lambda表达式
            if(person.name == "lisi") return  //return指向最近的函数：一个匿名函数
            println("${person.name} is not lisi") //如果使用lambda，return则指向最外层的函数
        })

        list.filter (fun (person) : Boolean{ //匿名函数和普通函数有相同的指定返回值类型的规则
            println("${person.age <25}")
            return person.age <25
        })
        //使用表达式体匿名函数
        list.filter  (fun (person) = person.age<25) //可以省略返回值类型
    }


}