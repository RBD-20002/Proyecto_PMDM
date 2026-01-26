package com.example.pmdm.data.repository

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

    // ✅ LOGIN REAL: busca en API por email y valida password
    suspend fun login(email: String, password: String): Boolean {
        val users = userService.searchUsers(field = "email", value = email)
        val user = users.firstOrNull()

        return if (user != null && user.password == password) {
            _session.value = SessionDto(isLoggedIn = true, user = user)
            true
        } else {
            _session.value = SessionDto(isLoggedIn = false, user = null)
            false
        }
    }


    fun loginAsGuest() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }

    // ⚠️ REGISTER depende de si tu API permite crear/guardar users.
    // Si la API tiene endpoint de "create json", aquí se implementa.
    // Si no, deja esto como stub o solo login local.
//    suspend fun register(username: String, email: String, password: String): Boolean {
//        // Opción 1 (si tu API permite crear): llamar a createUser(...)
//        // Opción 2 (si no): no se puede registrar realmente en backend
//        // Por ahora: intento simple -> si ya existe, falla; si no existe, no puedo crearlo sin endpoint.
//
//        val exists = userService.searchUsers(field = "email", value = email).isNotEmpty()
//        return if (exists) {
//            false
//        } else {
//            // Aquí iría la llamada real a crear usuario en API.
//            false
//        }
//    }

    fun logout() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
    }
}
