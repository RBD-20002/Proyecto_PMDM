package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

data class ImageUploadResponseDto(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("imageId")
    val imageId: String? = null
) {
    fun resolvedId(): String = (imageId ?: id).orEmpty()
}
