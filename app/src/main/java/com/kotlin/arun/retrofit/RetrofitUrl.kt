package com.kotlin.arun.retrofit

object RetrofitUrl {
    const val V1 = "/v1"
    //public static final String V2 = "/v2";
    const val ARTICLE = "/article"
    const val WORKS = "/works"
    const val CONFIG = "/config"
    const val USER = "/user"

    const val ARTICLE_LIST = ARTICLE + V1 + "/list"
    const val ARTICLE_DETAIL = ARTICLE + V1 + "/detail"

    const val WORKS_LIST = WORKS + V1 + "/list"
    const val WORKS_GOODS = WORKS + V1 + "/goods"
    const val WORKS_ONE_DAY_LEFT = WORKS + V1 + "/onedayGoods"
    const val WORKS_SINGLE_DETAIL = WORKS + "/single"
    const val WORKS_AUDIT = WORKS + "/getAuditList"

    const val USER_ACTION = USER + V1 + "/action"
    const val USER_DEVICE_TOKEN = USER + "/addToken"
    const val USER_HIDE_SWITCH = USER + "/readSwitch"
    const val USER_MESSAGE_LIST = USER + "/msgList"
    const val USER_ADD_MESSAGE = USER + "/addMsg"

    const val CONFIG_QUERY = CONFIG + V1 + "/query"

}
