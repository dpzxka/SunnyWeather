package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**封装ServiceCreator单例类*/
object ServiceCreator {
    /*指定根路径*/
    private const val BASE_URL = "https://api.caiyunapp.com"

    /*构建Retrofit对象，内部使用*/
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /*外部可见方法，通过create创建Service接口的动态代理对象*/
    /*val placeService = ServiceCreator.create(AppService::class.java)*/
    fun <T> create(serviceClass: Class<T>):T = retrofit.create(serviceClass)

    /*内联函数，泛型实例化，通过新的方法获得接口的动态代理：*/
    /*val placeService = ServiceCreator.create<PlaceService>()*/
    inline fun <reified T> create() :T = create(T::class.java)
}