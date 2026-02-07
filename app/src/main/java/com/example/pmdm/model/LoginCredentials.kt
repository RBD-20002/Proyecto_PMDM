package com.example.pmdm.model

/**
 * Clase de datos que representa las credenciales de inicio de sesión de un usuario.
 * Utilizada para manejar la información de autenticación tanto en la interfaz de usuario
 * como en el almacenamiento local de credenciales.
 *
 * @property username Nombre de usuario o identificador del usuario
 * @property password Contraseña del usuario
 * @property remember Indica si las credenciales deben recordarse para futuros inicios de sesión
 */
data class LoginCredentials(
    val username: String = "",
    val password: String = "",
    val remember: Boolean = false
)