package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Anime
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoritesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        _uiState.update { it.copy(isLoading = true) }

        val favoriteIds = DataProvider.favoriteAnime.toList()

        if (favoriteIds.isEmpty()) {
            _uiState.update {
                it.copy(
                    favorites = emptyList(),
                    isLoading = false,
                    isEmpty = true
                )
            }
        } else {
            val favoriteAnimes = DataProvider.animeList
                .filter { cardConfig -> favoriteIds.contains(cardConfig.id) }
                .map { cardConfig ->
                    Anime(
                        id = cardConfig.id,
                        title = cardConfig.title,
                        synopsis = cardConfig.synopsis,
                        info = cardConfig.info,
                        imageId = cardConfig.imageId,
                        imageDesc = cardConfig.imageDesc,
                        enlace1 = cardConfig.enlace1,
                        enlace2 = cardConfig.enlace2,
                        isFavorite = true
                    )
                }

            _uiState.update {
                it.copy(
                    favorites = favoriteAnimes,
                    isLoading = false,
                    isEmpty = false
                )
            }
        }
    }

    fun onFavoriteUpdated(animeId: Int, isFavorite: Boolean) {
        _uiState.update { currentState ->
            if (isFavorite) {
                // Añadir a favoritos
                DataProvider.animeList.find { it.id == animeId }?.let { cardConfig ->
                    val newAnime = Anime(
                        id = cardConfig.id,
                        title = cardConfig.title,
                        synopsis = cardConfig.synopsis,
                        info = cardConfig.info,
                        imageId = cardConfig.imageId,
                        imageDesc = cardConfig.imageDesc,
                        enlace1 = cardConfig.enlace1,
                        enlace2 = cardConfig.enlace2,
                        isFavorite = true
                    )

                    currentState.copy(
                        favorites = currentState.favorites + newAnime,
                        isEmpty = false
                    )
                } ?: currentState
            } else {
                // Eliminar de favoritos
                val updatedFavorites = currentState.favorites.filter { it.id != animeId }
                currentState.copy(
                    favorites = updatedFavorites,
                    isEmpty = updatedFavorites.isEmpty()
                )
            }
        }
    }
}

data class FavoritesUiState(
    val favorites: List<Anime> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false
)