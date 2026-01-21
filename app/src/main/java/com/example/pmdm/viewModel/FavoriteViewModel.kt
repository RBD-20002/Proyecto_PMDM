package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.ui.state.FavoritePageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoriteViewModel : ViewModel() {

    private val _state = MutableStateFlow(FavoritePageState())
    val state: StateFlow<FavoritePageState> = _state.asStateFlow()

    init {
        loadFavorites()
    }

    fun loadFavorites() {
        val list = DataProvider.getListFavoriteAnime()
        _state.update {
            it.copy(
                favorites = list,
                isEmpty = list.isEmpty()
            )
        }
    }
}
