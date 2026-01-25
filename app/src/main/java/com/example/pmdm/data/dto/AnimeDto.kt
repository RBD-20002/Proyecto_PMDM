package com.example.pmdm.data.dto

/**
 * DTO de Anime que replica los campos del modelo de dominio
 */
data class AnimeDto(
    val id: String,
    val imageId: String,
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
