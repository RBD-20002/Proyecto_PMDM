package com.example.pmdm.viewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.model.User
import com.example.pmdm.ui.state.ProfilePageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel del perfil.  Gestiona el estado del usuario, favoritos y foto de perfil.
 */
class ProfileViewModel : ViewModel() {
    private val _state = MutableStateFlow(ProfilePageState())
    val state: StateFlow<ProfilePageState> = _state.asStateFlow()

    init {
        loadProfile()
    }

    /**
     * Carga los datos del usuario y la lista de favoritos.  Si ya existe
     * una foto de perfil en el estado, se mantiene.
     */
    fun loadProfile() {
        _state.update { current ->
            current.copy(
                user = User("NicoDev", "nico@example.com"),
                isLoggedIn = true,
                favorites = DataProvider.getListFavoriteAnime(),
                profileImageUri = current.profileImageUri
            )
        }
    }

    /**
     * Almacena la foto de perfil tomada en la cámara.  Se llama desde
     * [CameraPage] a través de [AppNavHost] al volver de la pantalla de cámara.
     *
     * @param uri [Uri] de la foto capturada o null si hubo un error.
     */
    fun updateProfileImage(uri: Uri?) {
        _state.update { current -> current.copy(profileImageUri = uri) }
    }
}
