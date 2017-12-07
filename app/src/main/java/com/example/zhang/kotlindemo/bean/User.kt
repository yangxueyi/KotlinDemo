package com.example.zhang.kotlindemo.bean

/**
 * Created by YangXueYi
 * Time： 2017/12/1.
 */
/**
 *
 * 局部函数
 * */
class User(val id : Int,val name : String , val address : String) {

    fun saveUser(user : com.example.zhang.kotlindemo.bean.User){
        fun validate(user : com.example.zhang.kotlindemo.bean.User, value : String, fieldName : String){//声明一个局部函数来验证字段
            if(value.isEmpty()){
//                throw IllegalArgumentException("Can sava user ${user.id}: empty $fieldName")
                println("Can sava user ${user.id}: empty $fieldName")
            }
        }

        validate(user,user.name,"Name")//调用局部函数验证特定字段
        validate(user,user.address,"Address")

    }

    fun com.example.zhang.kotlindemo.bean.User.validateBeforeSave() {
        fun validate1(value: String, fieldName: String) {
            if (value.isEmpty()) {
                //可以直接访问User的属性
                throw IllegalArgumentException("Can sava user $id: empty $fieldName")
            }
        }
        validate1(name,"Name")
        validate1(address,"Address")
    }

    fun saveUser1(user : com.example.zhang.kotlindemo.bean.User){
        user.validateBeforeSave()//调用扩展函数
    }
}