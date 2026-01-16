package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.Anime
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfileData()
    }

    private fun loadProfileData() {
        // Datos de ejemplo (después vendrán de BD/API)
        val favoriteAnimes = DataProvider.getListFavoriteAnime()
            .map { cardConfig ->
                Anime(
                    id = cardConfig.id,
                    title = cardConfig.title,
                    synopsis = cardConfig.synopsis,
                    info = cardConfig.info,
                    imageId = cardConfig.imageId,
                    imageDesc = cardConfig.imageDesc,
                    enlace1 = cardConfig.enlace1,
                    enlace2 = cardConfig.enlace2,
                    isFavorite = true
                )
            }
            .take(15)

        _uiState.update {
            it.copy(
                username = "NicoDev",
                email = "nico@example.com",
                role = "Premium",
                profileImageId = 0, // Resource ID por defecto
                favoriteAnimes = favoriteAnimes,
                isLoading = false
            )
        }
    }

    fun toggleEditMode() {
        _uiState.update { currentState ->
            if (currentState.isEditing) {
                // Si estaba editando, cancelar (restaurar valores originales)
                currentState.copy(
                    isEditing = false,
                    editUsername = currentState.username,
                    editEmail = currentState.email
                )
            } else {
                // Entrar en modo edición
                currentState.copy(
                    isEditing = true,
                    editUsername = currentState.username,
                    editEmail = currentState.email
                )
            }
        }
    }

    fun onEditUsernameChange(newUsername: String) {
        _uiState.update { it.copy(editUsername = newUsername) }
    }

    fun onEditEmailChange(newEmail: String) {
        _uiState.update { it.copy(editEmail = newEmail) }
    }

    fun saveProfileChanges() {
        _uiState.update { currentState ->
            if (currentState.editUsername.isBlank() || currentState.editEmail.isBlank()) {
                currentState.copy(
                    errorMessage = "Usuario y email son requeridos",
                    isEditing = true
                )
            } else {
                currentState.copy(
                    username = currentState.editUsername,
                    email = currentState.editEmail,
                    isEditing = false,
                    errorMessage = null
                )
            }
        }
    }

    fun onFavoritesUpdated() {
        loadProfileData() // Recargar favoritos
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}

data class ProfileUiState(
    val username: String = "",
    val email: String = "",
    val role: String = "",
    val profileImageId: Int = 0,
    val favoriteAnimes: List<Anime> = emptyList(),
    val isLoading: Boolean = true,
    val isEditing: Boolean = false,
    val editUsername: String = "",
    val editEmail: String = "",
    val errorMessage: String? = null
)