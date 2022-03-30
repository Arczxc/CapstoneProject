package com.example.capstoneproject.ui.presentation.login_signin_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.R

@Composable
fun loadingScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
    ){
        Card(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.loadingscreen),
                contentDescription = "LoadingScreen",
                contentScale = ContentScale.FillBounds
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 200.dp)
        ) {
            Text(text = "Sign Up Now")
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 150.dp)
        ) {
            Text(text = "Log In")
        }
    }
}