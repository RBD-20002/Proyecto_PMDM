package com.example.pmdm.viewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.model.User
import com.example.pmdm.ui.state.ProfilePageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val animeRepository: AnimeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ProfilePageState())
    val state: StateFlow<ProfilePageState> = _state.asStateFlow()

    init { loadProfile() }

    /**
     * Carga los datos del usuario y la lista de favoritos. Si ya existe
     * una foto de perfil en el estado, se mantiene.
     */
    fun loadProfile() {
        val session = userRepository.session.value
        _state.update { current ->
            current.copy(
                user = session.user?.let { User(username = it.username, email = it.email, password = it.password) },
                isLoggedIn = session.isLoggedIn,
                favorites = animeRepository.getFavorites(),
                profileImageUri = current.profileImageUri
            )
        }
    }

    /**
     * Almacena la foto de perfil tomada en la cámara.
     * Se llama desde la pantalla de cámara al volver.
     */
    fun updateProfileImage(uri: Uri?) {
        _state.update { current -> current.copy(profileImageUri = uri) }
    }
}
