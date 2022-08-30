package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.await

class SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await():T{
        
    }
}