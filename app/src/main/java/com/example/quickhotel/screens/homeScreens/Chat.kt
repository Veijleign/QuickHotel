package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.quickhotel.utils.LogClass

@Composable
fun ChatScreen() {
    Log.d("${LogClass.QHApp}", "Inside ChatScreen")
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        Text(
            text = "Chat",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}