package com.example.quickhotel.screens.homeScreens.servicesScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun RoomControlScreenContent(
    name: String
) {

    Column {
        TabLayout()
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(

) {
    val tabList = listOf("Свет", "Кондиционер", "Шторы")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPosition ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPosition)
                )
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, el ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {// запуск анимации на второстепенном потоке
                            pagerState.animateScrollToPage(index) // приходит индекс, открываем страницу анимируя
                        }
                    },
                    text = {
                        Text(text = el)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            when (index) {
                0 -> {
                    LightControlTab()
                }

                1 -> {
                    Test2()
                }

                2 -> {
                    Test3()
                }

                else -> {

                }
            }
        }
    }
}


@Composable
fun LightControlTab() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .border(
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedBorder
                )
                .height(55.dp)
                .background(Color.DarkGray)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Общий свет")
            OutlinedButton(
                modifier = Modifier
                    .background(color = Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    /*TODO*/
                },
            ) {
                Text(
                    text = "Вкл",
                    color = Color.White,

                    )
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .border(
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedBorder
                )
                .height(55.dp)
                .background(Color.DarkGray)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Регулировка света")
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        shape = RoundedCornerShape(10.dp),
                        border = ButtonDefaults.outlinedBorder,
                    )
            ) {
                Button(
                    modifier = Modifier
                        .background(color = Color.DarkGray),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                    onClick = {
                        /*TODO*/
                    },
                ) {
                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add",
                        tint = Color.White,
                    )
                }
                Button(
                    modifier = Modifier
                        .background(color = Color.DarkGray),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                    onClick = {
                        /*TODO*/
                    },
                ) {
                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.remove_icon),
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }

        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .border(
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedBorder
                )
                .height(55.dp)
                .background(Color.DarkGray)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Свет у кровати")
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        shape = RoundedCornerShape(10.dp),
                        border = ButtonDefaults.outlinedBorder,
                    )
            ) {
                Button(
                    modifier = Modifier
                        .background(color = Color.DarkGray),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                    onClick = {
                        /*TODO*/
                    },
                ) {
                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add",
                        tint = Color.White,
                    )
                }
                Button(
                    modifier = Modifier
                        .background(color = Color.DarkGray),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                    onClick = {
                        /*TODO*/
                    },
                ) {
                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.remove_icon),
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    Test2()
}

@Composable
fun Test2() {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            modifier = Modifier
                .size(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(100),
            onClick = {
                /*TODO*/
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = "Add",
                tint = Color.White,
            )
        }
        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = "23 C",
            fontSize = 50.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(10.dp))

        OutlinedButton(
            modifier = Modifier
                .size(55.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(100),
            onClick = {
                /*TODO*/
            },
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.remove_icon),
                contentDescription = "Remove",
                tint = Color.White,
            )
        }


        Spacer(modifier = Modifier.size(10.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .border(
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedBorder
                )
        ) {
            Button(
                modifier = Modifier
                    .background(color = Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    /*TODO*/
                },
            ) {
                Text(
                    text = "1",
                    color = Color.White,
                    fontSize = 28.sp
                )
            }
            Button(
                modifier = Modifier
                    .background(color = Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    /*TODO*/
                },
            ) {
                Text(
                    text = "2",
                    color = Color.White,
                    fontSize = 28.sp
                )
            }
            Button(
                modifier = Modifier
                    .background(color = Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    /*TODO*/
                },
            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 28.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(10.dp))
        OutlinedButton(

            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            onClick = {
                /*TODO*/
            },
            shape = RoundedCornerShape(30),

            ) {
            Text(
                text = "Выключить",
                color = Color.White,

                )
        }

    }
}

@Composable
fun Test3() {

    Text(text = "33333333333333333333333")
}
