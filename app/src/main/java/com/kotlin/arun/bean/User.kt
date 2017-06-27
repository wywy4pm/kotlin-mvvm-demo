package com.kotlin.arun.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.kotlin.arun.BR

/**
 * Created by wy on 2017/5/23.
 */

class User : BaseObservable() {
    @get:Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }
    @get:Bindable
    var age: Int = 0
        set(age) {
            field = age
            notifyPropertyChanged(BR.age)
        }
}
