package com.example.pmdm.ui.state

import com.example.pmdm.model.Anime

/**
 * Clase de datos que representa el estado de la pantalla de inicio.
 * Contiene la lista de animes disponibles, estado de carga y posibles errores.
 *
 * @property animeList Lista completa de animes disponibles para mostrar en la pantalla de inicio
 * @property isLoading Indica si se está cargando la lista de animes desde la fuente de datos
 * @property error Mensaje de error si falla la carga de animes, o null si no hay error
 */
data class StartPageState(
    val animeList: List<Anime> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)