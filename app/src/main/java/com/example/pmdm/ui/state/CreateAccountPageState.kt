package com.example.pmdm.ui.state

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
