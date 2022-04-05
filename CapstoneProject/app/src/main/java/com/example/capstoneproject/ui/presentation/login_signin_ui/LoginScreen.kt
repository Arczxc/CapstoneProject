package com.example.capstoneproject.ui.presentation.login_signin_ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R


@Composable
fun loginScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        topImageLogIn()
        Spacer(modifier = Modifier.padding(8.dp))
        googleButton()
        inputEmailPass()
    }
}

@Composable
fun topImageLogIn(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(.5f)) {
        Image(
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = "Login Image",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun googleButton() {
    OutlinedButton(onClick = { /*TODO*/ },
        //modifier= Modifier.size(50.dp),  //avoid the oval shape
        shape = RectangleShape ,
        border= BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(8.dp),  //avoid the little icon
        colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(26.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Continue with Google", color = Color.Black, fontSize = 16.sp)
        }
    }
}


@Composable
fun inputEmailPass(){

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Log In with Email",
                //color = LightTextColor,
                //fontFamily = Poppins,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            emailInput()
            passInput()
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 14.dp)
            ) {
                Text(text = "Login")
            }

            TextButton(
                onClick = {},
                contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Text(
                    text = "Forgot Password ?",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 26.dp)
                )
            }
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(vertical = 0.dp)
            ) {
                Text(
                    text = "Don't have an Account ? Sign Up",
                    color = Color.Gray,
                    fontSize = 12.sp,
                )
            }

        }
    }
}

@Composable
fun emailInput(){
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email, onValueChange = {
            email = it
        },
        label = {
            Text(text = "Email Address", color = Color.Black)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            textColor = Color.Black

        ),
        keyboardOptions = KeyboardOptions(
            keyboardType =
            KeyboardType.Email
        ),
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Composable
fun passInput(){
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password, onValueChange = {
            password = it
        },
        label = {
            Text(text = "Password", color = Color.Black)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            textColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        },
        trailingIcon = {
            IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                if (!isPasswordOpen) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye_open),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye_close),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
}


