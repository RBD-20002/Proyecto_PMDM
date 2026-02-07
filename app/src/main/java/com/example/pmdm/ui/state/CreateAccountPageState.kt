package com.example.pmdm.ui.state

/**
 * Clase de datos que representa el estado de la pantalla de creación de cuenta.
 * Contiene todos los valores de los campos de entrada, estados de visibilidad y resultados de operaciones.
 *
 * @property username Nombre de usuario ingresado por el usuario
 * @property email Dirección de email ingresada por el usuario
 * @property password Contraseña ingresada por el usuario
 * @property repeatPassword Confirmación de contraseña ingresada por el usuario
 * @property passwordVisible Indica si la contraseña principal es visible (true) u oculta (false)
 * @property repeatPasswordVisible Indica si la confirmación de contraseña es visible (true) u oculta (false)
 * @property error Mensaje de error relacionado con la creación de cuenta, o null si no hay error
 * @property success Indica si la creación de cuenta fue exitosa
 */
data class CreateAccountPageState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",

    val passwordVisible: Boolean = false,
    val repeatPasswordVisible: Boolean = false,

    val error: String? = null,
    val success: Boolean = false
)