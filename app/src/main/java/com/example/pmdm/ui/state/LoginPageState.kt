package com.example.pmdm.ui.state

/**
 * Clase de datos que representa el estado de la pantalla de inicio de sesión.
 * Contiene todos los valores de los campos de entrada, estados de visibilidad,
 * errores de validación y configuraciones de usuario.
 *
 * @property userName Nombre de usuario ingresado por el usuario
 * @property password Contraseña ingresada por el usuario
 * @property passwordVisible Indica si la contraseña es visible (true) u oculta (false)
 * @property isLoginEnabled Indica si el botón de inicio de sesión debe estar habilitado
 * @property usernameError Mensaje de error específico para el campo de nombre de usuario, o null si no hay error
 * @property passwordError Mensaje de error específico para el campo de contraseña, o null si no hay error
 * @property loginError Mensaje de error general de inicio de sesión, o null si no hay error
 * @property rememberCredentials Indica si las credenciales deben recordarse para futuros inicios de sesión
 */
data class LoginPageState(
    val userName: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoginEnabled: Boolean = false,
    val usernameError: String? = null,
    val passwordError: String? = null,
    val loginError: String? = null,
    val rememberCredentials: Boolean = false
)