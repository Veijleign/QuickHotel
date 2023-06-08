package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass

@Composable
fun ChatScreen() {
    Log.d("${LogClass.QHApp}", "Inside ChatScreen")

    val inputData = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Bottom
    ) {
        Surface(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ) {
            TextField(
                value = inputData.value,
                onValueChange = {
                    inputData.value = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.DarkGray,
                    unfocusedBorderColor = Color.Black,
                    textColor = Color.White
                ),
                placeholder = {
                    Text(
                        text = "Введите сообщение",
                        color = Color.DarkGray
                    )
                },
                leadingIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.attach_file),
                            "Attach file",
                            modifier = Modifier.size(29.dp),
                            tint = Color.DarkGray
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.send_icon),
                            "Send message",
                            modifier = Modifier.size(29.dp),
                            tint = Color.DarkGray
                        )
                    }
                }
            )
        }
    }
}