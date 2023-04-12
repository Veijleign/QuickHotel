package com.example.quickhotel.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R

@Composable
fun KeyScreen() {
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
            OutlinedButton(
                onClick = {

                },
                border = BorderStroke(1.dp, Color.DarkGray),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}
