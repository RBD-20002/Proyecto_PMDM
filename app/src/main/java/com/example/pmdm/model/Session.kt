package com.example.pmdm.model

/**
 * Clase de datos que representa el estado de sesión actual del usuario en la aplicación.
 * Contiene información sobre si el usuario ha iniciado sesión y los datos del usuario autenticado.
 *
 * @property isLoggedIn Estado booleano que indica si hay un usuario autenticado (true) o no (false)
 * @property user Objeto User que contiene los datos del usuario autenticado, o null si no hay sesión activa
 */
data class Session(
    val isLoggedIn: Boolean = false,
    val user: User? = null
)