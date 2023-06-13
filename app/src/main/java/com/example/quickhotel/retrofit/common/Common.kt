package com.example.quickhotel.retrofit.common

import com.example.quickhotel.retrofit.MainApi
import com.example.quickhotel.retrofit.RetrofitClient1
import com.example.quickhotel.retrofit.RetrofitClient2
import com.example.quickhotel.retrofit.RetrofitClient3

object Common {
    private val BASE_URL = "https://dummyjson.com/"
    private val BASE_WEATHER_URL = "https://api.open-meteo.com/"
    private val BASE_SIGHTS_URL = "https://api.opentripmap.com/"
    val retrofitServiceAuth: MainApi
        get() = RetrofitClient1.getClient(BASE_URL).create(MainApi::class.java)

    val retrofitServiceWeather: MainApi
        get() = RetrofitClient2.getClient(BASE_WEATHER_URL).create(MainApi::class.java)

    val retrofitServiceSights: MainApi
        get() = RetrofitClient3.getClient(BASE_SIGHTS_URL).create(MainApi::class.java)
}