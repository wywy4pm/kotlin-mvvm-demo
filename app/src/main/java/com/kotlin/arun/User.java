package com.kotlin.arun;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by wy on 2017/5/23.
 */

public class User extends BaseObservable {
    private String name;
    private int age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
