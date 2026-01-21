package com.example.pmdm.ui.state

data class AuthState(
    val isLoggedIn: Boolean = false,
    val userEmail: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)