package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/*
* 获取实时天气信息接口所返回的JSON数据格式
* {
    "status": "ok",
    "result": {
        "realtime": {
            "temperature": 23.16,
            "skycon": "WIND",
            "air_quality": {
                 "aqi": { "chn": 17.0 }
                }
            }
        }
    }
*/
/*
    将所有的数据模型类都定义在了RealtimeResponse的内部,可以防止出现和其他接口的数据模型类有同名冲突的情况
*/
data class RealtimeResponse(val status:String,val result:Result){

    data class Result(val realtime:Realtime)

    data class Realtime(val skycon:String,val temperature:Float,@SerializedName("air_quality") val airQuality:AirQuality)

    data class AirQuality(val aqi:AQI)

    data class AQI(val chn:Float)
}