package com.example.zhang.kotlindemo.activity

//要想直接使用布局文件中的控件，必须添加这一句
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.zhang.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by YangXueYi
 * Time： 2017/12/12.
 */
class LambdaAndSAMActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alphabet = getAlphabet()
        val alphabet1 = alphabet()
        val str = alphabet.substring(0,alphabet.length-1)
        /*
        * indexof：返回指定字符在字符串中第一次虎刺吸纳的位置
        * 参1：字符
        * 参2：开始位置
        * 参3：默认false
        * 如果没有此字符就返回‘-1’
        * 参2,3可以省略
        * */
        val num = str.indexOf("B",0,false)
        val num_1 = str.lastIndexOf("B")

        Log.e("LambdaAndSAMActivity",str)
        Log.e("LambdaAndSAMActivity","num = " + num)
        Log.e("LambdaAndSAMActivity","num = " + num_1)


        val alphabet2 = getAlphabet2()
        Log.e("LambdaAndSAMActivity",alphabet2)

        initListener()
    }

    private fun initListener() {
        btn.setOnClickListener(listener)
        btn_1.setOnClickListener(listener)
    }

    val listener = View.OnClickListener{
        v -> val text = when(v.id){
        R.id.btn -> "我是123"
        R.id.btn_1 -> "我是456"
        else -> "我是谁"
    }
        Toast.makeText(this,text, Toast.LENGTH_LONG).show()
    }

    /*
    * with函数
    * 使用with构建字母表
    */
    fun getAlphabet() : String{
        val stringBuilder = StringBuilder()
        return with(stringBuilder) {
            for (letter in 'A'..'Z'){
                this.append(letter + "、")//通过显示 的"this"来调用接受者值的方法
            }
//            append("///OK")//省掉"this"也可以调用
            toString()//省掉"this"也可以调用
        }
    }
    //同上
    fun alphabet() = with(StringBuilder()){
        for(letter in 'a'..'z'){
            append(letter)
        }
         append(">>>>")
        toString()
    }

    /*
   * apply函数
   * 使用apply构建字母表  和with基本一样
   */
    fun getAlphabet2() = StringBuilder().apply {
        for (letter in 'A'..'Z'){
            append(letter)
        }
    }.toString()


}