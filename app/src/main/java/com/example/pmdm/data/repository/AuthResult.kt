package com.example.pmdm.data.repository

sealed class LoginResult {
    data object Success : LoginResult()
    data object UserNotFound : LoginResult()
    data object WrongPassword : LoginResult()
    data class NetworkError(val message: String? = null) : LoginResult()
}

sealed class RegisterResult {
    data object Success : RegisterResult()
    data object UsernameAlreadyExists : RegisterResult()
    data class NetworkError(val message: String? = null) : RegisterResult()
}
