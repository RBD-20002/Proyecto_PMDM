package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime

data class DetailsPageState(
    val anime: Anime,
    val isFavorite: Boolean = false
)
