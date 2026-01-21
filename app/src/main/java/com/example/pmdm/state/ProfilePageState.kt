package com.example.pmdm.state

import android.net.Uri
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.User

data class ProfilePageState(
    val user: User? = null,
    val isLoggedIn: Boolean = false,
    val favorites: List<CardConfig> = emptyList(),
    val profileImageUri: Uri? = null
)
