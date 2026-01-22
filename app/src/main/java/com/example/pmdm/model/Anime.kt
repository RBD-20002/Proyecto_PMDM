package com.example.pmdm.model

data class Anime(
    val id: Int,
    val imageId: Int,
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
