package com.example.zhang.kotlindemo.bean

/**
 * Created by YangXueYi
 * Time： 2017/12/21.
 */
data class SiteVisit(val path : String , val duration : Double , val os : OS)

/*
*创建一个enmu
*/
enum class OS {WINDOWS , LINUX , MAC , ANDROID , IOS}