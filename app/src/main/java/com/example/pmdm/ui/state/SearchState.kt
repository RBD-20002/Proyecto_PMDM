package com.example.pmdm.ui.state

/**
 * Clase de datos que representa el estado del componente de búsqueda.
 * Contiene la consulta actual, resultados de búsqueda y estado de visibilidad.
 *
 * @property query Texto de búsqueda ingresado por el usuario
 * @property results Lista de resultados de búsqueda (nombres de animes, usuarios, etc.)
 * @property isActive Indica si el componente de búsqueda está visible y activo (true) o colapsado (false)
 */
data class SearchState(
    val query: String = "",
    val results: List<String> = emptyList(),
    val isActive: Boolean = false
)