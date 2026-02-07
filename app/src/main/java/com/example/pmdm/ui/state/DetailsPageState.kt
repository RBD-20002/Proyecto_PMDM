package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime

/**
 * Clase de datos que representa el estado de la pantalla de detalles de un anime.
 * Contiene la información del anime y su estado de favorito para el usuario actual.
 *
 * @property anime Objeto Anime con toda la información detallada del anime seleccionado
 * @property isFavorite Indica si el anime está marcado como favorito por el usuario actual
 */
data class DetailsPageState(
    val anime: Anime,
    val isFavorite: Boolean = false
)