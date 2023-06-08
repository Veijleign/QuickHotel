package com.example.quickhotel.retrofit.common

import com.example.quickhotel.retrofit.MainApi
import com.example.quickhotel.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://dummyjson.com/"
    private val BASE_WEATHER_URL = "https://api.open-meteo.com/"
    val retrofitService: MainApi
        get() = RetrofitClient.getClient(BASE_URL).create(MainApi::class.java)

    val retrofitServiceWeather: MainApi
        get() = RetrofitClient.getClient(BASE_WEATHER_URL).create(MainApi::class.java)
}