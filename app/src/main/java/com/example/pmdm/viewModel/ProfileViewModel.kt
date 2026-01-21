package com.example.pmdm.viewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.model.User
import com.example.pmdm.state.ProfilePageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfilePageState())
    val state: StateFlow<ProfilePageState> = _state.asStateFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        _state.update {
            it.copy(
                user = User("NicoDev", "nico@example.com"),
                isLoggedIn = true,
                favorites = DataProvider.getListFavoriteAnime()
                // profileImageUri se mantiene tal cual (no la pisamos)
            )
        }
    }

    /**
     * ✅ NUEVO: guardar la foto del perfil.
     * Se llama desde CameraPage cuando termina la captura.
     */
    fun updateProfileImage(uri: Uri?) {
        _state.update { current ->
            current.copy(profileImageUri = uri)
        }
    }
}
