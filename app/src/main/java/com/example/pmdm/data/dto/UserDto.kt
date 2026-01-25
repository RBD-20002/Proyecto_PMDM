package com.example.pmdm.data.dto

/**
 * DTO de User. Mantiene los mismos campos que el modelo original,
 * añadiendo un identificador y una contraseña.
 */
data class UserDto(
    var id: String,
    val username: String,
    val email: String,
    val password: String,
    val profileImageId: Int? = null
)
