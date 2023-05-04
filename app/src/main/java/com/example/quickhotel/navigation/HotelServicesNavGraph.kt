package com.example.quickhotel.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.screens.homeScreens.servicesScreens.RoomsScreenContent


fun NavGraphBuilder.hotelServicesNavGraph(navController: NavHostController) {
    navigation(
        route = MainScreenGraph.ROOMS, // тут переходит правильно!!!!
        startDestination = RoomsScreen.Overview.route
    ) {
        composable(route = RoomsScreen.Overview.route) {
            RoomsScreenContent(name = RoomsScreen.Overview.route)
        }
    }
}

sealed class RoomsScreen(val route: String) {
    object Overview : RoomsScreen(route = "ROOMS_OVERVIEW")
}

sealed class HotelServicesScreen(val route: String) {
    object ServicesList : HotelServicesScreen(route = "SERVICES_LIST")
    object Rooms : HotelServicesScreen(route = "ROOMS")
    object Sights : HotelServicesScreen(route = "SIGHTS")
    object Restaurants : HotelServicesScreen(route = "RESTAURANTS")
    object Fitness : HotelServicesScreen(route = "FITNESS")
    object AdditionalServices : HotelServicesScreen(route = "ADDITIONAL_SERVICES")
    object RoomControl : HotelServicesScreen(route = "ROOM_CONTROL")
}