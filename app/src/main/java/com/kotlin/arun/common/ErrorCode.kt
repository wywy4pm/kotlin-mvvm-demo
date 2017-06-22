package com.kotlin.arun.common

/**
 * Created by WY on 2017/4/14.
 */
object ErrorCode {
    val NETWORK_ERROR = -100//网络异常
    val DATA_FORMAT_ERROR = -200//数据解析异常
    val SYSTEM_ERROR = -300//系统异常

    val SUCCESS = 200//成功
    val NO_DATA = 404//无数据
    val LACK_OF_PARAMS = 400//缺少参数
    val SERVER_INNER_ERROR = 500//服务器内部错误
}
