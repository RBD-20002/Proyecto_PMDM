package com.example.pmdm.ui.state

data class LoginPageState(
    val userName: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoginEnabled: Boolean = false,
    val usernameError: String? = null,
    val passwordError: String? = null,
    val loginError: String? = null,
    val rememberCredentials: Boolean = false
)
