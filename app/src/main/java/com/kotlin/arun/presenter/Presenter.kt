package com.kotlin.arun.presenter


import com.kotlin.arun.view.MvpView

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()

}
