package com.example.pmdm.model

/**
 * Clase de datos que representa a un usuario en el dominio de la aplicación.
 * Modela la información básica de un usuario para la autenticación y gestión de perfil.
 *
 * @property id Identificador único del usuario (puede ser nulo para usuarios no guardados)
 * @property username Nombre de usuario para autenticación y visualización
 * @property email Dirección de correo electrónico del usuario
 * @property password Contraseña del usuario (debe manejarse de forma segura)
 * @property profileImageId Identificador opcional de la imagen de perfil del usuario
 */
data class User(
    var id: String? = null,
    val username: String,
    val email: String,
    val password: String,
    val profileImageId: Int? = null
)