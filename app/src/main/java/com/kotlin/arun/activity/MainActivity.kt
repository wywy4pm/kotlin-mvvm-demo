package com.kotlin.arun.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.arun.R
import com.kotlin.arun.utils.Utils
import java.io.File

class MainActivity : AppCompatActivity() {
    val aa: String by lazy {
        aa
    }

    var a: Int = 0
    var s = "asdsa"
    var b = "s.length is${s.length}"
    var c = "s = $s"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        /* var a = sum(10, 20)
         var b = sum2(20, 30)
         println(a)
         println(b)
         printSum(a, b)
        initView()*/
        val u: Utils = Utils()
        val a: Int = 10
        val b: Int = 20
        Log.d("TAG", "扩展函数 = " + u.count(a, b))
        var path: String = ""
        try {
            var file: File = File(path)
            if (file.exists()) {
                var lists:Array<String> = file.list()
                lists[0]
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val  text = """   try {
            var file: File = File(path)
            if (file.exists()) {
                var lists:Array<String> = file.list()
                lists[0]
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }  """


    }

    fun Utils.count(a: Int, b: Int): Int {
        return a + b
    }

    fun initView() {
        val map = mapOf("key" to "value", "key1" to "value1")
        Log.d("TAG", "map key = " + map.keys.toString() + "  value = " + map.values.toString())
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        println(a + b)
    }

    fun main(args: Array<String>) {
        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        fruits.filter { it.startsWith("a") }.sortedBy { it }.map { it.toUpperCase() }.forEach { Log.d("TAG", it) }
    }
}
