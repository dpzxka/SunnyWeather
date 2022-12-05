package com.example.sunnyweather.logic.network

import kotlinx.coroutines.supervisorScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.math.ln

/*统一的网络数据源访问入口，对所有网络请求API封装*/
object SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()

    /* 动态接口代理方式二：   private val placeService = ServiceCreator.create(PlaceService::class.java)*/

    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()

    /*新增对WeatherService接口封装*/

    private val weatherService = ServiceCreator.create<WeatherService>()
    suspend fun getDailyWeather(lng:String,lat:String) = weatherService.getDailyWeather(lng,lat).await()
    suspend fun getRealtimeWeather(lng:String,lat:String) = weatherService.getRealtimeWeather(lng,lat).await()

    /*call定义为挂起函数，*/
    private suspend fun <T> Call<T>.await():T {
        /*suspendCoroutine函数必须在协程作用域或挂起函数中才能调用，它接收一个Lambda表达
        式参数，主要作用是将当前协程立即挂起，然后在一个普通的线程中执行Lambda表达式中的代码*/
        return suspendCoroutine { continuation ->
            enqueue(object :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if(body!=null) continuation.resume(body) //恢复被挂起的函数，并回调结果
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}