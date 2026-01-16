package com.example.pmdm.model

data class CardConfig(
    val id: Int,
    val imageId: Int,
    val imageDesc: String,
    val title: String,
    val synopsis: String,
    val info: String,
    val enlace1: String = "",
    val enlace2: String = "",
    val favorite: Boolean = false
)
