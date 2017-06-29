package com.kotlin.arun.activity

import android.app.Activity
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption

import com.amap.api.maps.AMap
import com.amap.api.maps.MapView
import com.amap.api.maps.model.MyLocationStyle
import com.kotlin.arun.R
import com.kotlin.arun.utils.Helper
import java.text.SimpleDateFormat
import java.util.*

class TestActivity : Activity() {
    internal var mMapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        //获取地图控件引用
        mMapView = findViewById(R.id.map) as MapView
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView!!.onCreate(savedInstanceState)

        //初始化地图控制器对象
        var aMap: AMap? = null
        aMap = mMapView!!.map

        setLocation(aMap)

        /*val newNum = Test.squareDigits(9119)
        Log.d("TAG", "newNum = " + newNum)*/

        //setLocation()
    }

    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView!!.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView!!.onResume()

    }

    override fun onPause() {
        super.onPause()
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView!!.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView!!.onSaveInstanceState(outState)
    }

    var myLocalStyle: MyLocationStyle? = null

    fun setLocation(aMap: AMap) {
        myLocalStyle = MyLocationStyle()
        myLocalStyle?.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)
        //myLocalStyle?.interval(2000)
        myLocalStyle?.showMyLocation(true)
        aMap.myLocationStyle = myLocalStyle
        aMap.isMyLocationEnabled = true
        aMap.setOnMyLocationChangeListener { location: Location? ->
            Log.d("TAG", "location = " + location.toString())
        }
        aMap.showIndoorMap(true)
        //aMap.mapType = AMap.MAP_TYPE_SATELLITE
        aMap.isTrafficEnabled = true
    }

    //声明mLocationOption对象
    var mLocationOption: AMapLocationClientOption? = null
    var mlocationClient: AMapLocationClient? = null

    fun setLocation() {
        mlocationClient = AMapLocationClient(this)
        //初始化定位参数
        mLocationOption = AMapLocationClientOption()
        //设置定位监听
        mlocationClient?.setLocationListener { amapLocation: AMapLocation? ->
            (
                    if (amapLocation?.errorCode == 0) {
                        //定位成功回调信息，设置相关消息
                        amapLocation.locationType//获取当前定位结果来源，如网络定位结果，详见定位类型表
                        amapLocation.latitude//获取纬度
                        amapLocation.longitude//获取经度
                        amapLocation.accuracy//获取精度信息
                        val df: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        val date: Date = Date(amapLocation.time)
                        df.format(date)//定位时间
                    } else {
                        //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + amapLocation?.errorCode + ", errInfo:"
                                + amapLocation?.errorInfo)
                    })
        }
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption?.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption?.interval = 2000
        //设置定位参数
        mlocationClient?.setLocationOption(mLocationOption)
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient?.startLocation()
    }
}
