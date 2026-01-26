package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun login(email: String, password: String) {
        _state.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            try {
                val ok = userRepository.login(email = email, password = password)

                val session = userRepository.session.value
                _state.update {
                    it.copy(
                        isLoggedIn = ok && session.isLoggedIn,
                        userEmail = session.user?.email ?: "",
                        isLoading = false,
                        error = if (ok) null else "Correo o contraseña incorrectos"
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoggedIn = false,
                        userEmail = "",
                        isLoading = false,
                        error = e.message ?: "Error de conexión"
                    )
                }
            }
        }
    }

    fun logout() {
        userRepository.logout()
        _state.value = AuthState()
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

    fun setLoading(loading: Boolean) {
        _state.update { it.copy(isLoading = loading) }
    }

    fun setError(error: String?) {
        _state.update { it.copy(error = error) }
    }
}
