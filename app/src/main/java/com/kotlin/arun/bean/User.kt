package com.kotlin.arun.bean

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by wy on 2017/5/23.
 */

class User : android.databinding.BaseObservable() {
    @get:android.databinding.Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(com.kotlin.arun.BR.name)
        }
    @get:android.databinding.Bindable
    var age: Int = 0
        set(age) {
            field = age
            notifyPropertyChanged(com.kotlin.arun.BR.age)
        }
}
