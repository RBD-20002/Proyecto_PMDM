package com.example.pmdm.ui.state

data class CreateAccountPageState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val error: String? = null,
    val success: Boolean = false
)