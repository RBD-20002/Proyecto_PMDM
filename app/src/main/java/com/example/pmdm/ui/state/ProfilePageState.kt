package com.example.pmdm.ui.state

import android.net.Uri
import com.example.pmdm.model.Anime
import com.example.pmdm.model.User

/**
 * Clase de datos que representa el estado completo de la pantalla de perfil.
 * Contiene toda la información del usuario, estados de UI, y resultados de operaciones.
 *
 * @property user Datos del usuario autenticado, o null si no hay usuario logueado
 * @property userId Identificador único del usuario (redundante pero útil para accesos rápidos)
 * @property isLoggedIn Indica si hay un usuario autenticado en la aplicación
 * @property favorites Lista de animes marcados como favoritos por el usuario
 * @property profileImageUri URI local de la imagen de perfil personalizada (tomada con cámara)
 * @property profileImageId Identificador de la imagen de perfil seleccionada desde opciones predefinidas
 * @property isImagePickerOpen Indica si el selector de imágenes de perfil está abierto
 * @property isSavingImage Indica si se está guardando una nueva imagen de perfil
 * @property isEditDialogOpen Indica si el diálogo de edición de perfil está abierto
 * @property editUsername Nombre de usuario temporal en el diálogo de edición
 * @property editEmail Email temporal en el diálogo de edición
 * @property isSavingProfileData Indica si se están guardando cambios en los datos del perfil
 * @property editError Mensaje de error específico del diálogo de edición, o null si no hay error
 * @property infoMessage Mensaje informativo positivo para mostrar al usuario
 * @property error Mensaje de error general de la pantalla, o null si no hay error
 */
data class ProfilePageState(
    val user: User? = null,
    val userId: String = "",
    val isLoggedIn: Boolean = false,
    val favorites: List<Anime> = emptyList(),

    val profileImageUri: Uri? = null,
    val profileImageId: String = "",

    val isImagePickerOpen: Boolean = false,
    val isSavingImage: Boolean = false,

    val isEditDialogOpen: Boolean = false,
    val editUsername: String = "",
    val editEmail: String = "",
    val isSavingProfileData: Boolean = false,
    val editError: String? = null,

    val infoMessage: String? = null,

    val error: String? = null
)