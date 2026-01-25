package com.example.pmdm.model

data class User(
    var id: String? = null,
    val username: String,
    val email: String,
    val password: String,
    val profileImageId: Int? = null
)
