package com.kotlin.arun.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.amap.api.maps.AMap
import com.amap.api.maps.MapView

import com.kotlin.arun.R
import com.kotlin.arun.databinding.ActivityLbsBinding


class LbsActivity : Activity() {
    var binding: ActivityLbsBinding? = null
    var mapView: MapView? = null
    var aMap: AMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lbs)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_lbs)
        mapView = findViewById(R.id.mapView) as MapView?
        mapView?.onCreate(savedInstanceState)
        if (aMap == null) {
            aMap = mapView?.map
        }
        //binding?.mapView?.onCreate(savedInstanceState)

        /*if (aMap == null) {
            aMap = binding?.mapView?.map
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mapView?.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mapView?.onPause()
    }

    /*override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mapView?.onSaveInstanceState(outState)
    }*/

}
