package com.example.quickhotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickhotel.screens.ChatScreen
import com.example.quickhotel.screens.KeyScreen
import com.example.quickhotel.screens.homeScreens.BottomBarScreen
import com.example.quickhotel.screens.homeScreens.MainScreenServices

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = MainScreenGraph.SERVICES_ROOT
    ) {// тут куда мы можем идти
        hotelServicesNavGraph(navController = navController)
        composable(route = BottomBarScreen.Key.route) {
            KeyScreen()
        }
        composable(route = BottomBarScreen.Chat.route) {
            ChatScreen()
        }
    }
}





