package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.ui.state.DetailsPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsPageState?>(null)
    val state: StateFlow<DetailsPageState?> = _state.asStateFlow()

    fun loadAnime(animeId: String) {
        viewModelScope.launch {
            try {
                val anime = animeRepository.getAnimeById(animeId)
                val isFav = animeRepository.isFavorite(animeId)
                _state.value = DetailsPageState(anime = anime, isFavorite = isFav)
            } catch (_: Exception) {
                _state.value = null
            }
        }
    }

    fun toggleFavorite() {
        _state.update { current ->
            current?.let {
                animeRepository.toggleFavorite(it.anime)
                it.copy(isFavorite = !it.isFavorite)
            }
        }
    }
}
