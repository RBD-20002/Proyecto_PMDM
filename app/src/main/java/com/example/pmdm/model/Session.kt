package com.example.pmdm.model

data class Session(
    val isLoggedIn: Boolean = false,
    val user: User? = null
)
