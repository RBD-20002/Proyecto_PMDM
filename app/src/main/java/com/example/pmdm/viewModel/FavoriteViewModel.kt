package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.ui.state.FavoritePageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * ViewModel para la pantalla de favoritos que gestiona la carga y actualización
 * de la lista de animes marcados como favoritos por el usuario.
 * Utiliza Hilt para la inyección de dependencias.
 *
 * @property animeRepository Repositorio que maneja las operaciones relacionadas con animes
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(FavoritePageState())
    val state: StateFlow<FavoritePageState> = _state.asStateFlow()


    /**
     * Inicializador que carga automáticamente los favoritos al crear el ViewModel.
     */
    init { loadFavorites() }

    /**
     * Carga la lista de animes favoritos desde el repositorio y actualiza el estado.
     * Determina si la lista está vacía para mostrar el mensaje correspondiente.
     */
    fun loadFavorites() {
        val list = animeRepository.getFavorites()
        _state.update { it.copy(favorites = list, isEmpty = list.isEmpty()) }
    }
}