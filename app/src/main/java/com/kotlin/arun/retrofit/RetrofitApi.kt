package com.kotlin.arun.retrofit

import com.kotlin.arun.bean.ArticleListViewModel
import com.kotlin.arun.bean.CommonApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RetrofitApi {

    @GET(RetrofitUrl.ARTICLE_LIST)
    fun getArticleList(@Query("pageNum") pageNum: Int): Observable<CommonApiResponse<List<ArticleListViewModel>>>

}


