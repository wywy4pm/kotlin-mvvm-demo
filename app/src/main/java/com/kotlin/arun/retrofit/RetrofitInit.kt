package com.kotlin.arun.retrofit

import com.kotlin.arun.common.Constant

import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInit {

    private var client: OkHttpClient? = null

    private val retrofit = Retrofit.Builder()
            .baseUrl(Constant.API_BASE_URL)
            .client(getClient())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getClient(): OkHttpClient? {
        if (client == null) {

            val interceptor = Interceptor { chain ->
                val originalRequest = chain.request()
                val authorised = originalRequest.newBuilder()
                        .build()
                chain.proceed(authorised)
            }

            client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()
        }
        return client
    }

    private var retrofitApi: RetrofitApi? = null

    val api: RetrofitApi?
        get() {

            if (retrofitApi == null) {
                retrofitApi = retrofit.create(RetrofitApi::class.java)
            }
            return retrofitApi
        }

    fun <T> createApi(mClass: Class<T>): T {
        return retrofit.create(mClass)
    }

}
