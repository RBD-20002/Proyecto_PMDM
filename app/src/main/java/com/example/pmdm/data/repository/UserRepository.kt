package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.CreateUserRequestDto
import com.example.pmdm.data.dto.SessionDto
import com.example.pmdm.data.dto.UserDto
import com.example.pmdm.data.service.UserService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {
    private val _session = MutableStateFlow(SessionDto(isLoggedIn = false, user = null))
    val session: StateFlow<SessionDto> = _session

    suspend fun login(username: String, password: String): LoginResult {
        return try {
            val users = userService.searchUsers(field = "userName", value = username)
            val user = users.firstOrNull() ?: return LoginResult.UserNotFound

            if (user.password != password) return LoginResult.WrongPassword

            _session.value = SessionDto(isLoggedIn = true, user = user)
            LoginResult.Success
        } catch (e: Exception) {
            LoginResult.NetworkError(e.message)
        }
    }

    suspend fun register(username: String, email: String, password: String): RegisterResult {
        return try {
            val exists = userService.searchUsers(field = "userName", value = username)
            if (exists.isNotEmpty()) return RegisterResult.UsernameAlreadyExists

            val resp = userService.createUser(
                request = CreateUserRequestDto(
                    email = email,
                    password = password,
                    username = username
                )
            )

            val createdUser = UserDto(
                id = resp.id,
                username = username,
                email = email,
                password = password,
                profileImageId = null
            )
            _session.value = SessionDto(isLoggedIn = true, user = createdUser)

            RegisterResult.Success
        } catch (e: Exception) {
            RegisterResult.NetworkError(e.message)
        }
    }

    fun loginAsGuest() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }

    fun logout() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }
}
