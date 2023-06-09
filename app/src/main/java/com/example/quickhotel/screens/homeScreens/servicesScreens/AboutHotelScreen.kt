package com.example.quickhotel.screens.homeScreens.servicesScreens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass

@Composable
fun AboutHotelScreen(
    name: String
) {
    Log.d("${LogClass.QHApp}", "Inside AboutHotelScreen")
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .background(Color.Black)
                .padding(10.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(180.dp)
                    .background(Color.Black),
                painter = painterResource(id = R.drawable.hotel_info_img),
                contentDescription = "App logo"
            )

        }

        Text(text = "Об отеле", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Column(

        ) {
            //Row
            Text(
                text = "Отель Москва является лучшим в своём качестве, предоставляет своим клиентам незабываемый опыт и оставляет только позитивные эмоции"
            )
            Row(
                modifier = Modifier.clickable {
                    val longitude = "55.789523"
                    val latitude = "37.5940508"
                    val coordinates: String =
                        "geo:" + longitude + "," +latitude + "?z=zoom"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(coordinates))
                    ContextCompat.startActivity(context, intent, null)
                }
            ) {
                Text(text = "Адрес: г. Москва, Ул. Московская 25.")
            }
            Row(
                modifier = Modifier.clickable {
                    val email = "mailto:" + "hotelLuxMoscow@eample.com"
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(email))
                    ContextCompat.startActivity(context, intent, null)
                }
            ) {
                Text(text = "Контактные данные: hotelLuxMoscow@example.ru")
            }
            Row(
                modifier = Modifier.clickable {
                    val phoneNumber = "tel:" + "+71234567890"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                    ContextCompat.startActivity(context, intent, null)
                }
            ) {
                Text(text = "+7 (123) 456-78-90")
            }
        }

    }
}