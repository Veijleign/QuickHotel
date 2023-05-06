package com.example.quickhotel.screens.homeScreens.servicesScreens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun RoomControlScreenContent(
    name: String
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(100) {
            Text(
                text = name,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )

        }

    }
}