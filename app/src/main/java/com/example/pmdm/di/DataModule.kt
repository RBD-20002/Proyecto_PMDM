package com.example.pmdm.di

import android.content.Context
import com.example.pmdm.data.repository.CredentialsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCredentialsRepository(@ApplicationContext context: Context): CredentialsRepository {
        return CredentialsRepository(context)
    }
}
