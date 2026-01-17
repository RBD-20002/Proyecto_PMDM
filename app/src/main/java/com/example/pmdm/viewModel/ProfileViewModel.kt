package com.example.pmdm.viewModel

import androidx.lifecycle.ViewModel
import com.example.pmdm.model.DataProvider
import com.example.pmdm.model.User
import com.example.pmdm.state.ProfilePageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfilePageState())
    val state: StateFlow<ProfilePageState> = _state.asStateFlow()

    init {
        loadProfile()
    }

    fun loadProfile() {
        _state.update {
            it.copy(
                user = User("NicoDev", "nico@example.com"),
                isLoggedIn = true,
                favorites = DataProvider.getListFavoriteAnime()
            )
        }
    }
}
