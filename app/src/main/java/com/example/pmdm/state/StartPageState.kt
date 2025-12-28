package com.example.pmdm.state

import com.example.pmdm.model.CardConfig

data class StartPageState(
    val animeList: List<CardConfig> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
