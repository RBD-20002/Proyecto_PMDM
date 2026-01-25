package com.example.pmdm.ui.state

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.model.Anime

data class StartPageState(
    val animeList: List<Anime> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
