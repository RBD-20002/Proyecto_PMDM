package com.example.pmdm.state

import com.example.pmdm.model.CardConfig

data class DetailsPageState(
    val anime: CardConfig,
    val isFavorite: Boolean = false
)
