package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Fitness(
    val route: String,
    val title: String,
    val image: Int
) {


    object Spa : Fitness(
        route = "SPA",
        title = "Спа",
        image = R.drawable.spa
    )

    object FitnessService : Fitness(
        route = "FITNESS",
        title = "Фитнес",
        image = R.drawable.fitness_img
    )

    object Sauna : Fitness(
        route = "SAUNA",
        title = "Сауна",
        image = R.drawable.sauna
    )
}