package com.example.quickhotel.screens.loginScreens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass

@Composable
fun ForgotPasswordScreen(
    name: String,
    onGoBackClick: () -> Unit
) {
    Log.d("${LogClass.QHApp}", "Inside ForgotScreen")
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
            Text(
                text = stringResource(R.string.forgot_password),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            OutlinedButton(
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp),
                onClick = {
                    onGoBackClick()
                },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(40),
                //can be repalced to this
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Назад",
                    color = Color.White
                )
            }
        }
    }
}