package com.example.quickhotel

sealed class ServiceCard(
    val route: String,
    val title: String,
    val image: Int
) {

    object HomeScreen: BottomBarScreen(
        route = "home",
        title = "home",
        icon = R.drawable.main_icon
    )

    object HotelInformation : ServiceCard(
        route = "HotelInformation",
        title = "Информация об отеле",
        image = R.drawable.hotel_info_img
    )

    object SightsInformation : ServiceCard(
        route = "SightsInformation",
        title = "Достопримечательности",
        image = R.drawable.sights_img
    )

    object RestaurantsAndBarsInformation : ServiceCard(
        route = "RestaurantsAndBarsInformation",
        title = "Рестораны и бары",
        image = R.drawable.restaurants_bars_img
    )

    object FitnessInformation : ServiceCard(
        route = "FitnessInformation",
        title = "Спа&Фитнес",
        image = R.drawable.fitness_img
    )

    object ServiceInformation : ServiceCard(
        route = "ServiceInformation",
        title = "Услуги",
        image = R.drawable.services_img
    )

    object AdditionalServiceInformation : ServiceCard(
        route = "AdditionalServiceInformation",
        title = "Дополнительные услуги",
        image = R.drawable.additional_service_img
    )

    object RoomControlInformation : ServiceCard(
        route = "RoomControlInformation",
        title = "Управление комнатой",
        image = R.drawable.room_control_img
    )
}