package com.kotlin.arun.databindingcomponent

import android.databinding.DataBindingComponent
import com.kotlin.arun.utils.Utils

/**
 * Created by wy on 2017/6/23.
 */

class MyComponent : DataBindingComponent {

    private val utils: Utils.Companion = Utils.Companion

    override fun getCompanion(): Utils.Companion {
        return utils
    }

}
