package com.example.capstoneproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val show: Boolean
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home,
        show = true
    )

    object Ticket : BottomBarScreen(
        route = "ticket",
        title = "Ticket",
        icon = Icons.Default.SupportAgent,
        show = true
    )

    object Cart : BottomBarScreen(
        route = "cart",
        title = "Cart",
        icon = Icons.Default.ShoppingCart,
        show = true
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person,
        show = true
    )

}

sealed class LogInNavigation(
    val route: String,
    val title: String
){
    object Login: LogInNavigation(
        route = "login",
        title = "Login"
    )

    object Signup: LogInNavigation(
        route = "signup",
        title = "Signup"
    )
}

sealed class ProductNavigation(
    val route: String,
    val title: String
){
    object ProductScreen: LogInNavigation(
        route = "productScreen",
        title = "ProductScreen"
    )
}
