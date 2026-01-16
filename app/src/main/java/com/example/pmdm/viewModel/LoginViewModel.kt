package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _uiState.update { it.copy(username = newUsername) }
    }

    fun onEmailChange(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = newConfirmPassword) }
    }

    fun onSubmitLogin() {
        // Validar y procesar login
        val state = _uiState.value

        val errors = mutableListOf<String>()
        if (state.username.isBlank()) errors.add("Usuario requerido")
        if (state.email.isBlank()) errors.add("Email requerido")
        if (state.password.length < 6) errors.add("Mínimo 6 caracteres")
        if (state.password != state.confirmPassword) errors.add("Contraseñas no coinciden")

        if (errors.isEmpty()) {
            _uiState.update {
                it.copy(
                    isSuccess = true,
                    successMessage = "¡Bienvenido ${state.username}!",
                    errorMessage = null
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    errorMessage = errors.joinToString("\n"),
                    isSuccess = false
                )
            }
        }
    }

    fun onSubmitGuest() {
        _uiState.update {
            it.copy(
                isSuccess = true,
                successMessage = "Modo invitado activado",
                errorMessage = null
            )
        }
    }

    fun resetState() {
        _uiState.update { LoginUiState() }
    }
}

data class LoginUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val errorMessage: String? = null,
    val isSuccess: Boolean = false,
    val successMessage: String = ""
){
    // Propiedad computada para habilitar botones
    val isFormValid: Boolean
        get() = username.isNotBlank() && email.isNotBlank() && password.length >= 6 && confirmPassword == password
}