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

interface ImageService {

    @GET("images/{id}")
    suspend fun getImage(@Path("id") id: String): Response<ResponseBody>

    @Multipart
    @POST("images")
    suspend fun uploadImage(@Part image: MultipartBody.Part): Response<ImageUploadResponseDto>
}
