package com.example.pmdm.di

import com.example.pmdm.data.repository.AnimeRepository
import com.example.pmdm.data.repository.ImageRepository
import com.example.pmdm.data.repository.UserRepository
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.ImageService
import com.example.pmdm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAnimeRepository(animeService: AnimeService): AnimeRepository =
        AnimeRepository(animeService)

    @Provides
    @Singleton
    fun provideUserRepository(userService: UserService): UserRepository = UserRepository(userService = userService)

    @Provides
    @Singleton
    fun provideImageRepository(imageService: ImageService): ImageRepository =
        ImageRepository(imageService)
}