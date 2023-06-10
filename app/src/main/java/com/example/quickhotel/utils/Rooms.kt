package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Rooms(
    val route: String,
    val title: String,
    val image: Int,
    val description: Int,
    val room_size: String
) {
    object StandardRoomTwoBeds : Rooms(
        route = "Standard_Room_Two_Beds",
        title = "Стандарт (две кровати)",
        image = R.drawable.room_standart_2_beds,
        description = R.string.standard_room_two_beds,
        room_size = "30 м2"
    )

    object StandardRoomWideBed : Rooms(
        route = "Standard_Room_Wide_Bed",
        title = "Стандарт (широкая кровать)",
        image = R.drawable.room_standart_wide_bed,
        description = R.string.standard_room_one_bed,
        room_size = "35 м2"
    )

    object HigherComfortRoom : Rooms(
        route = "Higher_Comfort_Room",
        title = "Номер повышенной комфортности",
        image = R.drawable.room_higher_comfort,
        description = R.string.better_comfort_room,
        room_size = "50 м2"
    )

    object FamilyRoom : Rooms(
        route = "Family_Room",
        title = "Семейный",
        image = R.drawable.room_family,
        description = R.string.family_room,
        room_size = "70 м2"
    )

    object BusinessRoom : Rooms(
        route = "Business_Room",
        title = "Бизнес",
        image = R.drawable.room_business,
        description = R.string.business_room,
        room_size = "50 м2"
    )

    object HalfLuxRoom : Rooms(
        route = "Half_Lux_Room",
        title = "Полулюкс",
        image = R.drawable.room_half_luxary,
        description = R.string.half_luxury_room,
        room_size = "80 м2"
    )

    object LuxRoom : Rooms(
        route = "Lux_Room",
        title = "Люкс",
        image = R.drawable.room_luxary,
        description = R.string.luxury_room,
        room_size = "100 м2"
    )

    object ApartmentsRoom : Rooms(
        route = "Apartments_Room",
        title = "Апартаменты",
        image = R.drawable.room_apartments,
        description = R.string.apartments_room,
        room_size = "300 м2"
    )

}