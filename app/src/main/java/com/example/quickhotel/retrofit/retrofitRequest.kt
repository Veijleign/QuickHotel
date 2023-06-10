package com.example.quickhotel.retrofit

import android.util.Log
import com.example.quickhotel.retrofit.common.Common
import com.example.quickhotel.utils.LogClass
import kotlinx.coroutines.*
import retrofit2.Response

suspend fun retrofitAuthRequest(
    login: String,
    password: String
) : Boolean {

    var access: Boolean = false

    withContext(Dispatchers.IO) {
        val response = Common.retrofitService.authFun(
            AuthRequest(login, password)
        )

        Log.d("${LogClass.QHApp}", "AUTH: ${response.body()}")
        access = response.body() != null
    }
    return access
}

suspend fun retrofitWeatherRequest(

) : String {

    var temperature = ""

    withContext(Dispatchers.IO) {
        val response = Common.retrofitServiceWeather.getWeather()

        Log.d("${LogClass.QHApp}", "WEATHER: ${response.body()}")

        temperature = response.body()?.current_weather?.temperature.toString()
    }
    return temperature
}