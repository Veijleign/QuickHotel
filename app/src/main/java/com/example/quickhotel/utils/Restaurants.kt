package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Restaurants(
    val route: String,
    val title: String,
    val image: Int,
    val description: Int
) {
    object AsianKitchen : Restaurants(
        route = "ASIAN_KITCHEN",
        title = "Азиатская кухня",
        image = R.drawable.kitchen_asian,
        description = R.string.asian_kitchen_description
    )

    object ItalianKitchen : Restaurants(
        route = "ITALIAN_KITCHEN",
        title = "Итальянская кухня",
        image = R.drawable.kitchen_italian,
        description = R.string.italian_kitchen_description
    )

    object Lounge : Restaurants(
        route = "LOUNGE",
        title = "Лаунж",
        image = R.drawable.lounge_zone,
        description = R.string.lounge_description
    )

    object OrderFoodToRoom : Restaurants(
        route = "ASIAN_KITCHEN",
        title = "Азиатская кухня",
        image = R.drawable.order_to_room,
        description = R.string.order_food_description
    )
}