package com.kotlin.arun.presenter

import android.content.Context
import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.listener.RequestListenerImpl
import com.kotlin.arun.model.ArticleModel
import com.kotlin.arun.view.CommonView

/**
 * Created by wy on 2017/6/22.
 */
class ArticlePresenter(context: Context) : BasePresenter<CommonView<CommonApiResponse<*>>>(context) {

    fun getArticleListData(pageNum: Int) {
        val listener = object : RequestListenerImpl(mvpView) {

            override fun onSuccess(data: CommonApiResponse<*>) {
                mvpView?.refresh(data)
            }
        }
        addSubscriber(ArticleModel.newInstance()!!.getArticleListData(pageNum, listener)!!)
    }
}