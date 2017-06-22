package com.kotlin.arun.model

import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.listener.CommonRequestListener
import com.kotlin.arun.retrofit.RetrofitInit

import rx.Subscriber

/**
 * Created by wy on 2017/5/22.
 */

class ArticleModel : BaseModel() {

    companion object {

        @Volatile var instance: ArticleModel? = null

        fun newInstance(): ArticleModel? {
            if (instance == null)
                synchronized(ArticleModel::class.java) {
                    if (instance == null) {
                        instance = ArticleModel()
                    }
                }
            return instance
        }
    }

    fun getArticleListData(pageNum: Int, listener: CommonRequestListener<CommonApiResponse<*>>): Subscriber<*>? {
        return request(RetrofitInit.api!!.getArticleList(pageNum), listener)
    }

}
