package com.kotlin.arun.listener

import android.support.annotation.StringRes

/**
 * Created by wy on 2017/5/22.
 */

interface CommonRequestListener<T> {
    fun onStart()

    fun onComplete()

    fun onSuccess(data: T)

    fun onError(errorType: Int, @StringRes errorMsg: Int)

}
