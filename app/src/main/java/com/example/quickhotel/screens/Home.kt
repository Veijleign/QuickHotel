package com.example.quickhotel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.NavHostHomeScreens
import com.example.quickhotel.R
import com.example.quickhotel.ServiceCard
import com.example.quickhotel.ui.theme.Purple500

@Composable
fun HomeScreen() {


    ServicesList()

}

@Composable
fun ServicesList() {

    val navController = rememberNavController()

    val mainServicesList: List<ServiceCard> = listOf(
        ServiceCard.HotelInformation,
        ServiceCard.SightsInformation,
        ServiceCard.RestaurantsAndBarsInformation,
        ServiceCard.FitnessInformation,
        ServiceCard.ServiceInformation,
        ServiceCard.AdditionalServiceInformation,
        ServiceCard.RoomControlInformation
    )

    LazyColumn(

    ) {
        itemsIndexed(
            mainServicesList
        ) { _, item ->
            ServiceCard(item, navController)
            //NavHostHomeScreens(navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ServiceCard(
    item: ServiceCard,
    navController: NavHostController
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(10.dp),
        onClick = {
            navController.navigate(item.route)
/*            {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }*/
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