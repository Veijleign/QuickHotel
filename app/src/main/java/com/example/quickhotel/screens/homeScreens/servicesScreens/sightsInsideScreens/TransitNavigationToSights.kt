package com.example.quickhotel.screens.homeScreens.servicesScreens.sightsInsideScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.navigation.SightsNavHostGraph

// This function is transit functions. Must be fixes, but dunno how...
@Composable
fun SightsTest(navController: NavHostController = rememberNavController()) {


    SightsNavHostGraph(navController)

}