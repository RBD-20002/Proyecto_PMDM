package com.example.pmdm.di

import android.content.Context
import com.example.pmdm.data.repository.CredentialsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo de Dagger Hilt que proporciona dependencias relacionadas con el almacenamiento de datos locales.
 * Este módulo se instala en el componente Singleton para garantizar instancias únicas en toda la aplicación.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /**
     * Proporciona una instancia única de CredentialsRepository para gestionar credenciales de usuario.
     *
     * @param context Contexto de aplicación necesario para acceder al DataStore
     * @return Instancia de CredentialsRepository configurada con el contexto
     */
    @Provides
    @Singleton
    fun provideCredentialsRepository(@ApplicationContext context: Context): CredentialsRepository {
        return CredentialsRepository(context)
    }
}