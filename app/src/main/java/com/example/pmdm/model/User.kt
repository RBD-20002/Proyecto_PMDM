package com.example.pmdm.model

data class User(
    val username: String,
    val email: String,
    val role: String = "Guest",
    val profileImageId: Int? = null
)
