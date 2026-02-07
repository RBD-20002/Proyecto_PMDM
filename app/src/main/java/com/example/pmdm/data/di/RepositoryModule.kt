package com.example.pmdm.data.di

import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.data.repository.ImageRepository
import com.example.pmdm.data.repository.PreferencesRepository
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.ImageService
import com.example.pmdm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo de Dagger Hilt que proporciona dependencias de repositorios para la aplicación.
 * Los repositorios actúan como una capa intermedia entre las fuentes de datos (servicios, bases de datos)
 * y los ViewModels, manejando la lógica de negocio y coordinación de datos.
 * Este módulo se instala en el componente Singleton para garantizar instancias únicas en toda la aplicación.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Proporciona una instancia única de AnimeRepository para manejar operaciones relacionadas con animes.
     *
     * @param animeService Servicio para llamadas a la API de animes
     * @param userRepository Repositorio para operaciones relacionadas con usuarios
     * @param userService Servicio para llamadas a la API de usuarios
     * @return Instancia de AnimeRepository configurada con sus dependencias
     */
    @Provides
    @Singleton
    fun provideAnimeRepository(
        animeService: AnimeService,
        userRepository: UserRepository,
        userService: UserService
    ): AnimeRepository = AnimeRepository(animeService, userRepository, userService)

    /**
     * Proporciona una instancia única de UserRepository para manejar operaciones de autenticación y gestión de usuarios.
     *
     * @param userService Servicio para llamadas a la API de usuarios
     * @param preferencesRepository Repositorio para manejar preferencias locales del usuario
     * @return Instancia de UserRepository configurada con sus dependencias
     */
    @Provides
    @Singleton
    fun provideUserRepository(
        userService: UserService,
        preferencesRepository: PreferencesRepository
    ): UserRepository = UserRepository(userService = userService, preferencesRepository = preferencesRepository)

    /**
     * Proporciona una instancia única de ImageRepository para manejar operaciones relacionadas con imágenes.
     *
     * @param imageService Servicio para llamadas a la API de imágenes
     * @return Instancia de ImageRepository configurada con el servicio de imágenes
     */
    @Provides
    @Singleton
    fun provideImageRepository(imageService: ImageService): ImageRepository =
        ImageRepository(imageService)
}