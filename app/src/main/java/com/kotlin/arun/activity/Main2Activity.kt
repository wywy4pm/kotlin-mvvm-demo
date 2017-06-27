package com.kotlin.arun.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.kotlin.arun.R
import com.kotlin.arun.adapter.MyListAdapter
import com.kotlin.arun.bean.User2
import com.kotlin.arun.databinding.ActivityMainBinding

class Main2Activity : AppCompatActivity() {
    private var list: ArrayList<User2>? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        list = ArrayList<User2>()
        for (i in 0..9) {
            val user = User2()
            user.name.set("aaaaa")
            user.age.set(i)
            user.imageUrl.set("http://bbs.qn.img-space.com/g3/M00/05/89/Cg-40llBB0-IB0EuADxKfYuIEJ4AAI5wgJEATAAPEqV491.jpg?imageView2/2/w/1024/q/90/ignore-error/1/")
            list!!.add(user)
        }
        binding!!.userList = list
        //binding.setMain(this);

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.layoutManager = layoutManager
        val listAdapter = MyListAdapter(list!!)
        binding!!.adapter = listAdapter
    }

    fun onClick(view: View) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show()
        changeText()
    }

    private fun changeText() {
        list!![0].name.set("哈哈哈")
        list!![0].age.set(23)
        list!![0].imageUrl.set("http://img0.ph.126.net/KTEafy8ouQoankeID5zdGA==/6632035335935140038.jpg")
        //binding.setUserList(list);
    }
}
