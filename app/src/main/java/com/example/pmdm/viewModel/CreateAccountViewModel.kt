package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.RegisterResult
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.ui.state.CreateAccountPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CreateAccountPageState())
    val state: StateFlow<CreateAccountPageState> = _state.asStateFlow()

    fun onUsernameChange(value: String) {
        val normalized = value.trim().lowercase(Locale.ROOT)
        _state.update { it.copy(username = normalized, error = null) }
    }

    fun onEmailChange(value: String) {
        val normalized = value.trim().lowercase(Locale.ROOT)
        _state.update { it.copy(email = normalized, error = null) }
    }

    fun onPasswordChange(value: String) {
        val normalized = value.trim()
        _state.update { it.copy(password = normalized, error = null) }
    }

    fun onRepeatPasswordChange(value: String) {
        val normalized = value.trim()
        _state.update { it.copy(repeatPassword = normalized, error = null) }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun toggleRepeatPasswordVisibility() {
        _state.update { it.copy(repeatPasswordVisible = !it.repeatPasswordVisible) }
    }

    fun onCreateClick() {
        val s = _state.value

        if (s.username.isBlank() || s.email.isBlank() || s.password.isBlank() || s.repeatPassword.isBlank()) {
            _state.update { it.copy(error = "No se pueden dejar campos en blanco") }
            return
        }
        if (s.password != s.repeatPassword) {
            _state.update { it.copy(error = "Las contraseñas no coinciden") }
            return
        }

        viewModelScope.launch {
            when (val result = userRepository.register(s.username, s.email, s.password)) {
                is RegisterResult.Success ->
                    _state.update { it.copy(success = true, error = null) }

                is RegisterResult.UsernameAlreadyExists ->
                    _state.update { it.copy(success = false, error = "El usuario ya existe") }

                is RegisterResult.NetworkError ->
                    _state.update { it.copy(success = false, error = result.message ?: "Error creando usuario") }
            }
        }
    }

    fun clearState() {
        _state.value = CreateAccountPageState()
    }
}
