package com.example.quickhotel.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R

@Composable
fun LoginContent( // needed to be changed
    onLogInClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    val userLogin = remember {
        mutableStateOf("")
    }
    val userPassword = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(110.dp),
                painter = painterResource(id = R.drawable.app_logo_black),
                contentDescription = "App logo"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(40.dp))
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 15.dp),
                value = userLogin.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.White
                ),
                onValueChange = {
                    userLogin.value = it
                },
                label = {
                    Text(text = "User Login", color = Color.White)
                },
                singleLine = true
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 15.dp),
                value = userLogin.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.White
                ),
                onValueChange = {
                    userPassword.value = it
                },
                label = {
                    Text(text = "User Password", color = Color.White)
                },
                singleLine = true
            )
            Spacer(modifier = Modifier.size(15.dp))
            OutlinedButton(
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp),
                onClick = {
                    onLogInClick() // check difference: .invoke(searchBIN.value)
                },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(40)
            ) {
                Text(
                    text = "Log In",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier.clickable { onForgotClick() },
                text = "Forgot Password",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }

}