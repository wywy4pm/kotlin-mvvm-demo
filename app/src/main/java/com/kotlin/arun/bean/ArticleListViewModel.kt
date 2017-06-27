package com.kotlin.arun.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.kotlin.arun.BR

/**
 * Created by WY on 2017/4/13.
 */
class ArticleListViewModel : BaseObservable() {

    @get:Bindable
    var brief: String? = null
        set(brief) {
            field = brief
            notifyPropertyChanged(BR.brief)
        }

    @get:Bindable
    var headImage: String? = null
        set(headImage) {
            field = headImage
            notifyPropertyChanged(BR.headImage)
        }

    @get:Bindable
    var id: String? = null
        set(id) {
            field = id
            notifyPropertyChanged(BR.id)
        }

    @get:Bindable
    var title: String? = null
        set(title) {
            field = title
            notifyPropertyChanged(BR.title)
        }
}






