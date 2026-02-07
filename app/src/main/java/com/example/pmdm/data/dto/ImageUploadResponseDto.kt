package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Objeto de Transferencia de Datos (DTO) para la respuesta del servicio de subida de imágenes.
 * Maneja diferentes formatos de respuesta donde el identificador de imagen puede venir en diferentes campos.
 *
 * @property id Identificador primario de la imagen (puede ser nulo si no está presente)
 * @property imageId Identificador alternativo de la imagen (puede ser nulo si no está presente)
 */
data class ImageUploadResponseDto(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("imageId")
    val imageId: String? = null
) {

    /**
     * Método de conveniencia que devuelve el identificador de imagen disponible, priorizando imageId sobre id.
     * Si ambos son nulos, devuelve una cadena vacía.
     *
     * @return Identificador de imagen disponible como String no nula
     */
    fun resolvedId(): String = (imageId ?: id).orEmpty()
}