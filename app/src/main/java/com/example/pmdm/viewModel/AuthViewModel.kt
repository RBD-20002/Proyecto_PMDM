package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.pmdm.ui.state.AuthState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun login(email: String, password: String) {
        // Lógica simple de login
        _state.update {
            it.copy(
                isLoggedIn = true,
                userEmail = email,
                isLoading = false,
                error = null
            )
        }
    }

    fun logout() {
        _state.update {
            AuthState() // Reset al estado inicial
        }
    }

    fun loginAsGuest() {
        _state.update {
            it.copy(
                isLoggedIn = false, // Invitado no está "logueado" pero puede navegar
                userEmail = "invitado",
                isLoading = false,
                error = null
            )
        }
    }

    fun setLoading(loading: Boolean) {
        _state.update {
            it.copy(isLoading = loading)
        }
    }

    fun setError(error: String?) {
        _state.update {
            it.copy(error = error)
        }
    }
}