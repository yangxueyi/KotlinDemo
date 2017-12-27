package com.example.zhang.kotlindemo.bean

/**
 * Created by YangXueYi
 * Time： 2017/12/20.
 */
class Person1 {
    private val _attributes = hashMapOf<String , String>()
    fun setAttribute(attrName : String , value : String){//保存到map中
        _attributes[attrName] = value
    }
//    val name : String
//        get() = _attributes["name"]!!//从map手动检索属性

    val name : String by _attributes //把map作为委托属性

}

