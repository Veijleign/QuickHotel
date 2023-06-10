package com.example.quickhotel.screens.homeScreens.servicesScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R
import com.example.quickhotel.utils.AdditionalServices
import com.example.quickhotel.utils.LogClass
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoreServicesScreenContent(
    name: String
) {
    Log.d("${LogClass.QHApp}", "Inside MoreServicesScreen")

    val mainServicesList: List<AdditionalServices> = listOf(
        AdditionalServices.RoomMakeup,
        AdditionalServices.LaundryService,
        AdditionalServices.MoreTowels,
        AdditionalServices.LuggageService
    )

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val coroutineScope = rememberCoroutineScope()

    var currentBottomSheetMoreServicesDescription = remember {
        mutableStateOf(R.string.additional_services_sheet_description)
    }
    var currentBottomSheetMoreServicesPhoto = remember {
        mutableStateOf(R.drawable.app_logo_black)
    }

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            BottomSheetRestaurantInformation(
                currentBottomSheetMoreServicesDescription.value,
                currentBottomSheetMoreServicesPhoto.value
            )
        },
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetPeekHeight = 0.dp,
        drawerScrimColor = Color.Black
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
                            currentBottomSheetMoreServicesPhoto.value = card.image
                            currentBottomSheetMoreServicesDescription.value = card.description
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