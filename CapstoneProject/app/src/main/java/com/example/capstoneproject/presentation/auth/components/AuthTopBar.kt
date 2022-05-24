package com.example.capstoneproject.presentation.auth.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.capstoneproject.core.Constants.AUTH_SCREEN

@Composable
fun AuthTopBar() {
    TopAppBar (
        title = {
            Text(
                text = AUTH_SCREEN
            )
        }
    )
}