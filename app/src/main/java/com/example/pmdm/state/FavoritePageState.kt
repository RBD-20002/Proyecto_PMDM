package com.example.pmdm.state

import com.example.pmdm.model.CardConfig

data class FavoritePageState(
    val favorites: List<CardConfig> = emptyList(),
    val isEmpty: Boolean = true
)
