package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.ui.state.LoginPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginPageState())
    val state: StateFlow<LoginPageState> = _state.asStateFlow()

    fun onEmailChange(email: String) {
        _state.update {
            it.copy(
                email = email,
                isLoginEnabled = isFormValid(email, it.password)
            )
        }
    }

    fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password,
                isLoginEnabled = isFormValid(it.email, password)
            )
        }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun setLoginError(errorMessage: String?) {
        _state.update { it.copy(loginError = errorMessage) }
    }

    private fun isFormValid(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }
}
