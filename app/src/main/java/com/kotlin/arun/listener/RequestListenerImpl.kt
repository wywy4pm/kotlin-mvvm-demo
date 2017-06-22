package com.kotlin.arun.listener

import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.view.MvpView

/**
 * Created by wy on 2017/5/22.
 */

abstract class RequestListenerImpl(private val mvpView: MvpView?) : CommonRequestListener<CommonApiResponse<*>> {

    override fun onStart() {

    }

    override fun onComplete() {
        mvpView?.onRefreshComplete()
    }

    override fun onError(errorType: Int, errorMsg: Int) {
        mvpView?.onError(errorType, errorMsg)
    }
}
