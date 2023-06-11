package com.example.quickhotel.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.quickhotel.screens.homeScreens.servicesScreens.SightsScreenContent
import com.example.quickhotel.screens.homeScreens.servicesScreens.sightsInsideScreens.ExcursionsScreen
import com.example.quickhotel.screens.homeScreens.servicesScreens.sightsInsideScreens.InterestingSightsScreen
import com.example.quickhotel.screens.homeScreens.servicesScreens.sightsInsideScreens.VehicleRentalScreenContent
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.ServiceCard
import com.example.quickhotel.utils.Sights

fun NavGraphBuilder.sightsNavGraph(navController: NavHostController) {

    navigation(
        route = MainScreenGraph.SIGHTS,
        startDestination = ServiceCard.Sights.route
    ) {
        composable(route = ServiceCard.Sights.route) {// здесь запускаем тот, который сейчас отображается
            SightsScreenContent(
                name = ServiceCard.Sights.route,
                onSightsServiceClick = { routeTo ->
                    navController.navigate(routeTo)
                    Log.d("${LogClass.QHApp}", "CLICK NAVIGATE TO: $routeTo")
                }
            )
        }
    }
}

@Composable
fun SightsNavHostGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = MainScreenGraph.SERVICES_ROOT,
        startDestination = MainScreenGraph.SIGHTS
    ) {
        sightsNavGraph(navController = navController)
        composable(route = Sights.Excursions.route) {
            ExcursionsScreen()
        }
        composable(route = Sights.VehicleRental.route) {// route to rental
            VehicleRentalScreenContent()
        }
        composable(route = Sights.InterestingSights.route) {// route to sights
            InterestingSightsScreen()
        }
    }
}

object SightsNavGraph {
    const val SIGHTS_ROOT = "sights_root"
}

/*sealed class SightsScreen(val route: String) {
    object Excursions: SightsScreen(route = "EXCURSIONS")
    object VehicleRental: SightsScreen(route = "VEHICLE_RENTAL")
    object InterestingSights: SightsScreen(route = "INTERESTING_SIGHTS")
}*/



