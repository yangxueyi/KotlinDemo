package com.example.zhang.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.Person1
import com.example.zhang.kotlindemo.bean.Point

/**
 * Created by YangXueYi
 * Time： 2017/12/18.
 */
class KotlinChongZaiActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        //重载二元算术运算
        twoOperation()

        //解构声明
        jieGou()

        //在map中保存属性值
        map()


    }

    private fun map() {
        val p = Person1()
        val data = mapOf("name" to "lisi" , "company" to "JetBrains")
        for ((attrName,value) in data){
            p.setAttribute(attrName,value)
        }
        println(p.name)
    }

    private fun jieGou() {
        val p = Point(10,20)
        val (x,y) = p //解构声明
        println("x = $x")
        println("y = $y")
    }


    /*
        *重载二元算术运算
        */
    private fun twoOperation() {
        val p1 = Point(10,20)
        val p2 = Point(30,40)
        /**
         * 使用operator修饰符，可以直接使用+号求值
         * p1 + p2其实就是 p1.plus（p2）
         * Point中的方法
        */
        println(p1 + p2) //输出：Point(x = 40,y = 60)

        (0..10).forEach{ println(it)}

    }
}