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

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    fun onQueryChange(query: String) {
        _state.update {
            it.copy(
                query = query,
                isActive = query.isNotBlank() || it.isActive
            )
        }
        performSearch(query)
    }

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

    fun toggleSearch(active: Boolean) {
        _state.update {
            it.copy(
                isActive = active,
                query = if (!active) "" else it.query,
                results = if (!active) emptyList() else it.results
            )
        }
    }

    fun activateSearch() {
        _state.update { it.copy(isActive = true) }
    }

    fun deactivateSearch() {
        _state.update { it.copy(isActive = false, query = "", results = emptyList()) }
    }
}