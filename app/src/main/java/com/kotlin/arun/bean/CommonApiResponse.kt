package com.kotlin.arun.bean

/**
 * Created by wy on 2017/5/22.
 */

data class CommonApiResponse<T>(
        var code: Int = 0,
        var uid: String? = null,
        var msg: String? = null, var body: T? = null)
