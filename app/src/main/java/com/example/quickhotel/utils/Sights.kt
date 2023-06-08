package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Sights(
    val route: String,
    val title: String,
    val image: Int
) {
    object Excursions : Sights(
        route = "EXCURSIONS",
        title = "Экскурсии",
        image = R.drawable.excursions
    )

    object VehicleRental : Sights(
        route = "BEHICLE_RENTAL",
        title = "Прокат транспорта",
        image = R.drawable.vehicle_rental
    )

    object InterestingSights : Sights(
        route = "INTERESTING_SIGHTS",
        title = "Интересные места",
        image = R.drawable.sights_img
    )
}