package com.example.capstoneproject.ui.presentation.login_signin_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.InputBoxShape
import com.example.capstoneproject.ui.theme.PlaceholderColor
import com.example.capstoneproject.ui.theme.primary
import com.example.capstoneproject.ui.theme.secondary


@Composable
fun signUpScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        topImageSignUp()
        inputInformation()
        buttonSignIn()
        alreadyHaveAccountButton()
    }
}

@Composable
fun topImageSignUp(){

    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(.4f)) {
        Image(
            painter = painterResource(id = R.drawable.register_img),
            contentDescription = "Login Image",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun inputInformation(){

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Sign Up",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                userName()
                emailInput()
                passInput()
                passInput()
            }
        }
    }
}

@Composable
fun userName(){
    var username by remember { mutableStateOf("") }

    OutlinedTextField(
        value = username, onValueChange = {
            username = it
        },
        label = {
            Text(text = "Name", color = Color.Black)
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
                painter = painterResource(R.drawable.ic_user),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Composable
fun buttonSignIn(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        Text("Sign Up",
            color = Color.Black)
    }

}

@Composable
fun alreadyHaveAccountButton(){
    TextButton(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(text = "Already have an account ? Sign In",
            //fontFamily = Poppins,
            color= Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

