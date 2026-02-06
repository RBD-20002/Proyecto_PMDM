package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.CredentialsRepository
import com.example.pmdm.ui.state.LoginPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentialsRepository: CredentialsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginPageState())
    val state: StateFlow<LoginPageState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val savedCredentials = credentialsRepository.savedCredentials.first()
            _state.update {
                it.copy(
                    userName = savedCredentials.username,
                    password = savedCredentials.password,
                    rememberCredentials = savedCredentials.remember,
                    isLoginEnabled = isFormValid(savedCredentials.username, savedCredentials.password)
                )
            }
        }
    }

    fun onUsernameChange(userName: String) {
        _state.update {
            it.copy(
                userName = userName,
                usernameError = if (userName.isBlank()) "El usuario no puede estar vacío" else null,
                isLoginEnabled = isFormValid(userName, it.password)
            )
        }
    }

    fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password,
                passwordError = if (password.isBlank()) "La contraseña no puede estar vacía" else null,
                isLoginEnabled = isFormValid(it.userName, password)
            )
        }
    }

    fun onRememberCredentialsChange(remember: Boolean) {
        _state.update { it.copy(rememberCredentials = remember) }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun onLoginSuccess() {
        viewModelScope.launch {
            if (state.value.rememberCredentials) {
                credentialsRepository.saveCredentials(state.value.userName, state.value.password)
            } else {
                credentialsRepository.clearCredentials()
            }
        }
    }

    private fun isFormValid(userName: String, password: String): Boolean =
        userName.isNotBlank() && password.isNotBlank()
}
