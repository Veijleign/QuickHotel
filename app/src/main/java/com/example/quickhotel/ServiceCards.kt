package com.example.quickhotel

sealed class ServiceCard(
    val route: String,
    val title: String,
    val image: Int
) {

    object HotelInformation : ServiceCard(
        route = "ABOUT_HOTEL",
        title = "Информация об отеле",
        image = R.drawable.hotel_info_img
    )

    object RoomsInformation: ServiceCard(
        route = "ROOMS",
        title = "Информация о комнатах",
        image = R.drawable.hotel_rooms
    )

    object SightsInformation : ServiceCard(
        route = "SIGHTS",
        title = "Достопримечательности",
        image = R.drawable.sights_img
    )

    object RestaurantsAndBarsInformation : ServiceCard(
        route = "RESTAURANTS",
        title = "Рестораны и бары",
        image = R.drawable.restaurants_bars_img
    )

    object FitnessInformation : ServiceCard(
        route = "FITNESS",
        title = "Спа&Фитнес",
        image = R.drawable.fitness_img
    )

    object MoreServicesInformation : ServiceCard(
        route = "ADDITIONAL_SERVICES",
        title = "Услуги",
        image = R.drawable.services_img
    )

    object RoomControlInformation : ServiceCard(
        route = "ROOM_CONTROL",
        title = "Управление комнатой",
        image = R.drawable.room_control_img
    )
}