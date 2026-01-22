package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.ui.state.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    fun onQueryChange(query: String) {
        _state.update {
            it.copy(
                query = query,
                isActive = query.isNotBlank() || it.isActive // ← Mantiene activo si ya estaba
            )
        }
    }

    // NUEVO: Método para activar/desactivar explícitamente
    fun toggleSearch(active: Boolean) {
        _state.update {
            it.copy(
                isActive = active,
                query = if (!active) "" else it.query // Limpia query al desactivar
            )
        }
    }

    // NUEVO: Para activar solo (click en lupa)
    fun activateSearch() {
        _state.update {
            it.copy(isActive = true)
        }
    }

    // NUEVO: Para desactivar (cerrar búsqueda)
    fun deactivateSearch() {
        _state.update {
            it.copy(isActive = false, query = "")
        }
    }
}