package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.ImageUploadResponseDto
import com.example.pmdm.data.service.ImageService
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Repositorio que gestiona las operaciones relacionadas con imágenes, incluyendo subida y descarga.
 * Actúa como una capa de abstracción sobre el servicio de imágenes de la API.
 *
 * @property imageService Servicio para realizar llamadas a la API relacionadas con imágenes
 */
class ImageRepository(
    private val imageService: ImageService
) {

    /**
     * Sube una imagen al servidor y devuelve la información de respuesta.
     *
     * @param image Imagen a subir, empaquetada como MultipartBody.Part
     * @return DTO con la información de la imagen subida (identificador, etc.)
     * @throws IllegalStateException si la respuesta del servidor está vacía o es inválida
     */
    suspend fun uploadImage(image: MultipartBody.Part): ImageUploadResponseDto {
        val response = imageService.uploadImage(image)
        return response.body() ?: throw IllegalStateException("La respuesta de la subida de imagen está vacía.")
    }

    /**
     * Descarga una imagen específica desde el servidor utilizando su identificador.
     *
     * @param id Identificador único de la imagen a descargar
     * @return Response con el cuerpo de la imagen descargada
     */
    suspend fun getImage(id: String): Response<ResponseBody> {
        return imageService.getImage(id)
    }
}