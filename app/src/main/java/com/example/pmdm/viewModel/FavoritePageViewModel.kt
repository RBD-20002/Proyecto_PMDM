package com.example.pmdm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pmdm.Components.CardConfig
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FavoritePageViewModel : ViewModel() {

    private val _favoriteList = MutableStateFlow(DataProvider.getListFavoriteAnime())
    val favoriteList: StateFlow<List<CardConfig>> = _favoriteList.asStateFlow()

    fun refreshFavorites() {
        _favoriteList.value = DataProvider.getListFavoriteAnime()
    }
}
