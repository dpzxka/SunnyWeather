package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/*
* {"status":"ok","query":"北京","places":[
    {
        "id":"B000A83AJN",
        "name":"北京南站",
        "formatted_address":"中国 北京市 丰台区 永外大街车站路12号",
        "location":
            {
                "lat":39.865246,"lng":116.378517
            },
        "place_id":"a-B000A83AJN"
     },

    {"id":"B000A83M61","name":"北京西站","formatted_address":"中国 北京市 丰台区 莲花池东路118号","location":{"lat":39.89491,"lng":116.322056},"place_id":"a-B000A83M61"},
    {"id":"B000A83C36","name":"北京站","formatted_address":"中国 北京市 东城区 毛家湾胡同甲13号","location":{"lat":39.902842,"lng":116.427341},"place_id":"a-B000A83C36"},
    {"id":"B000A833V8","name":"北京北站","formatted_address":"中国 北京市 西城区 北滨河路1号","location":{"lat":39.944876,"lng":116.353063},"place_id":"a-B000A833V8"},
    {"id":"BV10006813","name":"北京站(地铁站)","formatted_address":"中国 北京市 东城区 2号线","location":{"lat":39.904983,"lng":116.427287},"place_id":"a-BV10006813"}
	]
}
* */
data class PlaceResponse(val status:String , val places:List<Place>)

data class Place(val name:String, val location:Location,@SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat:String)