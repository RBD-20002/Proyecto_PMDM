package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.ui.state.LoginPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = MutableStateFlow(LoginPageState())
    val state: StateFlow<LoginPageState> = _state.asStateFlow()

    fun onEmailChange(email: String) {
        _state.update {
            it.copy(
                email = email,
                emailError = if (email.isBlank()) "El email no puede estar vacío" else null,
                isLoginEnabled = isFormValid(email, it.password)
            )
        }
    }

    fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password,
                passwordError = if (password.isBlank()) "La contraseña no puede estar vacía" else null,
                isLoginEnabled = isFormValid(it.email, password)
            )
        }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    /**
     * Llama al UserRepository para iniciar sesión cuando el formulario es válido.
     */
    fun onLoginClick() {
        val current = _state.value
        if (current.isLoginEnabled) {
            viewModelScope.launch {
                try {
                    userRepository.login(
                        username = current.email.substringBefore("@"),
                        email = current.email,
                        password = current.password
                    )
                } catch (e: Exception) {
                    _state.update { it.copy(loginError = e.message) }
                }
            }
        } else {
            _state.update { it.copy(loginError = "Complete ambos campos para iniciar sesión") }
        }
    }

    fun setLoginError(errorMessage: String?) {
        _state.update { it.copy(loginError = errorMessage) }
    }

    private fun isFormValid(email: String, password: String) =
        email.isNotBlank() && password.isNotBlank()
}