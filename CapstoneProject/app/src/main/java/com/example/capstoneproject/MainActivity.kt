package com.example.capstoneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.example.capstoneproject.presentation.auth.AuthViewModel
import com.example.capstoneproject.presentation.navigation.NavGraph
import com.example.capstoneproject.presentation.navigation.Screen
import com.example.capstoneproject.ui.presentation.MainScreen.MainScreen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val authViewModel by viewModels<AuthViewModel>()

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            this.setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContent {

            navController = rememberAnimatedNavController()
            NavGraph(
                navController = navController
            )
            checkAuthStatus()
            getAuthState()

        }
    }
@Composable
    private fun checkAuthStatus() {
        if(authViewModel.isUserAuthenticated) {
            MainScreen()
        }
    }

    private fun getAuthState() = authViewModel.getAuthState()
}