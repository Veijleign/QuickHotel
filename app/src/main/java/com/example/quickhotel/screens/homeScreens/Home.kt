package com.example.quickhotel.screens.homeScreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quickhotel.utils.BottomBarScreen
import com.example.quickhotel.R
import com.example.quickhotel.navigation.HomeNavGraph
import com.example.quickhotel.retrofit.retrofitWeatherRequest
import com.example.quickhotel.ui.theme.BottomBarColor
import com.example.quickhotel.ui.theme.SelectedColor
import com.example.quickhotel.ui.theme.UnselectedColor
import com.example.quickhotel.utils.LogClass
import com.example.quickhotel.utils.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    Log.d("${LogClass.QHApp}", "Inside Home Screen")
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomBar(navController = navController)
        },
        topBar = {
            TopBar(
                navController,
                onNavigationItemClick = {
                    scope.launch {
                        scaffoldState.drawerState.open() // need to be executed in Coroutine
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "language",
                        title = "Сменить язык",
                        contentDescription = "Change language",
                        icon = Icons.Default.Person
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Настройки",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),
                    MenuItem(
                        id = "help",
                        title = "Помощь",
                        contentDescription = "Get help",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "logOut",
                        title = "Выйти",
                        contentDescription = "Exit account",
                        icon = Icons.Default.ExitToApp
                    )
                ),
                onItemClick = {
                    // здесь можно прописать when для перехода куда-то
                    Log.d("${LogClass.QHApp}", "Clicked on: ${it.title}")
                }
            )
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
fun TopBar(
    navController: NavHostController,
    onNavigationItemClick: () -> Unit
) {
    var currentWeather = remember {
        mutableStateOf("")
    }
    // make BACK button
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Key,
        BottomBarScreen.Chat
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    val bottomBarDestination =
        items.any { it.route == currentDestination } // для запомнинания страницы, чтобы убирался верхня и нижняя навигационные части

        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    when(currentDestination) {
                        "chat" -> {
                            Text(
                                text = "Чат c администратором",
                                fontSize = 20.sp,
                                maxLines = 1
                            )
                        }
                        "home" -> {
                            Text(
                                text = "Комната 611",
                                fontSize = 20.sp,
                                maxLines = 1
                            )
                        }
                        else -> {

                        }
                    }
                }
            },
            backgroundColor = Color.Transparent.copy(alpha = 0.2f),
            //colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan.copy(alpha = 0.3f)),
            navigationIcon = {
                IconButton(
                    onClick = onNavigationItemClick
                ) {
                    Icon(
                        Icons.Default.Menu, "Menu",
                        modifier = Modifier.size(34.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        currentWeather.value = retrofitWeatherRequest()
                    }
                }) {
                    if (currentDestination == "chat" || currentDestination == "key") {

                    } else {
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
                                text = currentWeather.value,
                                fontSize = 22.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            },
            contentColor = Color.White,
        )

}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Key,
        BottomBarScreen.Chat
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    val bottomBarDestination = items.any { it.route == currentDestination } // для запомнинания страницы, чтобы убирался верхня и нижняя навигационные части
    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = BottomBarColor
        ) {
            items.forEach { item ->
                val selected = currentDestination == item.route
                val contentColor =
                    if (selected) SelectedColor else UnselectedColor // color of icon
                BottomNavigationItem(
                    selected = selected,
                    onClick = { /*onItemClick(item)*/
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    selectedContentColor = SelectedColor,
                    unselectedContentColor = UnselectedColor,
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
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(110.dp),
            painter = painterResource(id = R.drawable.app_logo_black),
            contentDescription = "App logo"
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .background(Color.Black) // brushes the whole height
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f) // weight - занимает всё оставшееся пространство
                )
            }
        }
    }
}



