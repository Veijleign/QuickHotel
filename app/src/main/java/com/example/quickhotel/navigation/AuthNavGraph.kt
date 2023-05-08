package com.example.quickhotel.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.retrofit.retrofitAuthRequest
import com.example.quickhotel.screens.ScreenContent
import com.example.quickhotel.screens.loginScreens.LoginContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
//что отображажет и какие действия доступны
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginContent(
                onLogInClick = { login, password ->
                    /*runBlocking {
                        retrofitAuthRequest(login, password)
                    }*/

                    CoroutineScope(Dispatchers.Main).launch {
                        /*GlobalScope.async(Dispatchers.IO) {
                            retrofitAuthRequest(login, password)
                        }.await()*/
                        var access = false
                        val job = launch {
                            access = retrofitAuthRequest(login, password)
                            Log.d("RetrofitTest", "Inside job: $access")
                        }
                        job.join()
                        if (access) { // add Toast
                            navController.popBackStack() // add screens to backstack
                            navController.navigate(Graph.HOME)
                        } else {
                            Log.d("RetrofitTest", "Inside job: NO")
                        }
                    }
                },
                onForgotClick = { // change to the new screen
                    navController.navigate(AuthScreen.Forgot.route)
                },
                onLogInAsGuest = {
                    navController.navigate(Graph.HOME)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) { }
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object Forgot : AuthScreen(route = "FORGOT")
}