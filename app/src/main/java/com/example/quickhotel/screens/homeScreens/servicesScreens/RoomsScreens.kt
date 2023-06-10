package com.example.quickhotel.screens.homeScreens.servicesScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.Rooms
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoomsScreenContent(
    name: String
) {
    Log.d("${LogClass.QHApp}", "Inside RoomsScreen")

    val mainServicesList: List<Rooms> = listOf(
        Rooms.StandardRoomTwoBeds,
        Rooms.StandardRoomWideBed,
        Rooms.HigherComfortRoom,
        Rooms.FamilyRoom,
        Rooms.BusinessRoom,
        Rooms.HalfLuxRoom,
        Rooms.LuxRoom,
        Rooms.ApartmentsRoom
    )

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    var currentBottomSheetPhoto = remember {
        mutableStateOf(R.drawable.app_logo_black)
    }
    var currentBottomSheetDescription = remember {
        mutableStateOf(R.string.room_sheet_description)
    }
    var currentBottomSheetDescriptionRoomSize = remember {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetRoomInformation(
                currentBottomSheetDescription.value,
                currentBottomSheetPhoto.value,
                currentBottomSheetDescriptionRoomSize.value
            )
        },
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetPeekHeight = 0.dp
    ) {
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
                        coroutineScope.launch {
                            currentBottomSheetPhoto.value = card.image
                            currentBottomSheetDescription.value = card.description
                            currentBottomSheetDescriptionRoomSize.value = card.room_size
                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            } else {
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                        }
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
}

@Composable
fun BottomSheetRoomInformation(
    // need to send link to photo here
    roomDescription: Int,
    roomPhoto: Int,
    roomSize: String
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black)
    ) {
        // WARNING CRINGECODE BEGINS
        Spacer(modifier = Modifier.size(2.dp))
        Row(
            modifier = Modifier
                .height(5.dp)
                .background(color = Color.Black)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Card(
                shape = RoundedCornerShape(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .width(70.dp)
                        .background(Color.LightGray)
                ) {
                    Text(text = "0", color = Color.LightGray)
                }
            }
        }
        // WARNING CRINGECODE ENDS
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Black)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(2.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = roomPhoto),
                    contentDescription = "Room logo"
                )
                Spacer(modifier = Modifier.size(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Log.d("${LogClass.QHApp}", "RoomDescription: $roomDescription")

                    Text(text = stringResource(roomDescription))
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(

                    ) {
                        Text(text = "Площадь комнаты: ", fontWeight = FontWeight.Bold)
                        Text(text = "$roomSize.")
                    }
                }
            }
        }
    }
}