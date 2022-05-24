package com.example.bottomnavbardemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.capstoneproject.BottomBarScreen
import com.example.capstoneproject.LogInNavigation
import com.example.capstoneproject.ProductNavigation
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.Cart
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProductData.ProductScreen
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProductHomeScreen
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProfileScreen
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.Ticket
import com.example.capstoneproject.ui.presentation.login_signin_ui.LoginScreen
import com.example.capstoneproject.ui.presentation.login_signin_ui.SignUpScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            bottomBarState.value = true
            ProductHomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Ticket.route) {
            bottomBarState.value = true
            Ticket()
        }
        composable(route = BottomBarScreen.Cart.route) {
            bottomBarState.value = true
            Cart()
        }
        composable(route = BottomBarScreen.Profile.route) {
            bottomBarState.value = true
            ProfileScreen(navController = navController )
        }
        composable(route = LogInNavigation.Login.route) {
            bottomBarState.value = false
            LoginScreen(navController = navController )
        }
        composable(route = LogInNavigation.Signup.route) {
            bottomBarState.value = false
            SignUpScreen(navController = navController)
        }
        composable(
            route = ProductNavigation.ProductScreen.route + "/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("productId")
            ProductScreen(navController, id!!)
        }
    }
}