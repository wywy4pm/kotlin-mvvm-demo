package com.kotlin.arun.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by wy on 2017/7/6.
 */
class PointView : View {

    var mContext: Context? = null

    constructor(context: Context?) : super(context) {
        mContext = context
    }

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint: Paint? = Paint()
        paint?.color = Color.RED
        paint?.style = Paint.Style.STROKE
        paint?.strokeWidth = 2f
        canvas?.drawRect(10f, 10f, 100f, 100f, paint)
    }
}