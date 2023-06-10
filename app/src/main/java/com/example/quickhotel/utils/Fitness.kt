package com.example.quickhotel.utils

import com.example.quickhotel.R

sealed class Fitness(
    val route: String,
    val title: String,
    val image: Int,
    val description: Int
) {


    object Spa : Fitness(
        route = "SPA",
        title = "Спа",
        image = R.drawable.spa,
        description = R.string.spa_description
    )

    object FitnessService : Fitness(
        route = "FITNESS",
        title = "Фитнес",
        image = R.drawable.fitness_img,
        description = R.string.fitness_description
    )

    object Sauna : Fitness(
        route = "SAUNA",
        title = "Сауна",
        image = R.drawable.sauna,
        description = R.string.sauna_description
    )
}