package com.example.pmdm.model

data class LoginCredentials(
    val username: String = "",
    val password: String = "",
    val remember: Boolean = false
)
