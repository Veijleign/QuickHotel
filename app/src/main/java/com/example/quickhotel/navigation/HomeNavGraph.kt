package com.example.quickhotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quickhotel.screens.ChatScreen
import com.example.quickhotel.screens.KeyScreen
import com.example.quickhotel.screens.homeScreens.BottomBarScreen
import com.example.quickhotel.screens.homeScreens.RoomsCard

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {// тут куда мы можем идти
        composable(route = BottomBarScreen.Home.route) {
            // отвечает за отрисовку всех элементов главного экрана
            RoomsCard(
                name = BottomBarScreen.Home.route,
                onRoomsClick = {
                    navController.navigate(MainScreenGraph.ROOMS)
                }
            )
            // ЗДЕСЬ ДОБАВИТЬ ДРУГИЕ ЭЛЕМЕНТЫ!!!!!!
        }
        composable(route = BottomBarScreen.Key.route) {
            KeyScreen()
        }
        composable(route = BottomBarScreen.Chat.route) {
            ChatScreen()
        }
        hotelServicesNavGraph(navController = navController)
    }
}





