package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.SessionDto
import com.example.pmdm.data.dto.UserDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class UserRepository {
    private val _session = MutableStateFlow(SessionDto(isLoggedIn = false, user = null))
    val session: StateFlow<SessionDto> = _session

    fun login(username: String, email: String, password: String) {
        val user = UserDto(
            id = UUID.randomUUID().toString(),
            username = username,
            email = email,
            password = password,
            profileImageId = null
        )
        _session.value = SessionDto(isLoggedIn = true, user = user)
    }

    fun loginAsGuest() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }

    fun register(username: String, email: String, password: String) {
        login(username, email, password)
    }

    fun logout() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }
}
