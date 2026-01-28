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
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun login(username: String, password: String) {
        _state.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            when (val result = userRepository.login(username, password)) {
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
                is LoginResult.UserNotFound -> {
                    _state.update { it.copy(isLoading = false, error = "El usuario no existe") }
                }
                is LoginResult.WrongPassword -> {
                    _state.update { it.copy(isLoading = false, error = "La contraseña es incorrecta") }
                }
                is LoginResult.NetworkError -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Error de conexión"
                        )
                    }
                }
            }
        }
    }

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

    fun logout() {
        userRepository.logout()
        _state.value = AuthState()
    }

    fun setError(error: String?) {
        _state.update { it.copy(error = error) }
    }
}
