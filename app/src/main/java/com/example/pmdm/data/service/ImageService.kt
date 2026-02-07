package com.example.pmdm.data.service

import com.example.pmdm.data.dto.ImageUploadResponseDto
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

/**
 * Interfaz que define los servicios de API disponibles para operaciones relacionadas con imágenes.
 * Incluye funcionalidades para descargar y subir imágenes al servidor.
 */
interface ImageService {

    /**
     * Descarga una imagen específica desde el servidor utilizando su identificador único.
     *
     * @param id Identificador único de la imagen a descargar
     * @return Response que contiene el cuerpo de la imagen como ResponseBody
     */
    @GET("images/{id}")
    suspend fun getImage(@Path("id") id: String): Response<ResponseBody>

    /**
     * Sube una imagen al servidor utilizando formato multipart.
     *
     * @param image Imagen a subir, empaquetada como MultipartBody.Part
     * @return Response que contiene el resultado de la subida en formato ImageUploadResponseDto
     */
    @Multipart
    @POST("images")
    suspend fun uploadImage(@Part image: MultipartBody.Part): Response<ImageUploadResponseDto>
}