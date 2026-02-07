package com.example.pmdm.ui.state

/**
 * Clase de datos que representa el estado de autenticación de la aplicación.
 * Contiene información sobre el estado de inicio de sesión del usuario y posibles errores.
 *
 * @property isLoggedIn Indica si hay un usuario autenticado en la aplicación
 * @property userEmail Email del usuario autenticado (cadena vacía si no hay usuario)
 * @property isLoading Indica si se está realizando una operación de autenticación (login/registro)
 * @property error Mensaje de error relacionado con la autenticación, o null si no hay error
 */
data class AuthState(
    val isLoggedIn: Boolean = false,
    val userEmail: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)