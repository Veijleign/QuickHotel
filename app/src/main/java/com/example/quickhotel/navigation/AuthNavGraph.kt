package com.example.quickhotel.navigation

import android.util.Log
import android.widget.Toast
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.retrofit.retrofitRequest
import com.example.quickhotel.screens.loginScreens.LoginContent
import com.example.quickhotel.screens.ScreenContent

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginContent(
                onLogInClick = { login, password -> // request for log-in

                    retrofitRequest(login, password)
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)


                },
                onForgotClick = { // change to the new screen
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
        }
        composable(route = AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) {}
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object Forgot : AuthScreen(route = "FORGOT")
}