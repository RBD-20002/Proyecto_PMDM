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

/**
 * ViewModel para la pantalla de inicio de sesión que gestiona el estado del formulario,
 * la persistencia de credenciales y la validación de datos.
 * Utiliza Hilt para la inyección de dependencias.
 *
 * @property credentialsRepository Repositorio que maneja el almacenamiento local de credenciales
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentialsRepository: CredentialsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginPageState())
    val state: StateFlow<LoginPageState> = _state.asStateFlow()

    /**
     * Inicializador que carga las credenciales guardadas al crear el ViewModel.
     * Restaura el estado del formulario con los datos almacenados previamente.
     */
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

    /**
     * Actualiza el nombre de usuario en el estado y realiza validación básica.
     *
     * @param userName Nuevo valor para el nombre de usuario
     */
    fun onUsernameChange(userName: String) {
        _state.update {
            it.copy(
                userName = userName,
                usernameError = if (userName.isBlank()) "El usuario no puede estar vacío" else null,
                isLoginEnabled = isFormValid(userName, it.password)
            )
        }
    }

    /**
     * Actualiza la contraseña en el estado y realiza validación básica.
     *
     * @param password Nuevo valor para la contraseña
     */
    fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password,
                passwordError = if (password.isBlank()) "La contraseña no puede estar vacía" else null,
                isLoginEnabled = isFormValid(it.userName, password)
            )
        }
    }

    /**
     * Actualiza la preferencia de recordar credenciales.
     *
     * @param remember Nuevo valor para la preferencia de recordar credenciales
     */
    fun onRememberCredentialsChange(remember: Boolean) {
        _state.update { it.copy(rememberCredentials = remember) }
    }

    /**
     * Alterna la visibilidad de la contraseña entre visible/oculta.
     */
    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    /**
     * Procesa las acciones necesarias después de un inicio de sesión exitoso.
     * Guarda o borra las credenciales según la preferencia del usuario.
     */
    fun onLoginSuccess() {
        viewModelScope.launch {
            if (state.value.rememberCredentials) {
                credentialsRepository.saveCredentials(state.value.userName, state.value.password)
            } else {
                credentialsRepository.clearCredentials()
            }
        }
    }

    /**
     * Valida si el formulario está completo y puede habilitar el botón de inicio de sesión.
     *
     * @param userName Nombre de usuario a validar
     * @param password Contraseña a validar
     * @return true si ambos campos no están en blanco, false en caso contrario
     */
    private fun isFormValid(userName: String, password: String): Boolean =
        userName.isNotBlank() && password.isNotBlank()
}