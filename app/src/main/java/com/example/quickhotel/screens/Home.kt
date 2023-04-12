package com.example.quickhotel.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.BottomBarScreen
import com.example.quickhotel.R
import com.example.quickhotel.navigation.HomeNavGraph

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                items = listOf(
                    BottomBarScreen.Home,
                    BottomBarScreen.Key,
                    BottomBarScreen.Chat
                )
            )
        },
        topBar = {
            TopBar()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            HomeNavGraph(navController = navController)
        }
    }
}
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Room 611",
                    fontSize = 20.sp,
                    maxLines = 1
                )
            }
        },
        backgroundColor = Color.Transparent.copy(alpha = 0.2f),
        //colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan.copy(alpha = 0.3f)),
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    Icons.Default.Menu, "Menu",
                    modifier = Modifier.size(34.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { // synchronize weather

            }) {
                Row() {
                    Icon(
                        modifier = Modifier
                            .size(29.dp),
                        painter = painterResource(id = R.drawable.weather_icon),
                        contentDescription = "Navigation Icon",
                        tint = Color.White,
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "13°C",
                        fontSize = 22.sp,
                        color = Color.White
                    )
                }
            }
        },
        contentColor = Color.White,
    )
}

@Composable
fun BottomBar(
    navController: NavHostController,
    items: List<BottomBarScreen>,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route
            val contentColor =
                if (selected) Color.White else Color.Black // color of icon
            BottomNavigationItem(
                selected = selected,
                onClick = { /*onItemClick(item)*/
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                label = {
                    Text(text = item.title)
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(29.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = "Navigation Icon",
                        tint = contentColor,
                    )
                }
            )
        }
    }
}

