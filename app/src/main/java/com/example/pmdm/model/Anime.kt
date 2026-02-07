package com.example.pmdm.model

/**
 * Clase de datos que representa un anime en el dominio de la aplicación.
 * Contiene toda la información necesaria para mostrar un anime en la interfaz de usuario.
 *
 * @property id Identificador único del anime
 * @property imageUrl URL completa de la imagen del anime (puede ser nula si no hay imagen)
 * @property title Título del anime
 * @property synopsis Sinopsis o descripción detallada del anime
 * @property info Información adicional estructurada sobre el anime
 * @property imageDesc Descripción de la imagen para accesibilidad
 * @property enlace1 Primer enlace externo relacionado con el anime
 * @property enlace2 Segundo enlace externo relacionado con el anime
 * @property isPopular Indica si el anime es popular (para destacar en la interfaz)
 * @property isRecommended Indica si el anime es recomendado (para destacar en la interfaz)
 * @property isFavorite Indica si el anime está marcado como favorito por el usuario actual
 */
data class Anime(
    val id: String,
    val imageUrl: String?,
    val title: String,
    val synopsis: String,
    val info: String,
    val imageDesc: String,
    val enlace1: String = "",
    val enlace2: String = "",
    val isPopular: Boolean = false,
    val isRecommended: Boolean = false,
    val isFavorite: Boolean = false
)