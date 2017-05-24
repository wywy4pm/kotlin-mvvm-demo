package com.kotlin.arun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var a: Int = 0
    var s = "asdsa"
    var b = "s.length is${s.length}"
    var c = "s = $s"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a = sum(10, 20)
        var b = sum2(20, 30)
        println(a)
        println(b)
        printSum(a, b)
        initView()

    }

    fun initView() {

    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        println(a + b)
    }

    fun main(args: Array<String>) {

    }
}
