package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Components.CardConfig
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoritesViewModel : ViewModel() {

    private val _favorites = MutableStateFlow(value = DataProvider.favoriteAnime.toSet())
    val favorites: StateFlow<Set<Int>> = _favorites.asStateFlow()

    fun toggleFavorite(animeId: Int) {
        _favorites.update { current ->
            current.toMutableSet().apply {
                if (contains(animeId)) remove(animeId) else add(animeId)
            }
        }
        DataProvider.filterFavorite(animeId)
    }

    fun isFavorite(animeId: Int): Boolean {
        return _favorites.value.contains(animeId)
    }

    fun getFavoriteList(): List<CardConfig> {
        return DataProvider.getListFavoriteAnime()
    }
}
