package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.Anime
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    fun loadAnime(animeId: Int) {
        _uiState.update { it.copy(isLoading = true) }

        val cardConfig = DataProvider.animeList.find { it.id == animeId }

        if (cardConfig != null) {
            val isFavorite = DataProvider.isFavorite(animeId)

            val anime = Anime(
                id = cardConfig.id,
                title = cardConfig.title,
                synopsis = cardConfig.synopsis,
                info = cardConfig.info,
                imageId = cardConfig.imageId,
                imageDesc = cardConfig.imageDesc,
                enlace1 = cardConfig.enlace1,
                enlace2 = cardConfig.enlace2,
                isFavorite = isFavorite
            )

            _uiState.update {
                it.copy(
                    anime = anime,
                    isLoading = false,
                    errorMessage = null
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = "Anime no encontrado"
                )
            }
        }
    }

    fun toggleFavorite() {
        _uiState.update { currentState ->
            currentState.anime?.let { anime ->
                val newFavoriteStatus = !anime.isFavorite
                DataProvider.filterFavorite(anime.id)

                val updatedAnime = anime.copy(isFavorite = newFavoriteStatus)
                val message = if (newFavoriteStatus) {
                    "${anime.title} añadido a favoritos"
                } else {
                    "${anime.title} eliminado de favoritos"
                }

                currentState.copy(
                    anime = updatedAnime,
                    showSnackbar = true,
                    snackbarMessage = message
                )
            } ?: currentState
        }
    }

    fun snackbarShown() {
        _uiState.update { it.copy(showSnackbar = false) }
    }
}

data class DetailsUiState(
    val anime: Anime? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val showSnackbar: Boolean = false,
    val snackbarMessage: String = ""
)