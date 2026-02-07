package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Objeto de Transferencia de Datos (DTO) que representa un usuario en el sistema.
 * Esta estructura refleja los datos del usuario tal como se reciben desde la API.
 *
 * @property id Identificador único del usuario
 * @property username Nombre de usuario para autenticación y visualización
 * @property email Dirección de correo electrónico del usuario
 * @property password Contraseña del usuario (normalmente encriptada/hasheada)
 * @property profileImageId Identificador opcional de la imagen de perfil del usuario
 * @property favoriteAnimes Lista opcional de identificadores de animes marcados como favoritos por el usuario
 */
data class UserDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("userName")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("passwd")
    val password: String,

    @SerializedName("profileImageId")
    val profileImageId: String? = "",

    @SerializedName("favoriteAnimes")
    val favoriteAnimes: List<String>? = emptyList()
)
