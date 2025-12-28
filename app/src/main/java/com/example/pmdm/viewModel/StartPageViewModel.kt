package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Components.CardConfig
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StartPageViewModel : ViewModel() {

    private val _animeList = MutableStateFlow(value = DataProvider.animeList)
    val animeList: StateFlow<List<CardConfig>> = _animeList.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        _animeList.value = if (query.isBlank()) {
            DataProvider.animeList
        } else {
            DataProvider.animeList.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
}
