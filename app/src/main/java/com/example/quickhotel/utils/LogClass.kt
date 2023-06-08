package com.example.quickhotel.utils

sealed class LogClass(
    val name: String
) {
    object QHApp: LogClass(name = "QHApp")
}

data class WeatherModel(
    val current_weather: CurrentWeather,
    val elevation: Double,
    val generationtime_ms: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
) {
    data class CurrentWeather(
        val is_day: Int,
        val temperature: Double,
        val time: String,
        val weathercode: Int,
        val winddirection: Double,
        val windspeed: Double
    )
}
