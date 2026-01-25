package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.ImageUploadResponseDto
import com.example.pmdm.data.service.ImageService
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response

class ImageRepository(
    private val imageService: ImageService
) {

    suspend fun uploadImage(image: MultipartBody.Part): ImageUploadResponseDto {
        val response = imageService.uploadImage(image)
        return response.body()
            ?: throw IllegalStateException("La respuesta de la subida de imagen está vacía.")
    }

    suspend fun getImage(id: String): Response<ResponseBody> {
        return imageService.getImage(id)
    }
}
