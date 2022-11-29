package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

class PlaceViewModel: ViewModel() {
    private val searchLiveDate = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveDate) { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String) {
        searchLiveDate.value = query
    }
}