package com.example.pmdm.data.repository

/**
 * Resultado sellado que representa los posibles resultados de un intento de inicio de sesión.
 * Proporciona un manejo exhaustivo de todos los casos posibles en la autenticación.
 */
sealed class LoginResult {

    /** Inicio de sesión exitoso. */
    data object Success : LoginResult()

    /** El usuario no existe en el sistema. */
    data object UserNotFound : LoginResult()

    /** La contraseña proporcionada es incorrecta. */
    data object WrongPassword : LoginResult()

    /** Error de red o conexión durante el proceso de inicio de sesión. */
    data class NetworkError(val message: String? = null) : LoginResult()
}

/**
 * Resultado sellado que representa los posibles resultados de un intento de registro de usuario.
 * Maneja todos los casos posibles durante el proceso de creación de una nueva cuenta.
 */
sealed class RegisterResult {

    /** Registro de usuario exitoso. */
    data object Success : RegisterResult()

    /** El nombre de usuario ya existe en el sistema. */
    data object UsernameAlreadyExists : RegisterResult()

    /** Error de red o conexión durante el proceso de registro. */
    data class NetworkError(val message: String? = null) : RegisterResult()
}