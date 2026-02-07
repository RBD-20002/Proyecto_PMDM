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

/**
 * ViewModel para la pantalla de detalles de anime que gestiona la carga de información
 * y la funcionalidad de favoritos. Utiliza Hilt para la inyección de dependencias.
 *
 * @property animeRepository Repositorio que maneja las operaciones relacionadas con animes
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsPageState?>(null)
    val state: StateFlow<DetailsPageState?> = _state.asStateFlow()

    /**
     * Carga los detalles de un anime específico desde el repositorio.
     * Incluye información del anime y su estado de favorito para el usuario actual.
     *
     * @param animeId Identificador único del anime a cargar
     */
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

    /**
     * Alterna el estado de favorito del anime actual.
     * Actualiza tanto el repositorio como el estado local de la vista.
     */
    fun toggleFavorite() {
        viewModelScope.launch {
            _state.update { current ->
                current?.let {
                    animeRepository.toggleFavorite(it.anime)
                    it.copy(isFavorite = !it.isFavorite)
                }
            }
        }
    }
}