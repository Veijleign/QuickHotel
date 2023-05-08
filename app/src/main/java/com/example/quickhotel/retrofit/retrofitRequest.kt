package com.example.quickhotel.retrofit

import android.util.Log
import com.example.quickhotel.retrofit.common.Common
import kotlinx.coroutines.*
import retrofit2.Response

@OptIn(DelicateCoroutinesApi::class)
suspend fun retrofitAuthRequest(
    login: String,
    password: String
) : Boolean {
    var user = User(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
    var access: Boolean = false

    withContext(Dispatchers.IO) {
        val response = Common.retrofitService.authFun(
            AuthRequest(login, password)
        )
        Log.d("RetrofitTest", "${response.body()}")
        access = response.body() != null
    }
    return access
}