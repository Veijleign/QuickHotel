package com.example.quickhotel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.screens.HomeScreen
import com.example.quickhotel.screens.ProfileScreen
import com.example.quickhotel.screens.SettingsScreen
import com.example.quickhotel.screens.homeScreens.AboutHotelScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Key.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Chat.route) {
            SettingsScreen()
        }
/*        composable(route = "AboutHotelScreen") {
            AboutHotelScreen()
        }*/
    }
}

@Composable
fun NavHostHomeScreens(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = ServiceCard.HotelInformation.route) {
            AboutHotelScreen()
        }
    }
}