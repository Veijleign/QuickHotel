package com.example.quickhotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.ServiceCard
import com.example.quickhotel.screens.homeScreens.BottomBarScreen


@Composable
fun MainScreenNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = MainScreenGraph.SERVICES_ROOT,
        startDestination = BottomBarScreen.Home.route
    ) { // тут куда мы можем идти
        hotelServicesNavGraph(navController = navController)
        // тест -> CORRCT!!!
        composable(route = ServiceCard.RoomsInformation.route) { // здесь запускается экран,
            // путь которому мы дали в navigate

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