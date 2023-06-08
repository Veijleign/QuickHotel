package com.example.quickhotel.retrofit

import androidx.compose.runtime.InternalComposeTracingApi
import com.example.quickhotel.utils.WeatherModel
import retrofit2.Response
import retrofit2.http.*

interface MainApi {
    @POST("auth/login")
    suspend fun authFun(@Body authRequest: AuthRequest): Response<User>

    @GET("v1/forecast?latitude=52.52&longitude=13.41&current_weather=true")
    suspend fun getWeather(): Response<WeatherModel> // REFACTOR IT!
}


