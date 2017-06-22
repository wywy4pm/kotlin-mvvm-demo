package com.kotlin.arun.model

import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.kotlin.arun.R
import com.kotlin.arun.bean.ArticleListBean
import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.common.ErrorCode
import com.kotlin.arun.listener.CommonRequestListener

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import java.util.concurrent.TimeoutException

import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by wy on 2017/5/22.
 */

open class BaseModel {

    fun <T> request(observable: Observable<CommonApiResponse<T>>, listener: CommonRequestListener<CommonApiResponse<*>>?): Subscriber<*>? {
        val subscriber = object : Subscriber<CommonApiResponse<*>>() {
            override fun onCompleted() {
                listener?.onComplete()
            }

            override fun onError(e: Throwable) {
                if (e is ConnectException
                        || e is SocketTimeoutException
                        || e is TimeoutException
                        || e is UnknownHostException
                        || e is UnknownServiceException) {
                    listener?.onError(ErrorCode.NETWORK_ERROR, R.string.net_error)
                } else if (e is JsonSyntaxException || e is JsonParseException) {
                    listener?.onError(ErrorCode.DATA_FORMAT_ERROR, R.string.net_error_data_format)
                }
                listener?.onComplete()
            }

            override fun onNext(`object`: CommonApiResponse<*>?) {
                if (`object` != null) {
                    listener?.onSuccess(`object`)
                }
            }
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { listener!!.onStart() }
                .subscribe(subscriber)
        return subscriber
    }

}
