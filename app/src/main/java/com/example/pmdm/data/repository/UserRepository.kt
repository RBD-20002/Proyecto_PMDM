package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.CreateUserRequestDto
import com.example.pmdm.data.dto.SessionDto
import com.example.pmdm.data.dto.UserDto
import com.example.pmdm.data.service.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userService: UserService,
    private val preferencesRepository: PreferencesRepository
) {
    private val _session = MutableStateFlow(SessionDto(isLoggedIn = false, user = null))
    val session: StateFlow<SessionDto> = _session

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val userId = preferencesRepository.loggedInUserIdFlow.first()
            if (userId != null) {
                try {
                    val users = userService.searchUsers(field = "id", value = userId)
                    val user = users.firstOrNull()
                    if (user != null) {
                        val sanitized = user.copy(favoriteAnimes = user.favoriteAnimes ?: emptyList())
                        _session.value = SessionDto(isLoggedIn = true, user = sanitized)
                    }
                } catch (_: Exception) {
                    // Ignorar error de red y mantener la sesión cerrada
                }
            }
        }
    }

    private fun normalizeUsername(input: String): String =
        input.trim().lowercase(Locale.ROOT)

    private fun normalizeEmail(input: String): String =
        input.trim().lowercase(Locale.ROOT)

    private fun normalizePassword(input: String): String =
        input.trim()

    suspend fun login(username: String, password: String): LoginResult {
        val normalizedUser = normalizeUsername(username)
        val normalizedPass = normalizePassword(password)

        return try {
            val users = userService.searchUsers(field = "userName", value = normalizedUser)
            val user = users.firstOrNull() ?: return LoginResult.UserNotFound

            if (normalizePassword(user.password) != normalizedPass) return LoginResult.WrongPassword

            val sanitized = user.copy(favoriteAnimes = user.favoriteAnimes ?: emptyList())
            _session.value = SessionDto(isLoggedIn = true, user = sanitized)
            preferencesRepository.saveUserId(sanitized.id)

            LoginResult.Success
        } catch (e: Exception) {
            LoginResult.NetworkError(e.message)
        }
    }

    suspend fun register(username: String, email: String, password: String): RegisterResult {
        val normalizedUser = normalizeUsername(username)
        val normalizedEmail = normalizeEmail(email)
        val normalizedPass = normalizePassword(password)

        return try {
            val exists = userService.searchUsers(field = "userName", value = normalizedUser)
            if (exists.isNotEmpty()) return RegisterResult.UsernameAlreadyExists

            val resp = userService.createUser(
                request = CreateUserRequestDto(
                    username = normalizedUser,
                    email = normalizedEmail,
                    password = normalizedPass,
                    profileImageId = ""
                )
            )

            val createdUser = UserDto(
                id = resp.id,
                username = normalizedUser,
                email = normalizedEmail,
                password = normalizedPass,
                profileImageId = "",
                favoriteAnimes = emptyList()
            )

            _session.value = SessionDto(isLoggedIn = true, user = createdUser)
            preferencesRepository.saveUserId(createdUser.id)
            RegisterResult.Success
        } catch (e: Exception) {
            RegisterResult.NetworkError(e.message)
        }
    }

    suspend fun updateProfileImageId(userId: String, newProfileImageId: String?) {
        val current = _session.value.user
            ?: throw IllegalStateException("No hay usuario en sesión")

        val safeNewId = newProfileImageId?.trim().orEmpty()

        val updated = current.copy(profileImageId = safeNewId)

        userService.updateUser(id = userId, user = updated)

        _session.value = _session.value.copy(user = updated, isLoggedIn = true)
    }

    suspend fun updateUserBasicData(userId: String, newUsernameRaw: String, newEmailRaw: String): UpdateProfileResult {
        val current = _session.value.user ?: return UpdateProfileResult.NotLoggedIn

        val newUsername = normalizeUsername(newUsernameRaw)
        val newEmail = normalizeEmail(newEmailRaw)

        if (newUsername.isBlank() || newEmail.isBlank()) return UpdateProfileResult.ValidationError("No se pueden dejar campos en blanco")

        return try {
            val sameUsername = userService.searchUsers(field = "userName", value = newUsername)
                .any { it.id != userId }
            if (sameUsername) return UpdateProfileResult.UsernameAlreadyExists

            val sameEmail = userService.searchUsers(field = "email", value = newEmail)
                .any { it.id != userId }
            if (sameEmail) return UpdateProfileResult.EmailAlreadyExists

            val updated = current.copy(username = newUsername, email = newEmail)

            userService.updateUser(id = userId, user = updated)

            _session.value = _session.value.copy(user = updated, isLoggedIn = true)

            UpdateProfileResult.Success
        } catch (e: Exception) {
            UpdateProfileResult.NetworkError(e.message)
        }
    }

    fun updateUserInSession(user: UserDto) {
        _session.value = _session.value.copy(user = user)
    }

    fun loginAsGuest() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
        CoroutineScope(Dispatchers.IO).launch {
            preferencesRepository.clearSession()
        }
    }

    fun logout() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
        CoroutineScope(Dispatchers.IO).launch {
            preferencesRepository.clearSession()
        }
    }
}

sealed class UpdateProfileResult {
    data object Success : UpdateProfileResult()
    data object UsernameAlreadyExists : UpdateProfileResult()
    data object EmailAlreadyExists : UpdateProfileResult()
    data object NotLoggedIn : UpdateProfileResult()
    data class ValidationError(val message: String) : UpdateProfileResult()
    data class NetworkError(val message: String?) : UpdateProfileResult()
}
