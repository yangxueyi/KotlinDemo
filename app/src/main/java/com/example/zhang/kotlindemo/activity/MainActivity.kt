package com.example.zhang.kotlindemo.activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.zhang.kotlindemo.R
//要想直接使用布局文件中的控件，必须添加这一句
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    val a : Int = 3
    val b : Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //可以直接使用布局文件中定义的id
       tv.text = "kotlin demo"
        tv.textSize = 30f
        tv.visibility = View.VISIBLE
        tv.gravity  = Gravity.CENTER_HORIZONTAL

        btn.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn ->
                if (a < b){
                    Toast.makeText(this,"123", Toast.LENGTH_LONG).show()
                }else if (a==b){
                    Toast.makeText(this,"456", Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(this,"789", Toast.LENGTH_LONG).show()
            else ->
                    print(123)


        }
    }


}
