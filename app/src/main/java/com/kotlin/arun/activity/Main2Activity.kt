package com.kotlin.arun.activity

import android.support.v7.widget.LinearLayoutManager
import com.kotlin.arun.adapter.MyListAdapter
import com.kotlin.arun.bean.User2

class Main2Activity : android.support.v7.app.AppCompatActivity() {
    private var list: java.util.ArrayList<User2>? = null
    private var binding: com.kotlin.arun.databinding.ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main);
        binding = android.databinding.DataBindingUtil.setContentView<com.kotlin.arun.databinding.ActivityMainBinding>(this, com.kotlin.arun.R.layout.activity_main)
        list = java.util.ArrayList<User2>()
        for (i in 0..9) {
            val user = User2()
            user.name.set("aaaaa")
            user.age.set(i)
            user.imageUrl.set("http://bbs.qn.img-space.com/g3/M00/05/89/Cg-40llBB0-IB0EuADxKfYuIEJ4AAI5wgJEATAAPEqV491.jpg?imageView2/2/w/1024/q/90/ignore-error/1/")
            list!!.add(user)
        }
        binding!!.userList = list
        //binding.setMain(this);

        val layoutManager = android.support.v7.widget.LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.layoutManager = layoutManager
        val listAdapter = MyListAdapter(list!!)
        binding!!.adapter = listAdapter
    }

    fun onClick(view: android.view.View) {
        android.widget.Toast.makeText(this, "点击事件", android.widget.Toast.LENGTH_SHORT).show()
        changeText()
    }

    private fun changeText() {
        list!![0].name.set("哈哈哈")
        list!![0].age.set(23)
        list!![0].imageUrl.set("http://img0.ph.126.net/KTEafy8ouQoankeID5zdGA==/6632035335935140038.jpg")
        //binding.setUserList(list);
    }
}
