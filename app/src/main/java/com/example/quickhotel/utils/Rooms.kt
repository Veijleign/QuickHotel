package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Rooms(
    val route: String,
    val title: String,
    val image: Int
) {
    object StandardRoomTwoBeds : Rooms(
        route = "Standard_Room_Two_Beds",
        title = "Стандарт (две кровати)",
        image = R.drawable.room_standart_2_beds
    )

    object StandardRoomWideBed : Rooms(
        route = "Standard_Room_Wide_Bed",
        title = "Стандарт (широкая кровать)",
        image = R.drawable.room_standart_wide_bed
    )

    object HigherComfortRoom : Rooms(
        route = "Higher_Comfort_Room",
        title = "Номер повышенной комфортности",
        image = R.drawable.room_higher_comfort
    )

    object FamilyRoom : Rooms(
        route = "Family_Room",
        title = "Семейный",
        image = R.drawable.room_family
    )

    object BusinessRoom : Rooms(
        route = "Business_Room",
        title = "Бизнес",
        image = R.drawable.room_business
    )

    object HalfLuxRoom : Rooms(
        route = "Half_Lux_Room",
        title = "Полулюкс",
        image = R.drawable.room_half_luxary
    )

    object LuxRoom : Rooms(
        route = "Lux_Room",
        title = "Люкс",
        image = R.drawable.room_luxary
    )

    object ApartmentsRoom : Rooms(
        route = "Apartments_Room",
        title = "Апартаменты",
        image = R.drawable.room_apartments
    )

}