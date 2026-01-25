package com.example.pmdm.di

import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.ImageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.example.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAnimeService(retrofit: Retrofit): AnimeService =
        retrofit.create(AnimeService::class.java)

    @Provides
    @Singleton
    fun provideImageService(retrofit: Retrofit): ImageService =
        retrofit.create(ImageService::class.java)
}