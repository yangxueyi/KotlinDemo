package com.example.zhang.kotlindemo.bean


/**
 * Created by YangXueYi
 * Time： 2017/12/18.
 */
data class Point(val x :Int , val y : Int) {
    //运算符：operator
    operator fun plus(other :Point) : Point{ //使用operator修饰符，可以直接使用+号求值
        return Point(x + other.x , y + other.y)
    }

}