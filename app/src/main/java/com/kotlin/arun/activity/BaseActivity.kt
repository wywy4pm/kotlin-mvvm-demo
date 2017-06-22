package com.kotlin.arun.activity

import android.support.v7.app.AppCompatActivity
import com.kotlin.arun.bean.CommonApiResponse
import com.kotlin.arun.view.CommonView

/**
 * Created by wy on 2017/6/22.
 */

abstract class BaseActivity : AppCompatActivity(), CommonView<CommonApiResponse<*>> {
    override fun onRefreshComplete() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(errorType: Int, errorMsg: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(errorType: Int, errorMsg: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
