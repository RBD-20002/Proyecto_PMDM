package com.example.pmdm.data.dto

/**
 * Objeto de Transferencia de Datos (DTO) que representa el estado de sesión del usuario.
 * Contiene información sobre si el usuario ha iniciado sesión y los datos del usuario asociado.
 *
 * @property isLoggedIn Estado booleano que indica si el usuario ha iniciado sesión (true) o no (false)
 * @property user Datos del usuario actual en formato DTO, o null si no hay usuario autenticado
 */
data class SessionDto(
    val isLoggedIn: Boolean = false,
    val user: UserDto? = null
)
