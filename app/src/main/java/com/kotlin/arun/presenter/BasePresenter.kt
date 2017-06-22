package com.kotlin.arun.presenter

import android.app.Dialog
import android.content.Context

import com.kotlin.arun.view.MvpView

import rx.Subscriber
import java.util.*
import kotlin.collections.ArrayList


open class BasePresenter<T : MvpView>(private val context: Context) : Presenter<T> {

    var mvpView: T? = null
    private val dialog: Dialog? = null
    private var subscribers: ArrayList<Subscriber<*>>? = null

    init {
        subscribers = ArrayList()
    }

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
        for (subscriber in subscribers!!) {
            subscriber.unsubscribe()
        }
        //cancelDialog();
        subscribers = null
    }

    /**
     * 添加到列表，在detachView时取消订阅。在子类定义的subscriber需要手动调用添加

     * @param subscriber
     */
    fun addSubscriber(subscriber: Subscriber<*>) {
        subscribers!!.add(subscriber)
    }

    val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}
