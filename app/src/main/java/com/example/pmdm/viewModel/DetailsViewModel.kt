package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.ui.state.DetailsPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow<DetailsPageState?>(null)
    val state: StateFlow<DetailsPageState?> = _state.asStateFlow()

    fun loadAnime(animeId: Int) {
        val anime = DataProvider.animeList.find { it.id == animeId }
        if (anime != null) {
            _state.value = DetailsPageState(
                anime = anime,
                isFavorite = DataProvider.isFavorite(animeId)
            )
        }
    }

    fun toggleFavorite() {
        _state.update { current ->
            current?.let {
                DataProvider.filterFavorite(it.anime.id)
                it.copy(isFavorite = !it.isFavorite)
            }
        }
    }
}
