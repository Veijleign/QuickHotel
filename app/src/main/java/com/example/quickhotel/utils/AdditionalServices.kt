package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class AdditionalServices(
    val route: String,
    val title: String,
    val image: Int
) {
    object RoomMakeup : AdditionalServices(
        route = "ROOM_MAKEUP",
        title = "Уборка комнаты",
        image = R.drawable.room_makeup
    )

    object LaundryService : AdditionalServices(
        route = "LAUNDRY_SERVICE",
        title = "Уборка комнаты",
        image = R.drawable.laundry_service
    )

    object MoreTowels : AdditionalServices(
        route = "MORE_TOWELS",
        title = "Дополнительные принадлежности",
        image = R.drawable.more_towels
    )

    object LuggageService : AdditionalServices(
        route = "LUGGAGE_SERVICE",
        title = "Доставка багажа",
        image = R.drawable.luggage_service
    )
}