package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    /*get请求：当searchPlaces调用时，Retorfit会发起get请求，请求的地址为@GET注解传入的参数，相对路径
    * 返回值需要声明为Retrofit的call类型，通过泛型来指定服务器相应的数据应该转换成什么对象*/
    //https://api.caiyunapp.com/v2/place?query=北京&token={token}&lang=zh_CN

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>
}