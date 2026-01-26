package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * DTO utilizado para modelar la respuesta que envía el servidor al subir una imagen.
 * Contiene el identificador asignado a la imagen y la URL para acceder a ella.
 */
data class ImageUploadResponseDto(

    @SerializedName("imageId")
    val imageId: String

)

