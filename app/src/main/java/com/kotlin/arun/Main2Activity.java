package com.kotlin.arun;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            list.add(user);
        }
        binding.setUserList(list);
        binding.setMain(this);
        changeText();
    }

    public void onClick(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
    }

    private void changeText() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.get(0).name.set("哈哈哈");
                list.get(0).age.set(23);
                //binding.setUserList(list);
            }
        }, 2000);
    }
}
