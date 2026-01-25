package com.example.pmdm.data.dto

/**
 * DTO de Session que refleja el estado de sesión y el usuario asociado.
 * Aquí se utiliza UserDto en lugar de User como tipo del usuario.
 */
data class SessionDto(
    val isLoggedIn: Boolean = false,
    val user: UserDto? = null
)
