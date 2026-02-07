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

/**
 * Repositorio singleton que gestiona todas las operaciones relacionadas con usuarios,
 * incluyendo autenticación, registro, actualización de perfil y gestión de sesiones.
 *
 * @property userService Servicio para realizar llamadas a la API de usuarios
 * @property preferencesRepository Repositorio para acceder a las preferencias persistentes del usuario
 */
@Singleton
class UserRepository @Inject constructor(
    private val userService: UserService,
    private val preferencesRepository: PreferencesRepository
) {
    private val _session = MutableStateFlow(SessionDto(isLoggedIn = false, user = null))
    val session: StateFlow<SessionDto> = _session

    /**
     * Inicializador que restaura la sesión del usuario desde las preferencias almacenadas.
     * Si hay un ID de usuario guardado, intenta recuperar sus datos desde el servidor.
     */
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

    /**
     * Normaliza un nombre de usuario eliminando espacios y convirtiendo a minúsculas.
     *
     * @param input Nombre de usuario en crudo
     * @return Nombre de usuario normalizado
     */
    private fun normalizeUsername(input: String): String =
        input.trim().lowercase(Locale.ROOT)

    /**
     * Normaliza un email eliminando espacios y convirtiendo a minúsculas.
     *
     * @param input Email en crudo
     * @return Email normalizado
     */
    private fun normalizeEmail(input: String): String =
        input.trim().lowercase(Locale.ROOT)

    /**
     * Normaliza una contraseña eliminando solo espacios en los extremos.
     *
     * @param input Contraseña en crudo
     * @return Contraseña normalizada
     */
    private fun normalizePassword(input: String): String =
        input.trim()

    /**
     * Autentica a un usuario utilizando nombre de usuario y contraseña.
     *
     * @param username Nombre de usuario proporcionado
     * @param password Contraseña proporcionada
     * @return Resultado de la operación de inicio de sesión
     */
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

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param username Nombre de usuario deseado
     * @param email Email del usuario
     * @param password Contraseña del usuario
     * @return Resultado de la operación de registro
     */
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

    /**
     * Actualiza el identificador de imagen de perfil del usuario actual.
     *
     * @param userId ID del usuario a actualizar
     * @param newProfileImageId Nuevo identificador de imagen de perfil
     */
    suspend fun updateProfileImageId(userId: String, newProfileImageId: String?) {
        val current = _session.value.user
            ?: throw IllegalStateException("No hay usuario en sesión")

        val safeNewId = newProfileImageId?.trim().orEmpty()

        val updated = current.copy(profileImageId = safeNewId)

        userService.updateUser(id = userId, user = updated)

        _session.value = _session.value.copy(user = updated, isLoggedIn = true)
    }

    /**
     * Actualiza los datos básicos del usuario (nombre de usuario y email).
     *
     * @param userId ID del usuario a actualizar
     * @param newUsernameRaw Nuevo nombre de usuario
     * @param newEmailRaw Nuevo email
     * @return Resultado de la operación de actualización
     */
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

    /**
     * Actualiza los datos del usuario en la sesión actual sin llamar al servidor.
     * Útil para actualizaciones locales como cambios en favoritos.
     *
     * @param user Nuevos datos del usuario
     */
    fun updateUserInSession(user: UserDto) {
        _session.value = _session.value.copy(user = user)
    }

    /**
     * Establece al usuario como invitado (sin autenticación).
     * Elimina cualquier sesión activa y credenciales almacenadas.
     */
    fun loginAsGuest() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
        CoroutineScope(Dispatchers.IO).launch {
            preferencesRepository.clearSession()
        }
    }

    /**
     * Cierra la sesión del usuario actual.
     * Elimina el estado de sesión y las credenciales almacenadas.
     */
    fun logout() {
        _session.value = SessionDto(isLoggedIn = false, user = null)
        CoroutineScope(Dispatchers.IO).launch {
            preferencesRepository.clearSession()
        }
    }
}

/**
 * Resultado sellado que representa los posibles resultados de una operación de actualización de perfil.
 * Maneja todos los casos posibles durante la modificación de datos de usuario.
 */
sealed class UpdateProfileResult {

    /** Actualización de perfil exitosa. */
    data object Success : UpdateProfileResult()

    /** El nombre de usuario ya existe en el sistema. */
    data object UsernameAlreadyExists : UpdateProfileResult()

    /** El email ya existe en el sistema. */
    data object EmailAlreadyExists : UpdateProfileResult()

    /** No hay usuario autenticado para actualizar. */
    data object NotLoggedIn : UpdateProfileResult()

    /** Error de validación en los datos proporcionados. */
    data class ValidationError(val message: String) : UpdateProfileResult()

    /** Error de red o conexión durante la actualización. */
    data class NetworkError(val message: String?) : UpdateProfileResult()
}