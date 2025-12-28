package com.example.pmdm.state

import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.User

data class ProfilePageState(
    val user: User? = null,
    val isLoggedIn: Boolean = false,
    val favorites: List<CardConfig> = emptyList()
)
