package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass

@Composable
fun KeyScreen() {
    Log.d("${LogClass.QHApp}", "Inside KeyScreen")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = R.drawable.bluetooth_icon),
                contentDescription = "Bluetooth Icon"
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = stringResource(R.string.mobile_key_text),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
        }
    }
}
