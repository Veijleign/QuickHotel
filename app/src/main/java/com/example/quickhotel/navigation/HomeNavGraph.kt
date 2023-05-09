package com.example.quickhotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickhotel.screens.homeScreens.ChatScreen
import com.example.quickhotel.screens.homeScreens.KeyScreen
import com.example.quickhotel.utils.BottomBarScreen

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

object MainScreenGraph { // для обозначения новых Хостов
    const val SERVICES_ROOT = "services_root_graph"
    const val ROOMS = "rooms_graph"
    const val SIGHTS = "sights_graph"
    const val RESTAURANTS = "restaurants_graph"
    const val FITNESS = "fitness_graph"
    const val ADDITIONAL_SERVICES = "additional_services_graph"
    const val ROOM_CONTROL = "rooms_control_graph"
}