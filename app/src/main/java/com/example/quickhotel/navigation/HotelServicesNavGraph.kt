package com.example.quickhotel.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.screens.homeScreens.BottomBarScreen
import com.example.quickhotel.screens.homeScreens.MainScreenServices
import com.example.quickhotel.screens.homeScreens.servicesScreens.*

fun NavGraphBuilder.hotelServicesNavGraph(navController: NavHostController) {
    // не удалять!! Еслии используем рутойвый, в котором должны быть ещё переходы - используем Builder
    // классы испольузем для запуска экранов, объекты чтобы передать путь и сделать его хостом
    navigation(
        route = MainScreenGraph.SERVICES_ROOT, // тут переходит правильно!!!!
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            // отвечает за отрисовку всех элементов главного экрана
            MainScreenServices( // Works Correctly
                name = BottomBarScreen.Home.route,
                onRoomsClick = { routeTo ->
                    //navController.navigate(HotelServicesScreen.Rooms.route)
                    navController.navigate(routeTo)
                },
/*                onSightsClick = {
                    navController.navigate(HotelServicesScreen.Sights.route)
                },
                onRestaurantsClick = {
                    navController.navigate(HotelServicesScreen.Restaurants.route)
                },
                onFitnessClick = {
                    navController.navigate(HotelServicesScreen.Fitness.route)
                },
                onMoreServicesClick = {
                    navController.navigate(HotelServicesScreen.MoreServices.route)
                },
                onRoomControlClick = {
                    navController.navigate(HotelServicesScreen.RoomControl.route)
                }*/
            )
        }
        composable(route = HotelServicesScreen.AboutHotel.route) {
            AboutHotelScreen(name = HotelServicesScreen.AboutHotel.route)
        }
        composable(route = HotelServicesScreen.Rooms.route) {
            RoomsScreenContent(name = HotelServicesScreen.Rooms.route)
        }
        composable(route = HotelServicesScreen.Sights.route) {
            SightsScreenContent(name = HotelServicesScreen.Sights.route)
        }
        composable(route = HotelServicesScreen.Restaurants.route) {
            RestaurantsScreenContent(name = HotelServicesScreen.Restaurants.route)
        }
        composable(route = HotelServicesScreen.Fitness.route) {
            FitnessScreenContent(name = HotelServicesScreen.Fitness.route)
        }
        composable(route = HotelServicesScreen.MoreServices.route) {
            MoreServicesScreenContent(name = HotelServicesScreen.MoreServices.route)
        }
        composable(route = HotelServicesScreen.RoomControl.route) {
            RoomControlScreenContent(name = HotelServicesScreen.RoomControl.route)
        }
    }
}

sealed class RoomsScreen(val route: String) {
    object Overview : RoomsScreen(route = "ROOMS_OVERVIEW")
}

sealed class HotelServicesScreen(val route: String) {
    object ServicesList : HotelServicesScreen(route = "SERVICES_LIST")
    object AboutHotel : HotelServicesScreen(route = "ABOUT_HOTEL")
    object Rooms : HotelServicesScreen(route = "ROOMS")
    object Sights : HotelServicesScreen(route = "SIGHTS")
    object Restaurants : HotelServicesScreen(route = "RESTAURANTS")
    object Fitness : HotelServicesScreen(route = "FITNESS")
    object MoreServices : HotelServicesScreen(route = "ADDITIONAL_SERVICES")
    object RoomControl : HotelServicesScreen(route = "ROOM_CONTROL")
}