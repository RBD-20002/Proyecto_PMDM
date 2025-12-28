package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UserProfileUiState())
    val uiState: StateFlow<UserProfileUiState> = _uiState.asStateFlow()

    fun updateUsername(newUsername: String) {
        _uiState.update { it.copy(username = newUsername) }
    }

    fun updateEmail(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updateProfileImage(newImage: Int) {
        _uiState.update { it.copy(profileImage = newImage) }
    }
}

data class UserProfileUiState(
    val username: String = "Usuario Invitado",
    val email: String = "invitado@example.com",
    val role: String = "Invitado",
    val profileImage: Int? = null
)
