package com.kotlin.arun.view

/**
 * Created by WY on 2017/4/14.
 */
interface CommonView<T> : MvpView {
    fun refresh(data: T)

    fun refreshMore(data: T)
}
