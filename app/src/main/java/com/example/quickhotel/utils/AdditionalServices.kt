package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class AdditionalServices(
    val route: String,
    val title: String,
    val image: Int,
    val description: Int
) {
    object RoomMakeup : AdditionalServices(
        route = "ROOM_MAKEUP",
        title = "Уборка комнаты",
        image = R.drawable.room_makeup,
        description = R.string.room_makeup_sheet_description
    )

    object LaundryService : AdditionalServices(
        route = "LAUNDRY_SERVICE",
        title = "Услуги прачечной",
        image = R.drawable.laundry_service,
        description = R.string.laundry_sheet_description
    )

    object MoreTowels : AdditionalServices(
        route = "MORE_TOWELS",
        title = "Дополнительные принадлежности",
        image = R.drawable.more_towels,
        description = R.string.more_towels_sheet_description
    )

    object LuggageService : AdditionalServices(
        route = "LUGGAGE_SERVICE",
        title = "Доставка багажа",
        image = R.drawable.luggage_service,
        description = R.string.luggage_delivery_sheet_description
    )
}