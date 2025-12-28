package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Anime
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(StartUiState())
    val uiState: StateFlow<StartUiState> = _uiState.asStateFlow()

    init {
        loadAnimes()
    }

    private fun loadAnimes() {
        // Convertir CardConfig a Anime
        val allAnimes = DataProvider.animeList.map { cardConfig ->
            Anime(
                id = cardConfig.id,
                title = cardConfig.title,
                synopsis = cardConfig.synopsis,
                info = cardConfig.info,
                imageId = cardConfig.imageId,
                imageDesc = cardConfig.imageDesc,
                enlace1 = cardConfig.enlace1,
                enlace2 = cardConfig.enlace2,
                isPopular = cardConfig.id % 3 == 0,  // Lógica temporal
                isRecommended = cardConfig.id % 4 == 0,
                isFavorite = DataProvider.isFavorite(cardConfig.id)
            )
        }

        val popularAnimes = allAnimes.filter { it.isPopular }
        val recommendedAnimes = allAnimes.filter { it.isRecommended }

        _uiState.update {
            it.copy(
                popularAnimes = popularAnimes,
                recommendedAnimes = recommendedAnimes,
                isLoading = false
            )
        }
    }

    fun updateFavoriteStatus(animeId: Int, isFavorite: Boolean) {
        _uiState.update { currentState ->
            val updatedPopular = currentState.popularAnimes.map { anime ->
                if (anime.id == animeId) anime.copy(isFavorite = isFavorite) else anime
            }
            val updatedRecommended = currentState.recommendedAnimes.map { anime ->
                if (anime.id == animeId) anime.copy(isFavorite = isFavorite) else anime
            }

            currentState.copy(
                popularAnimes = updatedPopular,
                recommendedAnimes = updatedRecommended
            )
        }
    }
}

data class StartUiState(
    val popularAnimes: List<Anime> = emptyList(),
    val recommendedAnimes: List<Anime> = emptyList(),
    val isLoading: Boolean = true
)