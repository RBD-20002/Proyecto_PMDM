package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.LoginResult
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.ui.state.LoginPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginPageState())
    val state: StateFlow<LoginPageState> = _state.asStateFlow()


    fun onUsernameChange(userName: String) {
        val normalizedUser = userName.trim().lowercase(Locale.ROOT)

        _state.update {
            it.copy(
                userName = normalizedUser,
                usernameError = if (normalizedUser.isBlank()) "El usuario no puede estar vacío" else null,
                isLoginEnabled = isFormValid(normalizedUser, it.password),
                loginError = null
            )
        }
    }


    fun onPasswordChange(password: String) {
        val normalizedPass = password.trim()

        _state.update {
            it.copy(
                password = normalizedPass,
                passwordError = if (normalizedPass.isBlank()) "La contraseña no puede estar vacía" else null,
                isLoginEnabled = isFormValid(it.userName, normalizedPass),
                loginError = null
            )
        }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun onLoginClick(onResult: (LoginResult) -> Unit = {}) {
        val current = _state.value

        if (!current.isLoginEnabled) {
            _state.update { it.copy(loginError = "Complete ambos campos para iniciar sesión") }
            return
        }

        viewModelScope.launch {
            val result = userRepository.login(
                username = current.userName,
                password = current.password
            )

            when (result) {
                is LoginResult.Success -> _state.update { it.copy(loginError = null) }
                is LoginResult.UserNotFound -> _state.update { it.copy(loginError = "El usuario no existe") }
                is LoginResult.WrongPassword -> _state.update { it.copy(loginError = "La contraseña es incorrecta") }
                is LoginResult.NetworkError -> _state.update { it.copy(loginError = result.message ?: "Error de conexión") }
            }

            onResult(result)
        }
    }

    fun setLoginError(errorMessage: String?) {
        _state.update { it.copy(loginError = errorMessage) }
    }

    private fun isFormValid(userName: String, password: String): Boolean =
        userName.isNotBlank() && password.isNotBlank()
}
