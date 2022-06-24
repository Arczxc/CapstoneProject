package com.example.capstoneproject.presentation.auth

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult
import androidx.appcompat.app.AppCompatActivity.RESULT_OK
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider.getCredential
import com.example.capstoneproject.core.Constants.SIGN_IN_ERROR_MESSAGE
import com.example.capstoneproject.core.Utils.Companion.print
import com.example.capstoneproject.domain.model.Response.*
import com.example.capstoneproject.presentation.auth.components.AuthContent
import com.example.capstoneproject.presentation.components.ProgressBar
import com.example.capstoneproject.ui.presentation.MainScreen.MainScreen

@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    Scaffold(
        content = { padding ->
            AuthContent(padding)
        }
    )

    val launcher =  rememberLauncherForActivityResult(StartIntentSenderForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            try {
                val credentials = viewModel.oneTapClient.getSignInCredentialFromIntent(result.data)
                val googleIdToken = credentials.googleIdToken
                val googleCredentials = getCredential(googleIdToken, null)
                viewModel.signInWithGoogle(googleCredentials)
            } catch (e: ApiException) {
                print(e)
            }
        }
    }

    fun launch(signInResult: BeginSignInResult) {
        val intent = IntentSenderRequest.Builder(signInResult.pendingIntent.intentSender).build()
        launcher.launch(intent)
    }

    when(val oneTapSignInResponse = viewModel.oneTapSignInState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            oneTapSignInResponse.data?.let {
                LaunchedEffect(it) {
                    launch(it)
                }
            }
        }
        is Failure -> {
            oneTapSignInResponse.e?.let {
                LaunchedEffect(Unit) {
                    print(it)
                    if (it.message == SIGN_IN_ERROR_MESSAGE) {
                        viewModel.oneTapSignUp()
                    }
                }
            }
        }
    }

    when(val oneTapSignUpResponse = viewModel.oneTapSignUpState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            oneTapSignUpResponse.data?.let {
                LaunchedEffect(it) {
                    launch(it)
                }
            }
        }
        is Failure -> oneTapSignUpResponse.e?.let {
            LaunchedEffect(Unit) {
                print(it)
            }
        }
    }

    when(val signInResponse = viewModel.signInState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            signInResponse.data?.let { isNewUser ->
                if (isNewUser) {
                    LaunchedEffect(isNewUser) {
                        viewModel.createUser()
                    }
                } else {
                    //navController.navigate(ProfileScreen.route)
                    MainScreen()
                }
            }
        }
        is Failure -> signInResponse.e?.let {
            LaunchedEffect(Unit) {
                print(it)
            }
        }
    }

    when(val createUserResponse = viewModel.createUserState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            createUserResponse.data?.let { isUserCreated ->
                if (isUserCreated) {
                    //navController.navigate(ProfileScreen.route)
                    MainScreen()
                }
            }
        }
        is Failure -> createUserResponse.e?.let {
            LaunchedEffect(Unit) {
                print(it)
            }
        }
    }
}