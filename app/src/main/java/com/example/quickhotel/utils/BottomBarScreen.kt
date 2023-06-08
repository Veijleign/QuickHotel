package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class BottomBarScreen( // representation of different screens
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Главная",
        icon = R.drawable.main_icon
    )

    object Key: BottomBarScreen(
        route = "key",
        title = "Ключ",
        icon = R.drawable.key_icon
    )

    object Chat: BottomBarScreen(
        route = "chat",
        title = "Чат",
        icon = R.drawable.chat_icon
    )
}
