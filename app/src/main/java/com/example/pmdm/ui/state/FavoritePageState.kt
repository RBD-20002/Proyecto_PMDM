package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime

/**
 * Clase de datos que representa el estado de la pantalla de favoritos.
 * Contiene la lista de animes favoritos y un indicador de si la lista está vacía.
 *
 * @property favorites Lista de objetos Anime marcados como favoritos por el usuario
 * @property isEmpty Indica si la lista de favoritos está vacía (true) o tiene elementos (false)
 */
data class FavoritePageState(
    val favorites: List<Anime> = emptyList(),
    val isEmpty: Boolean = true
)