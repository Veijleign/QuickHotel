package com.example.quickhotel.screens.loginScreens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickhotel.R
import com.example.quickhotel.utils.LogClass

@Composable
fun LoginContent( // needed to be changed
    onLogInClick: (String, String) -> Unit,
    onForgotClick: () -> Unit,
    onLogInAsGuest: () -> Unit
) {
    Log.d("${LogClass.QHApp}", "Login Screen")
    val userLogin = remember {
        mutableStateOf("")
    }
    val userPassword = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    val icon = if (passwordVisibility.value)
        painterResource(id = R.drawable.visibility_icon)
    else
        painterResource(id = R.drawable.visibility_off_icon)
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
            //login
            Spacer(modifier = Modifier.size(40.dp))
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 15.dp),
                value = userLogin.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.White,
                    textColor = Color.White
                ),
                onValueChange = {
                    userLogin.value = it
                },
                label = {
                    Text(text = "User Login", color = Color.White)
                },
                singleLine = true
            )
            //password
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 15.dp),
                value = userPassword.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.White,
                    textColor = Color.White
                ),
                onValueChange = {
                    userPassword.value = it
                },
                label = {
                    Text(text = "User Password", color = Color.White)
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "visibility Icon",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.size(15.dp))
            // login and guest btns
            Row {
                // login btn
                OutlinedButton(
                    modifier = Modifier
                        .width(110.dp)
                        .height(45.dp),
                    onClick = {
                        onLogInClick(userLogin.value, userPassword.value)
                    },
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape(40),
                    //can be repalced to this
                    //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Log In",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                // guest btn
                OutlinedButton(
                    modifier = Modifier
                        .width(110.dp)
                        .height(45.dp),
                    onClick = {
                        onLogInAsGuest()
                    },
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape(40),
                    //can be repalced to this
                    //colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Гость",
                        color = Color.White
                    )
                }
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