package com.example.pmdm.data.dto

/**
 * DTO utilizado para modelar la respuesta que envía el servidor al subir una imagen.
 * Contiene el identificador asignado a la imagen y la URL para acceder a ella.
 */
data class ImageUploadResponseDto(
    val id: String,
    val url: String
)
