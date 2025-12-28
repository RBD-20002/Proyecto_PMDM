package com.example.pmdm

/**
 * Modelo SIMPLE de Anime - Para empezar
 */
data class Anime(
    val id: Int,
    val title: String,
    val synopsis: String,
    val info: String,
    val imageId: Int,
    val imageDesc: String,
    val enlace1: String = "",
    val enlace2: String = "",
    val isPopular: Boolean = false,
    val isRecommended: Boolean = false,
    val isFavorite: Boolean = false
)