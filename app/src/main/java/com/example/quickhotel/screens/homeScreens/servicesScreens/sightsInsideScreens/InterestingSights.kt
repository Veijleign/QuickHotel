package com.example.quickhotel.screens.homeScreens.servicesScreens.sightsInsideScreens

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.quickhotel.retrofit.retrofitSightsRequest
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.SightsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun InterestingSightsScreen(

) {
    val sights = remember {
        mutableStateOf(
            SightsModel(
                features = listOf<SightsModel.Feature>(
                    SightsModel.Feature(
                        SightsModel.Feature.Geometry(
                            listOf(0.0, 0.0),
                            ""
                        ),
                        "",
                        SightsModel.Feature.Properties(
                            0.0,
                            "",
                            "",
                            "",
                            0,
                            "",
                            ""
                        ),
                        ""
                    )
                ),
                ""
            )
        )
    }
    getSights(sights)
    //OneItemSight(name = "1", longitude = "", latitude = "")
    CoroutineScope(Dispatchers.IO).launch {
        delay(3000)
        Log.d("${LogClass.QHApp}", "SIGHTS DATA: ${sights}")
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(
            sights.value.features
        ) { index, item ->
            OneItemSight(
                name = item.properties.name,
                coordinates = item.geometry.coordinates
            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OneItemSight(
    name: String,
    coordinates: List<Double>
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(5.dp),
        backgroundColor = Color.Black,
        onClick = {
            val longitude = coordinates[1]
            val latitude = coordinates[0]
            val longAndLat: String =
                "geo:" + longitude + "," +latitude + "?z=zoom"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(longAndLat))
            ContextCompat.startActivity(context, intent, null)
        }
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                maxLines = 1
            )
        }
    }
}


fun getSights(
    sights: MutableState<SightsModel>
) {

    CoroutineScope(Dispatchers.IO).launch {
        sights.value = retrofitSightsRequest()
    }
    //return sights
}

@Composable
@Preview
fun TestPreview() {
    InterestingSightsScreen()
}