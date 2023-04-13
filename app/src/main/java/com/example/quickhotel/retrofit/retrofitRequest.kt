package com.example.quickhotel.retrofit

import android.util.Log
import com.example.quickhotel.retrofit.common.Common
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun retrofitRequest(
    login: String,
    password: String
) {
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
    CoroutineScope(Dispatchers.IO).launch {
        try {
            Log.d("TestRequest", "Sent data: Login: $login, password: $password")
            user = Common.retrofitService.authFun(
                AuthRequest(login, password)
            )
            Log.d("TestRequest", "Received data: $user")
        } catch (e: java.lang.Exception) {
            Log.d("TestRequest", "Exception: $e" )
        }
    }

}