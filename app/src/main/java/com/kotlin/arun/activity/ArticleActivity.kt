package com.kotlin.arun.activity

import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.presenter.ArticlePresenter
import com.kotlin.arun.view.CommonView

class ArticleActivity : BaseActivity(), CommonView<CommonApiResponse<*>> {

    var articlePresenter: ArticlePresenter? = null
    var pageNum: Int = 1

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.kotlin.arun.R.layout.activity_article)

        articlePresenter = ArticlePresenter(this)
        articlePresenter?.attachView(this)
        request()
    }

    fun request() {
        articlePresenter?.getArticleListData(pageNum)
    }

    override fun refresh(data: CommonApiResponse<*>) {

    }

    override fun refreshMore(data: CommonApiResponse<*>) {

    }
}
