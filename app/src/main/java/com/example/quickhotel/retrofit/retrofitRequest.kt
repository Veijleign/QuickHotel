package com.example.quickhotel.retrofit

import android.util.Log
import com.example.quickhotel.retrofit.common.Common
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.SightsModel
import com.example.quickhotel.utils.WeatherModel
import kotlinx.coroutines.*
import retrofit2.Response
import java.lang.Exception

suspend fun retrofitAuthRequest(
    login: String,
    password: String
): Boolean {

    var access: Boolean = false

    withContext(Dispatchers.IO) {
        val response = Common.retrofitServiceAuth.authFun(
            AuthRequest(login, password)
        )

        Log.d("${LogClass.QHApp}", "AUTH: ${response.body()}")
        access = response.body() != null
    }
    return access
}

suspend fun retrofitWeatherRequest(

): String {

    var temperature = ""

    withContext(Dispatchers.IO) {
        val response = Common.retrofitServiceWeather.getWeather()

        Log.d("${LogClass.QHApp}", "WEATHER: ${response.body()}")

        temperature = response.body()?.current_weather?.temperature.toString()
    }
    return temperature
}

suspend fun retrofitSightsRequest(

): SightsModel {

    val apiKey = "5ae2e3f221c38a28845f05b6c2dce8baf41f325b7fc220771f997d45"

    var sights =
        SightsModel(
            features = listOf<SightsModel.Feature>(
                SightsModel.Feature(
                    SightsModel.Feature.Geometry(
                        listOf(0.0, 0.0),
                        ""
                    ),
                    "",
                    SightsModel.Feature.Properties(
                        0.0,
                        "",
                        "",
                        "",
                        0,
                        "",
                        ""
                    ),
                    ""
                )
            ),
            ""
        )


    withContext(Dispatchers.IO) {

        //Log.d("${LogClass.QHApp}", "SIGHTS: $response")
        val response = Common.retrofitServiceSights.getSights(apiKey)

        try {
            sights = response.body()!!
        } catch (e: Exception) {
            Log.e("${LogClass.QHApp}", "EXCEPTION: $e")
        }

        Log.d("${LogClass.QHApp}", "SIGHTS: $sights")
    }
    return sights
}