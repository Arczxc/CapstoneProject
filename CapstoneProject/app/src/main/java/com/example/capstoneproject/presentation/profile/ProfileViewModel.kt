package com.example.capstoneproject.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.domain.model.Response
import com.example.capstoneproject.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    private val _signOutState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signOutState: State<Response<Boolean>> = _signOutState

    private val _revokeAccessState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val revokeAccessState: State<Response<Boolean>> = _revokeAccessState

    val displayName get() = repo.getDisplayName()

    val photoUrl get() = repo.getPhotoUrl()

    fun signOut() {
        viewModelScope.launch {
            repo.signOut().collect { response ->
                _signOutState.value = response
            }
        }
    }

    fun revokeAccess() {
        viewModelScope.launch {
            repo.revokeAccess().collect { response ->
                _revokeAccessState.value = response
            }
        }
    }
}