package com.example.pmdm.ui.state

data class LoginPageState(
    val userName: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoginEnabled: Boolean = false,
    val loginError: String? = null,
    val usernameError: String? = null,
    val passwordError: String? = null
)
