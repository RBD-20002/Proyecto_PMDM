package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.ui.state.StartPageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para la pantalla de inicio que gestiona la carga y estado
 * de la lista de animes. Utiliza Hilt para la inyección de dependencias.
 *
 * @property animeRepository Repositorio que maneja las operaciones relacionadas con animes
 */
@HiltViewModel
class StartViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(StartPageState(isLoading = true))
    val state: StateFlow<StartPageState> = _state.asStateFlow()

    /**
     * Inicializador que carga automáticamente los animes al crear el ViewModel.
     */
    init { loadAnimes() }

    /**
     * Carga la lista completa de animes desde el repositorio.
     * Maneja estados de carga y errores durante el proceso.
     */
    fun loadAnimes() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val list = animeRepository.getAnimeList()
                _state.update { it.copy(animeList = list, isLoading = false, error = null) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}