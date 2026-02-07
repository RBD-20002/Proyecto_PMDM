package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Objeto de Transferencia de Datos (DTO) que representa la estructura de datos
 * recibida desde la API para un anime. Esta clase se utiliza para deserializar
 * las respuestas JSON de los servicios web.
 *
 * @property id Identificador único del anime
 * @property imageId Identificador de la imagen asociada al anime
 * @property title Título del anime
 * @property synopsis Sinopsis o descripción del anime
 * @property info Información adicional del anime en formato de texto estructurado
 * @property imageDesc Descripción de la imagen para accesibilidad
 * @property enlace1 Primer enlace externo relacionado con el anime
 * @property enlace2 Segundo enlace externo relacionado con el anime
 */
data class AnimeDto(

    @SerializedName("id")
    val id: String,

    @SerializedName("imageId")
    val imageId: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("synopsis")
    val synopsis: String,

    @SerializedName("info")
    val info: String,

    @SerializedName("imageDesc")
    val imageDesc: String,

    @SerializedName("enlace1")
    val enlace1: String,

    @SerializedName("enlace2")
    val enlace2: String
)