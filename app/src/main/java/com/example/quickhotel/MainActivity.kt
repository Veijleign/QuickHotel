package com.example.quickhotel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.navigation.RootNavigationGraph
import com.example.quickhotel.ui.theme.QuickHotelTheme
import com.example.quickhotel.utils.LogClass
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickHotelTheme {

                val systemUiController = rememberSystemUiController() // fix white theme version
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.Black,
                        darkIcons = false
                    )
                    systemUiController.setNavigationBarColor(
                        color = Color.Black,
                        darkIcons = false
                    )
                }
                Log.d("${LogClass.QHApp}", "MainActivity")
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
