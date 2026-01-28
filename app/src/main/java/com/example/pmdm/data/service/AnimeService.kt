package com.example.pmdm.data.service

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.data.dto.ComplexSearchRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    // Traer todos (truco: buscar title contains "")
    @POST("json/anime/complex-search")
    suspend fun getAllAnimes(
        @Body request: ComplexSearchRequest
    ): List<AnimeDto>



    // Búsqueda real
    @GET("json/anime/search")
    suspend fun searchAnimes(
        @Query("field") field: String = "title",
        @Query("value") value: String
    ): List<AnimeDto>

    @POST("json/anime/complex-search")
    suspend fun complexSearch(@Body request: ComplexSearchRequest): List<AnimeDto>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String): AnimeDto
}
