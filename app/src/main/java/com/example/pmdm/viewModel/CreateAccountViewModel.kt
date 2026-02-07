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

/**
 * ViewModel para la pantalla de creación de cuenta que gestiona el estado
 * y la lógica de negocio para registrar nuevos usuarios.
 * Utiliza Hilt para la inyección de dependencias.
 *
 * @property userRepository Repositorio que maneja las operaciones de usuario
 */
@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CreateAccountPageState())
    val state: StateFlow<CreateAccountPageState> = _state.asStateFlow()


    /**
     * Actualiza el nombre de usuario en el estado, normalizándolo y limpiando errores.
     *
     * @param value Nuevo valor para el nombre de usuario
     */
    fun onUsernameChange(value: String) {
        val normalized = value.trim().lowercase(Locale.ROOT)
        _state.update { it.copy(username = normalized, error = null) }
    }

    /**
     * Actualiza el email en el estado, normalizándolo y limpiando errores.
     *
     * @param value Nuevo valor para el email
     */
    fun onEmailChange(value: String) {
        val normalized = value.trim().lowercase(Locale.ROOT)
        _state.update { it.copy(email = normalized, error = null) }
    }

    /**
     * Actualiza la contraseña en el estado, normalizándola y limpiando errores.
     *
     * @param value Nuevo valor para la contraseña
     */
    fun onPasswordChange(value: String) {
        val normalized = value.trim()
        _state.update { it.copy(password = normalized, error = null) }
    }

    /**
     * Actualiza la confirmación de contraseña en el estado, normalizándola y limpiando errores.
     *
     * @param value Nuevo valor para la confirmación de contraseña
     */
    fun onRepeatPasswordChange(value: String) {
        val normalized = value.trim()
        _state.update { it.copy(repeatPassword = normalized, error = null) }
    }

    /**
     * Alterna la visibilidad de la contraseña principal entre visible/oculta.
     */
    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    /**
     * Alterna la visibilidad de la confirmación de contraseña entre visible/oculta.
     */
    fun toggleRepeatPasswordVisibility() {
        _state.update { it.copy(repeatPasswordVisible = !it.repeatPasswordVisible) }
    }

    /**
     * Procesa la creación de cuenta cuando el usuario hace clic en el botón correspondiente.
     * Realiza validaciones básicas antes de enviar la solicitud al repositorio.
     */
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

    /**
     * Restablece el estado a sus valores predeterminados.
     * Útil después de una creación exitosa o al navegar fuera de la pantalla.
     */
    fun clearState() {
        _state.value = CreateAccountPageState()
    }
}