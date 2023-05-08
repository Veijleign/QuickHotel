package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.quickhotel.ServiceCard

// это одна карточка
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreenServices(
    name: String,
    onRoomsClick: (String) -> Unit
) {
    val mainServicesList: List<ServiceCard> = listOf(
        ServiceCard.AboutHotel,
        ServiceCard.Rooms,
        ServiceCard.Sights,
        ServiceCard.Restaurants,
        ServiceCard.Fitness,
        ServiceCard.MoreServices,
        ServiceCard.RoomControl
    )
    Log.d("TestRequest", "Inside home screen")
    LazyColumn(

    ) {
        itemsIndexed(
            mainServicesList
        ) {index, card ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onRoomsClick(card.route)
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
                        alpha = 0.85f
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
        /*item {
            Spacer(modifier = Modifier.size(7.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onRoomsClick()
                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = item2.image),
                        contentDescription = item2.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.85f
                    )
                    Text(
                        text = item2.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }*/
/*        item {
            Spacer(modifier = Modifier.size(7.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onRestaurantsClick()
                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = item2.image),
                        contentDescription = item2.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.85f
                    )
                    Text(
                        text = item2.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.size(7.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onFitnessClick()
                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = item2.image),
                        contentDescription = item2.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.85f
                    )
                    Text(
                        text = item2.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.size(7.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onMoreServicesClick()
                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = item2.image),
                        contentDescription = item2.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.85f
                    )
                    Text(
                        text = item2.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.size(7.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    onRoomControlClick()
                }
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = item2.image),
                        contentDescription = item2.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        alpha = 0.85f
                    )
                    Text(
                        text = item2.title,
                        modifier = Modifier
                            .padding(3.dp),
                        fontSize = 26.sp
                    )
                }
            }
        }*/
    }
}