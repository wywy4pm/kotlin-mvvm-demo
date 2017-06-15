package com.kotlin.arun;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.kotlin.arun.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ArrayList<User2> list;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User2 user = new User2();
            user.name.set("aaaaa");
            user.age.set(i);
            user.imageUrl.set("http://bbs.qn.img-space.com/g3/M00/05/89/Cg-40llBB0-IB0EuADxKfYuIEJ4AAI5wgJEATAAPEqV491.jpg?imageView2/2/w/1024/q/90/ignore-error/1/");
            list.add(user);
        }
        binding.setUserList(list);
        binding.setMain(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.setLayoutManager(layoutManager);
        MyListAdapter listAdapter = new MyListAdapter(list);
        binding.setAdapter(listAdapter);
    }

    public void onClick(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
        changeText();
    }

    private void changeText() {
        list.get(0).name.set("哈哈哈");
        list.get(0).age.set(23);
        list.get(0).imageUrl.set("http://img0.ph.126.net/KTEafy8ouQoankeID5zdGA==/6632035335935140038.jpg");
        //binding.setUserList(list);
    }
}
