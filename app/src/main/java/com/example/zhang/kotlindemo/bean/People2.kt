package com.example.zhang.kotlindemo.bean


/**
 * Created by yang
 * Time 2017/11/22.
 */


/**
*
* 会为 Peoper 类提供以下功能：
*  所有属性的 getters （对于 var 定义的还有 setters）
*   equals()
*   hashCode()
*   toString()
*   copy()
*   所有属性的 component1()、 component2()……等等
* */
 data class People2(var name :String, val age : Int? = null){

    fun isOlderThan(person : People2) : Boolean? {
        if(age == null || person.age == null)
            return null
        return age > person.age
    }


}
