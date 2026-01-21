package com.example.pmdm.ui.state

data class LoginPageState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoginEnabled: Boolean = false,
    val loginError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null
)
