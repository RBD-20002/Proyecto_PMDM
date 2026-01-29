package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

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
