package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.ui.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para la funcionalidad de búsqueda que gestiona el estado
 * de búsqueda, realiza consultas al repositorio y mantiene los resultados.
 * Utiliza Hilt para la inyección de dependencias.
 *
 * @property animeRepository Repositorio que maneja las operaciones relacionadas con animes
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    /**
     * Actualiza la consulta de búsqueda y activa automáticamente la búsqueda si hay texto.
     *
     * @param query Nueva consulta de búsqueda ingresada por el usuario
     */
    fun onQueryChange(query: String) {
        _state.update {
            it.copy(
                query = query,
                isActive = query.isNotBlank() || it.isActive
            )
        }
        performSearch(query)
    }

    /**
     * Realiza la búsqueda de animes basada en la consulta proporcionada.
     * Si la consulta está vacía, limpia los resultados.
     *
     * @param query Texto de búsqueda para filtrar animes
     */
    private fun performSearch(query: String) {
        if (query.isBlank()) {
            _state.update { it.copy(results = emptyList()) }
            return
        }
        viewModelScope.launch {
            try {
                val resultList = animeRepository.searchAnimes(query).map { it.title }
                _state.update { it.copy(results = resultList) }
            } catch (_: Exception) {
            }
        }
    }

    /**
     * Alterna el estado activo de la búsqueda.
     *
     * @param active Nuevo estado de activación (true = activo, false = inactivo)
     */
    fun toggleSearch(active: Boolean) {
        _state.update {
            it.copy(
                isActive = active,
                query = if (!active) "" else it.query,
                results = if (!active) emptyList() else it.results
            )
        }
    }

    /**
     * Activa el componente de búsqueda para comenzar a buscar.
     */
    fun activateSearch() {
        _state.update { it.copy(isActive = true) }
    }

    /**
     * Desactiva el componente de búsqueda y limpia todos los datos.
     */
    fun deactivateSearch() {
        _state.update { it.copy(isActive = false, query = "", results = emptyList()) }
    }
}