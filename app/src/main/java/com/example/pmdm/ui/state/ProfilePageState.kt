package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime
import com.example.pmdm.model.User

data class ProfilePageState(
    val user: User? = null,
    val isLoggedIn: Boolean = false,
    val favorites: List<Anime> = emptyList()
)
