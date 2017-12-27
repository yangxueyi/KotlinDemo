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
 data class People(var name :String, var age : Int){


    /*//实现toString方法:默认的toString格式是一串字符串
    override fun toString() = "People (name = $name , age = $age)"
    //实现equals方法
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is People)
            return false
        return name == other.name && age == other.age
    }

    //实现hashCode方法
    override fun hashCode(): Int = name.hashCode() * 31 + age*/

    /**上面的方法直接在累上面添加一个修饰符data就可以代替*/





    //伴生对象:就是一个普通对象:需要使用关键字：companion object
    /*companion object Loader{
        fun nameLength(name : String){
            val length = name.length
        }
    }*/

    //伴生对象实现接口
    /*companion object : LengthFactory<People>{
        override fun nameLength(name: String){
            val length = name.length
        }

    }*/

    //为伴生对象定义一个扩展函数
    companion object{}//声明一个空的伴生对象
    fun People.Companion.nameLength(name : String){//声明一个扩展函数
        val length = name.length
    }
    val peo = People.nameLength("lisi")


    fun isOlderThan(person : People) : Boolean? {
        if(age == null || person.age == null)
            return null
        return age > person.age
    }


}
