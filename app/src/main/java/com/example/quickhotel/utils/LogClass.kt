package com.example.quickhotel.utils

sealed class LogClass(
    val name: String
) {
    object QHApp: LogClass(name = "QHApp")
}