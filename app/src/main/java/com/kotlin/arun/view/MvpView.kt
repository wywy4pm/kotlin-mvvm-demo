package com.kotlin.arun.view

import android.support.annotation.StringRes

interface MvpView {

    fun onError(errorType: Int, @StringRes errorMsg: Int)

    fun onError(errorType: Int, errorMsg: String)

    fun onRefreshComplete()
}
