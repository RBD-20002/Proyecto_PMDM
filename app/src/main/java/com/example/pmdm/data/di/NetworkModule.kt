package com.example.pmdm.di

import com.example.pmdm.data.network.ApiConfig
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.ImageService
import com.example.pmdm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Módulo de Dagger Hilt que proporciona dependencias relacionadas con la red y servicios HTTP.
 * Este módulo se instala en el componente Singleton para garantizar que las instancias
 * sean únicas y compartidas en toda la aplicación.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Proporciona una instancia única de Retrofit configurada con la URL base y conversor Gson.
     *
     * @return Instancia de Retrofit configurada para toda la aplicación
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /**
     * Proporciona el servicio AnimeService para realizar operaciones HTTP relacionadas con animes.
     *
     * @param retrofit Instancia de Retrofit para crear la implementación del servicio
     * @return Implementación de AnimeService para llamadas a la API de animes
     */
    @Provides
    @Singleton
    fun provideAnimeService(retrofit: Retrofit): AnimeService =
        retrofit.create(AnimeService::class.java)

    /**
     * Proporciona el servicio ImageService para operaciones relacionadas con imágenes.
     *
     * @param retrofit Instancia de Retrofit para crear la implementación del servicio
     * @return Implementación de ImageService para manejo de imágenes
     */
    @Provides
    @Singleton
    fun provideImageService(retrofit: Retrofit): ImageService =
        retrofit.create(ImageService::class.java)

    /**
     * Proporciona el servicio UserService para operaciones relacionadas con usuarios.
     *
     * @param retrofit Instancia de Retrofit para crear la implementación del servicio
     * @return Implementación de UserService para gestión de usuarios
     */
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}