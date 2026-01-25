package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.ui.state.CreateAccountPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CreateAccountPageState())
    val state: StateFlow<CreateAccountPageState> = _state.asStateFlow()

    fun onUsernameChange(value: String) { _state.update { it.copy(username = value, error = null) } }
    fun onEmailChange(value: String) { _state.update { it.copy(email = value, error = null) } }
    fun onPasswordChange(value: String) { _state.update { it.copy(password = value, error = null) } }
    fun onRepeatPasswordChange(value: String) { _state.update { it.copy(repeatPassword = value, error = null) } }

    fun onCreateClick() {
        val s = _state.value
        if (
            s.username.isBlank() ||
            s.email.isBlank() ||
            s.password.isBlank() ||
            s.repeatPassword.isBlank()
        ) {
            _state.update { it.copy(error = "No se pueden dejar campos en blanco") }
            return
        }
        if (s.password != s.repeatPassword) {
            _state.update { it.copy(error = "Las contraseñas no coinciden") }
            return
        }
        userRepository.register(s.username, s.email, s.password)
        _state.update { it.copy(success = true, error = null) }
    }

    fun clearState() { _state.value = CreateAccountPageState() }
}