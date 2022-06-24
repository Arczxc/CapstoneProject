package com.example.capstoneproject.ui.presentation.MainScreen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavbardemo.BottomNavGraph
import com.example.capstoneproject.BottomBarScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navController = rememberNavController()

    // Subscribe to navBackStackEntry, required to get current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Control TopBar and BottomBar
    when (navBackStackEntry?.destination?.route) {
        "home" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "ticket" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "cart" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "profile" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        else -> bottomBarState.value = false
    }

            Scaffold(
                bottomBar = {
                    AnimatedVisibility(
                        visible = bottomBarState.value,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it }),
                        content = {
                            BottomAppBar(
                                backgroundColor = Color(0xFFEEEEEE),
                                cutoutShape = CircleShape,
                                elevation = 10.dp
                            ){
                                BottomBar(
                                    navController = navController

                                )
                            }
                        })
                },
                content = {
                    BottomNavGraph(navController = navController)
                },
                floatingActionButton = {
                    AnimatedVisibility(
                        visible = bottomBarState.value,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it }),
                        content = {
                            FloatingActionButton(
                                backgroundColor = MaterialTheme.colors.primary,
                                onClick = {

                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null
                                )
                            }
                        })
                },
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.Center,
            )



}

@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Ticket,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile,
    )

            BottomNavigation{
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                screens.forEach { screen ->
                    BottomNavigationItem(
                        label = {
                            Text(text = screen.title)
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = "Navigation Icon"
                            )
                        },
                        selected = currentRoute == screen.route,
                        selectedContentColor = Color.Green,
                        unselectedContentColor = Color.White,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        modifier = Modifier.background(Color.Black),
                    )
                }
            }
}


/*@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Ticket,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile,
    )
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        modifier = Modifier.background(Color.Black),
    )
}*/
