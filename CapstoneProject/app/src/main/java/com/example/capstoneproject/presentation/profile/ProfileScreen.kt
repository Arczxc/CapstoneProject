package com.example.capstoneproject.presentation.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult.ActionPerformed
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import com.example.capstoneproject.core.Constants.REVOKE_ACCESS_MESSAGE
import com.example.capstoneproject.core.Constants.SIGN_OUT
import com.example.capstoneproject.core.Utils.Companion.print
import com.example.capstoneproject.domain.model.Response.*
import com.example.capstoneproject.presentation.components.ProgressBar
import com.example.capstoneproject.presentation.navigation.Screen.AuthScreen
import com.example.capstoneproject.presentation.profile.components.ProfileContent
import com.example.capstoneproject.presentation.profile.components.ProfileTopBar


@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            ProfileTopBar()
        },
        content = { padding ->
            ProfileContent(padding)
        },
        scaffoldState = scaffoldState
    )

    when(val signOutResponse = viewModel.signOutState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            val signedOut = signOutResponse.data
            signedOut?.let {
                if (signedOut) {
                    LaunchedEffect(signOutResponse.data) {
                        navController.popBackStack()
                        navController.navigate(AuthScreen.route)
                    }
                }
            }
        }
        is Failure -> signOutResponse.e?.let {
            LaunchedEffect(Unit) {
                print(it)
            }
        }
    }

    when(val revokeAccessResponse = viewModel.revokeAccessState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            val accessRevoked = revokeAccessResponse.data
            accessRevoked?.let {
                if (accessRevoked) {
                    LaunchedEffect(revokeAccessResponse.data) {
                        navController.popBackStack()
                        navController.navigate(AuthScreen.route)
                    }
                }
            }
        }
        is Failure -> revokeAccessResponse.e?.let {
            LaunchedEffect(Unit) {
                print(it)

                coroutineScope.launch {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = REVOKE_ACCESS_MESSAGE,
                        actionLabel = SIGN_OUT
                    )
                    if (result == ActionPerformed) {
                        viewModel.signOut()
                    }
                }
            }
        }
    }
}