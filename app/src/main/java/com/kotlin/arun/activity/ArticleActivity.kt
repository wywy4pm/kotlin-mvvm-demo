package com.kotlin.arun.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.arun.R
import com.kotlin.arun.adapter.ArticleListAdapter
import com.kotlin.arun.bean.ArticleListViewModel
import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.databinding.ActivityArticleBinding
import com.kotlin.arun.databindingcomponent.MyComponent
import com.kotlin.arun.presenter.ArticlePresenter
import com.kotlin.arun.view.CommonView

class ArticleActivity : BaseActivity(), CommonView<CommonApiResponse<*>> {

    var articlePresenter: ArticlePresenter? = null
    var pageNum: Int = 1
    var binding: ActivityArticleBinding? = null
    var articleList: ArrayList<ArticleListViewModel> = ArrayList()
    var articleAdapter: ArticleListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityArticleBinding>(this, R.layout.activity_article, MyComponent())
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.layoutManager = layoutManager
        articleAdapter = ArticleListAdapter(this, articleList)
        binding!!.articleAdapter = articleAdapter

        articlePresenter = ArticlePresenter(this)
        articlePresenter?.attachView(this)
        request()
    }

    fun request() {
        articlePresenter?.getArticleListData(pageNum)
    }

    @Suppress("unchecked_cast")
    override fun refresh(data: CommonApiResponse<*>) {
        if (data.body is List<*>) {
            articleList.addAll(data.body as Collection<ArticleListViewModel>)
            articleAdapter?.notifyDataSetChanged()
        }
    }

    override fun refreshMore(data: CommonApiResponse<*>) {

    }
}
