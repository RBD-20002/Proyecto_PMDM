package com.example.pmdm.data.network

import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.ImageService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://192.168.1.141:5131/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }

    val imageService: ImageService by lazy {
        retrofit.create(ImageService::class.java)
    }
}