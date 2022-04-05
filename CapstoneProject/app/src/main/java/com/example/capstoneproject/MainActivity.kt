package com.example.capstoneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.capstoneproject.ui.presentation.product_screen_ui.ProductHomeScreen
import com.example.capstoneproject.ui.theme.CapstoneProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneProjectTheme {
                //loadingScreen()
                //loginScreen()
                //signUpScreen()
                ProductHomeScreen()
            }
        }
    }
}
