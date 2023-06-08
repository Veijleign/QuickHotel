package com.example.quickhotel.screens.homeScreens.servicesScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.Restaurants
import com.example.quickhotel.utils.Rooms

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RestaurantsScreenContent(
    name: String
) {
    Log.d("${LogClass.QHApp}", "Inside RestaurantsScreen")

    val mainServicesList: List<Restaurants> = listOf(
        Restaurants.AsianKitchen,
        Restaurants.ItalianKitchen,
        Restaurants.Lounge,
        Restaurants.OrderFoodToRoom
    )

    LazyColumn(

    ) {
        itemsIndexed(
            mainServicesList
        ) { index, card ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {

                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = card.image),
                        contentDescription = card.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.8f
                    )
                    Text(
                        text = card.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }
    }
}