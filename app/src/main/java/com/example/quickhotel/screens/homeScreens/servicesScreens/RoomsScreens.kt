package com.example.quickhotel.screens.homeScreens.servicesScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun RoomsScreenContent(
    name: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Разместить комнаты",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}