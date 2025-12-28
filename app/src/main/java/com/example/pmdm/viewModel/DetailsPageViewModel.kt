package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Components.CardConfig
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsPageViewModel : ViewModel() {

    private val _currentAnimeId = MutableStateFlow<Int?>(null)
    val currentAnimeId: StateFlow<Int?> = _currentAnimeId.asStateFlow()

    fun setAnime(animeId: Int) {
        _currentAnimeId.value = animeId
    }

    fun isFavorite(): Boolean {
        val id = _currentAnimeId.value ?: return false
        return DataProvider.isFavorite(id)
    }

    fun toggleFavorite() {
        _currentAnimeId.value?.let { DataProvider.filterFavorite(it) }
    }
}
