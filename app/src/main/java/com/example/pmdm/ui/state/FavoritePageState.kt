package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime

data class FavoritePageState(
    val favorites: List<Anime> = emptyList(),
    val isEmpty: Boolean = true
)
