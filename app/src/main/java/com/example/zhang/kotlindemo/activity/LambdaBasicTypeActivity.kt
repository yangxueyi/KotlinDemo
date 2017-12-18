package com.example.zhang.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.zhang.kotlindemo.R
import com.example.zhang.kotlindemo.bean.People2
import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by YangXueYi
 * Time： 2017/12/13.
 */
/*
*基本数据类型
*/
class LambdaBasicTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        //可空数据类型
        println(People2("lisi",32).isOlderThan(People2("wangwu",26)))
        println(People2("lisi",32).isOlderThan(People2("wangwu")))

        //类型转换
        val i = 1
        val l : Long = i.toLong()//必须显式的转换


        val reader = BufferedReader(StringReader("1\nhhhh\n2"))
        val readNumbers = readNumbers(reader)

        addValidNumbers(readNumbers)

        /*
        *创建字符数组
        * joinToString:
        * 参一：分隔符，可随意添加
        *       默认：", "
        *
        */
        val array = Array(26){ i -> ('a' + i).toString()}
        println(array.joinToString(","))

        //构造函数创建一个指定大小的新数组，所有元素初始化为零。
        val fiveZeros = IntArray(5)
        fiveZeros.forEach { println("item = $it") }


    }

    fun addValidNumbers(numbers : List<Int?>){
        var sum = 0
        var invalidNum = 0
        for (number in numbers){
            if(number != null){//检查是否为空
                sum += number
            }else{
                invalidNum++
            }
        }
        println("sum = $sum")
        println("invalidNum = $invalidNum")
        //可以使用filterNotNull()方法过滤掉null，但同时改变了集合的类型
        val filterNotNull : List<Int> = numbers.filterNotNull()//等同于上面的代码
        println("sum = ${filterNotNull.sum()}")
        println("invalidNum = ${numbers.size - filterNotNull.size}")
    }

    /*
    * 创建一个包含可空值的集合
    * reader.lineSequence():返回序列化以后每行的元素
    */
    fun readNumbers(reader : BufferedReader) :List<Int?>{
        val result = ArrayList<Int?>()
        for (line in reader.lineSequence()){
            println("line = $line")
            try {
                val number = line.toInt()
                result.add(number)
            }catch (e : NumberFormatException){
                result.add(null)
            }
        }
        return result
    }

}