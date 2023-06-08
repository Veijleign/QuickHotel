package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Restaurants(
    val route: String,
    val title: String,
    val image: Int
) {
    object AsianKitchen : Restaurants(
        route = "ASIAN_KITCHEN",
        title = "Азиатская кухня",
        image = R.drawable.kitchen_asian
    )

    object ItalianKitchen : Restaurants(
        route = "ITALIAN_KITCHEN",
        title = "Итальянская кухня",
        image = R.drawable.kitchen_italian
    )

    object Lounge : Restaurants(
        route = "LOUNGE",
        title = "Lounge",
        image = R.drawable.lounge_zone
    )

    object OrderFoodToRoom : Restaurants(
        route = "ASIAN_KITCHEN",
        title = "Азиатская кухня",
        image = R.drawable.order_to_room
    )
}