package com.example.zhang.kotlindemo.activity

import com.example.zhang.kotlindemo.interfaces.Clickable
import com.example.zhang.kotlindemo.interfaces.Focusable

/**
 * Created by YangXueYi
 * Time： 2017/12/4.
 */
/**
 * 定义一个类实现两个有同样方法的接口
 * */
class Button : Clickable, Focusable {
    override fun click() {

    }

    //如果同样的继承成员有不止一个实现，必须提供一个显示实现
    override fun showOff(){
        //使用尖括号加上父类型名字的“super”表明了你想要调用哪一个父类的方法
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }




}