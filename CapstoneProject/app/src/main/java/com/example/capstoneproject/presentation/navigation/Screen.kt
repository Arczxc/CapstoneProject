package com.example.capstoneproject.presentation.navigation

import com.example.capstoneproject.core.Constants.AUTH_SCREEN
import com.example.capstoneproject.core.Constants.PROFILE_SCREEN

sealed class Screen(val route: String) {
    object AuthScreen: Screen(AUTH_SCREEN)
    object ProfileScreen: Screen(PROFILE_SCREEN)
}