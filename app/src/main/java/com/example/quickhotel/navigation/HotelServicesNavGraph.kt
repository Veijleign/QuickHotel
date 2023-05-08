package com.example.quickhotel.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.ServiceCard
import com.example.quickhotel.utils.BottomBarScreen
import com.example.quickhotel.screens.homeScreens.MainScreenServices
import com.example.quickhotel.screens.homeScreens.servicesScreens.*

fun NavGraphBuilder.hotelServicesNavGraph(navController: NavHostController) {
    // не удалять!! Если используем рутойвый, в котором должны быть ещё переходы - используем Builder
    // классы испольузем для запуска экранов, объекты чтобы передать путь и сделать его хостом
    navigation(
        route = MainScreenGraph.SERVICES_ROOT, // тут переходит правильно!!!!
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            // отвечает за отрисовку всех элементов главного экрана
            MainScreenServices( // Works Correctly
                name = BottomBarScreen.Home.route,
                onServiceCardClick = { routeTo ->
                    //navController.navigate(HotelServicesScreen.Rooms.route)
                    navController.navigate(routeTo)
                }
            )
        }
        composable(route = ServiceCard.AboutHotel.route) {
            AboutHotelScreen(name = ServiceCard.AboutHotel.route)
        }
        composable(route = ServiceCard.Rooms.route) {
            RoomsScreenContent(name = ServiceCard.Rooms.route)
        }
        composable(route = ServiceCard.Sights.route) {
            SightsScreenContent(name = ServiceCard.Sights.route)
        }
        composable(route = ServiceCard.Restaurants.route) {
            RestaurantsScreenContent(name = ServiceCard.Restaurants.route)
        }
        composable(route = ServiceCard.Fitness.route) {
            FitnessScreenContent(name = ServiceCard.Fitness.route)
        }
        composable(route = ServiceCard.MoreServices.route) {
            MoreServicesScreenContent(name = ServiceCard.MoreServices.route)
        }
        composable(route = ServiceCard.RoomControl.route) {
            RoomControlScreenContent(name = ServiceCard.RoomControl.route)
        }
    }
}

/*
// use inside card
sealed class RoomsScreen(val route: String) {
    object Overview : RoomsScreen(route = "ROOMS_OVERVIEW")
}*/

/*
sealed class ServiceCard(val route: String) {
    object ServicesList : ServiceCard(route = "SERVICES_LIST")
    object AboutHotel : ServiceCard(route = "ABOUT_HOTEL")
    object Rooms : ServiceCard(route = "ROOMS")
    object Sights : ServiceCard(route = "SIGHTS")
    object Restaurants : ServiceCard(route = "RESTAURANTS")
    object Fitness : ServiceCard(route = "FITNESS")
    object MoreServices : ServiceCard(route = "ADDITIONAL_SERVICES")
    object RoomControl : ServiceCard(route = "ROOM_CONTROL")
}*/
