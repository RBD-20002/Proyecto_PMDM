package com.example.pmdm.data.service

import com.example.pmdm.data.dto.AnimeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    @GET("json/anime/search")
    suspend fun getAnimeList(): List<AnimeDto>

    @GET("json/anime/search")
    suspend fun searchAnimes(@Query("q") query: String): List<AnimeDto>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String): AnimeDto
}
