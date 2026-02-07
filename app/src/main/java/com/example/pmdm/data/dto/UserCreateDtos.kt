package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Objeto de Transferencia de Datos (DTO) para la solicitud de creación de un nuevo usuario.
 * Representa los datos necesarios para registrar un usuario en el sistema.
 *
 * @property username Nombre de usuario único para el nuevo usuario
 * @property email Dirección de correo electrónico del usuario
 * @property password Contraseña del usuario (debe manejarse de forma segura en el cliente/servidor)
 * @property profileImageId Identificador opcional de la imagen de perfil asociada al usuario
 */
data class CreateUserRequestDto(
    @SerializedName("userName")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("passwd")
    val password: String,

    @SerializedName("profileImageId")
    val profileImageId: String = ""
)

/**
 * Objeto de Transferencia de Datos (DTO) para la respuesta de creación de usuario.
 * Contiene la confirmación del registro exitoso y datos relevantes del usuario creado.
 *
 * @property id Identificador único asignado al usuario recién creado
 * @property message Mensaje descriptivo sobre el resultado de la operación de creación
 */
data class CreateUserResponseDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("message")
    val message: String
)