package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.ServiceCard
//import com.example.quickhotel.navigation.MainScreenNavigationGraph

/*
@Composable
fun ServicesList(
    navController: NavHostController = rememberNavController()
) {

    val mainServicesList: List<ServiceCard> = listOf(
        ServiceCard.HotelInformation,
        ServiceCard.RoomsInformation,
        ServiceCard.SightsInformation,
        ServiceCard.RestaurantsAndBarsInformation,
        ServiceCard.FitnessInformation,
        ServiceCard.MoreServicesInformation,
        ServiceCard.RoomControlInformation
    )
    // CORRECT TEST
    // здесь отрисовывается каждый из элементов главного экрана с сервисами (карточки)
    //MainScreenNavigationGraph(navController = navController)

    */
/*LazyColumn(

    ) {
        itemsIndexed(
            mainServicesList
        ) { _, item ->
            ServiceCard(item, navController)
            //MainScreenNavigationGraph(navController = navController)
        }
    }*//*

}
*/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ServiceCard1(
    item: ServiceCard,
    navController: NavHostController
) {
    Log.d("TestRequest", "Inside home screen")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(10.dp),
        onClick = {
            navController.navigate(item.route)
        }
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                alpha = 0.85f
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(3.dp),
                fontSize = 26.sp
            )
        }
    }
}