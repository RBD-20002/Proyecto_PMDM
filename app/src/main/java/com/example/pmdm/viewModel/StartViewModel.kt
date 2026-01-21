package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.ui.state.StartPageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StartViewModel : ViewModel() {

    private val _state = MutableStateFlow(StartPageState())
    val state: StateFlow<StartPageState> = _state.asStateFlow()

    init {
        loadAnimes()
    }

    public fun loadAnimes() {
        _state.update {
            it.copy(
                animeList = DataProvider.animeList,
                isLoading = false,
                error = null
            )
        }
    }
}
