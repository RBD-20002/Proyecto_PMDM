package com.example.pmdm.viewModel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdm.data.network.ApiConfig
import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.data.repository.ImageRepository
import com.example.pmdm.data.repository.UpdateProfileResult
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.model.User
import com.example.pmdm.ui.state.ProfilePageState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

/**
 * ViewModel para la pantalla de perfil que gestiona la información del usuario,
 * imágenes de perfil, favoritos y edición de datos. Utiliza Hilt para la inyección de dependencias.
 *
 * @property userRepository Repositorio que maneja las operaciones de usuario
 * @property animeRepository Repositorio que maneja las operaciones relacionadas con animes
 * @property imageRepository Repositorio que maneja las operaciones relacionadas con imágenes
 * @property appContext Contexto de aplicación para operaciones de archivos
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val animeRepository: AnimeRepository,
    private val imageRepository: ImageRepository,
    @ApplicationContext private val appContext: Context
) : ViewModel() {

    private val _state = MutableStateFlow(ProfilePageState())
    val state: StateFlow<ProfilePageState> = _state.asStateFlow()

    /** Lista de IDs de imágenes de perfil predefinidas disponibles para selección. */
    val presetProfileImageIds: List<String> = listOf(
        "avatar1","avatar2","avatar3","avatar4","avatar5","avatar6","avatar7"
    )

    /** Inicializador que carga automáticamente el perfil al crear el ViewModel. */
    init { loadProfile() }

    /**
     * Carga la información del perfil desde los repositorios y actualiza el estado.
     * Incluye datos del usuario, favoritos e imagen de perfil.
     */
    fun loadProfile() {
        val session = userRepository.session.value
        val safeProfileImageId = session.user?.profileImageId?.toString().orEmpty()

        _state.update { current ->
            current.copy(
                user = session.user?.let { User(username = it.username, email = it.email, password = it.password) },
                userId = session.user?.id.orEmpty(),
                isLoggedIn = session.isLoggedIn,
                favorites = animeRepository.getFavorites(),
                profileImageId = safeProfileImageId.ifBlank { current.profileImageId },
                profileImageUri = current.profileImageUri,
                error = null
            )
        }
    }

    /*---------- Mensajes ----------*/

    /**
     * Muestra un mensaje informativo temporal en la interfaz.
     *
     * @param message Mensaje informativo a mostrar
     */
    private fun showInfo(message: String) {
        viewModelScope.launch {
            _state.update { it.copy(infoMessage = message) }
            delay(2500)
            _state.update { it.copy(infoMessage = null) }
        }
    }

    /*---------- Imagen ----------*/

    /** Abre el selector de imágenes de perfil. */
    fun openImagePicker() { _state.update { it.copy(isImagePickerOpen = true, error = null) } }

    /** Cierra el selector de imágenes de perfil. */
    fun closeImagePicker() { _state.update { it.copy(isImagePickerOpen = false) } }

    /**
     * Construye la URL completa para una imagen de perfil predefinida.
     *
     * @param id Identificador de la imagen predefinida
     * @return URL completa de la imagen
     */
    fun imageUrlForId(id: String): String = "${ApiConfig.BASE_URL}images/$id"

    /**
     * Selecciona una imagen de perfil predefinida y la asigna al usuario.
     *
     * @param presetId ID de la imagen predefinida seleccionada
     */
    fun selectPresetImage(presetId: String) {
        val userId = _state.value.userId
        if (userId.isBlank()) return

        viewModelScope.launch {
            _state.update { it.copy(isSavingImage = true, error = null) }
            try {
                userRepository.updateProfileImageId(userId, presetId)
                _state.update {
                    it.copy(
                        profileImageId = presetId,
                        profileImageUri = null,
                        isSavingImage = false,
                        isImagePickerOpen = false
                    )
                }
                showInfo("Foto de perfil actualizada")
            } catch (e: Exception) {
                _state.update { it.copy(isSavingImage = false, error = e.message ?: "Error guardando imagen") }
            }
        }
    }

    /**
     * Actualiza la imagen de perfil con una foto tomada con la cámara.
     * Sube la imagen al servidor y asocia el ID resultante al usuario.
     *
     * @param uri URI de la imagen capturada
     */
    fun updateProfileImage(uri: Uri?) {
        if (uri == null) return
        val userId = _state.value.userId
        if (userId.isBlank()) return

        viewModelScope.launch {
            _state.update { it.copy(isSavingImage = true, error = null) }
            try {
                val inputStream = appContext.contentResolver.openInputStream(uri)
                    ?: throw IllegalStateException("No se pudo leer la imagen")

                val bytes = inputStream.use { it.readBytes() }
                val requestBody = bytes.toRequestBody("image/jpeg".toMediaTypeOrNull())
                val part = MultipartBody.Part.createFormData(
                    name = "file",
                    filename = "profile_${System.currentTimeMillis()}.jpg",
                    body = requestBody
                )

                val uploadResp = imageRepository.uploadImage(part)
                val imageId = uploadResp.resolvedId()
                if (imageId.isBlank()) throw IllegalStateException("La API no devolvió un id de imagen válido")

                userRepository.updateProfileImageId(userId, imageId)

                _state.update {
                    it.copy(
                        profileImageUri = uri,
                        profileImageId = imageId,
                        isSavingImage = false,
                        isImagePickerOpen = false
                    )
                }
                showInfo("Foto de perfil actualizada")
            } catch (e: Exception) {
                _state.update { it.copy(isSavingImage = false, error = e.message ?: "Error subiendo imagen") }
            }
        }
    }

    /*---------- Editar datos usuario/email ----------*/

    /** Abre el diálogo de edición de datos del perfil con los valores actuales. */
    fun openEditDialog() {
        val u = _state.value.user
        _state.update {
            it.copy(
                isEditDialogOpen = true,
                editUsername = u?.username.orEmpty(),
                editEmail = u?.email.orEmpty(),
                editError = null
            )
        }
    }

    /** Cierra el diálogo de edición de datos del perfil. */
    fun closeEditDialog() {
        _state.update { it.copy(isEditDialogOpen = false, editError = null) }
    }

    /**
     * Actualiza el nombre de usuario en el estado de edición.
     *
     * @param value Nuevo valor para el nombre de usuario
     */
    fun onEditUsernameChange(value: String) {
        _state.update { it.copy(editUsername = value, editError = null) }
    }

    /**
     * Actualiza el email en el estado de edición.
     *
     * @param value Nuevo valor para el email
     */
    fun onEditEmailChange(value: String) {
        _state.update { it.copy(editEmail = value, editError = null) }
    }

    /**
     * Guarda los cambios realizados en los datos del perfil.
     * Realiza validaciones y actualiza el servidor.
     */
    fun saveProfileDataEdits() {
        val userId = _state.value.userId
        if (userId.isBlank()) {
            _state.update { it.copy(editError = "No hay usuario en sesión") }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isSavingProfileData = true, editError = null) }

            when (val result = userRepository.updateUserBasicData(
                userId = userId,
                newUsernameRaw = _state.value.editUsername,
                newEmailRaw = _state.value.editEmail
            )) {
                is UpdateProfileResult.Success -> {
                    loadProfile()
                    _state.update { it.copy(isSavingProfileData = false, isEditDialogOpen = false, editError = null) }
                    showInfo("Datos actualizados correctamente")
                }
                is UpdateProfileResult.UsernameAlreadyExists ->
                    _state.update { it.copy(isSavingProfileData = false, editError = "El usuario ya existe") }

                is UpdateProfileResult.EmailAlreadyExists ->
                    _state.update { it.copy(isSavingProfileData = false, editError = "El email ya existe") }

                is UpdateProfileResult.ValidationError ->
                    _state.update { it.copy(isSavingProfileData = false, editError = result.message) }

                is UpdateProfileResult.NetworkError ->
                    _state.update { it.copy(isSavingProfileData = false, editError = result.message ?: "Error de conexión") }

                is UpdateProfileResult.NotLoggedIn ->
                    _state.update { it.copy(isSavingProfileData = false, editError = "No has iniciado sesión") }
            }
        }
    }
}