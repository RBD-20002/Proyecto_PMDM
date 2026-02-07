package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.LoginResult
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.ui.state.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

/**
 * ViewModel de autenticación que gestiona el estado de inicio de sesión,
 * registro y cierre de sesión de usuarios.
 * Utiliza Hilt para la inyección de dependencias y se comunica con UserRepository.
 *
 * @property userRepository Repositorio que maneja las operaciones de usuario
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    /**
     * Normalización:
     * - username: trim + lowercase
     * - password: trim (SIN lowercase)
     */

    /**
     * Intenta autenticar a un usuario con nombre de usuario y contraseña.
     * Normaliza los datos de entrada antes de enviarlos al repositorio.
     *
     * @param username Nombre de usuario proporcionado
     * @param password Contraseña proporcionada
     */
    fun login(username: String, password: String) {
        val normalizedUser = username.trim().lowercase(Locale.ROOT)
        val normalizedPass = password.trim()

        _state.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            when (val result = userRepository.login(normalizedUser, normalizedPass)) {
                is LoginResult.Success -> {
                    val session = userRepository.session.value
                    _state.update {
                        it.copy(
                            isLoggedIn = session.isLoggedIn,
                            userEmail = session.user?.username ?: "",
                            isLoading = false,
                            error = null
                        )
                    }
                }

                is LoginResult.UserNotFound ->
                    _state.update { it.copy(isLoading = false, error = "El usuario no existe") }

                is LoginResult.WrongPassword ->
                    _state.update { it.copy(isLoading = false, error = "La contraseña es incorrecta") }

                is LoginResult.NetworkError ->
                    _state.update { it.copy(isLoading = false, error = result.message ?: "Error de conexión") }
            }
        }
    }

    /**
     * Establece al usuario como invitado (sin autenticación).
     * Actualiza el estado para reflejar el modo invitado.
     */
    fun loginAsGuest() {
        userRepository.loginAsGuest()
        _state.update {
            it.copy(
                isLoggedIn = false,
                userEmail = "invitado",
                isLoading = false,
                error = null
            )
        }
    }

    /**
     * Cierra la sesión del usuario actual.
     * Restablece el estado de autenticación a valores predeterminados.
     */
    fun logout() {
        userRepository.logout()
        _state.value = AuthState()
    }

    /**
     * Establece manualmente un mensaje de error en el estado de autenticación.
     *
     * @param error Mensaje de error a mostrar, o null para limpiar el error
     */
    fun setError(error: String?) {
        _state.update { it.copy(error = error) }
    }
}