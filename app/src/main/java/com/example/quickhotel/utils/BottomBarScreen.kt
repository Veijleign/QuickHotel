package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class BottomBarScreen( // representation of different screens
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.main_icon
    )

    object Key: BottomBarScreen(
        route = "key",
        title = "Key",
        icon = R.drawable.key_icon
    )

    object Chat: BottomBarScreen(
        route = "chat",
        title = "Chat",
        icon = R.drawable.chat_icon
    )
}
