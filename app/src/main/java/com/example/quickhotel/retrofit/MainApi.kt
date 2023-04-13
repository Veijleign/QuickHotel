package com.example.quickhotel.retrofit

import androidx.compose.runtime.InternalComposeTracingApi
import retrofit2.http.*

interface MainApi {
    @POST("auth/login")
    suspend fun authFun(@Body authRequest: AuthRequest): User
}