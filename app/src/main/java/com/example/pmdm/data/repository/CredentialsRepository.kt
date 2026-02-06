package com.example.pmdm.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "credentials")

data class SavedCredentials(
    val username: String = "",
    val password: String = "",
    val remember: Boolean = false
)

@Singleton
class CredentialsRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object Keys {
        val USERNAME = stringPreferencesKey("username")
        val PASSWORD = stringPreferencesKey("password")
        val REMEMBER_ME = booleanPreferencesKey("remember_me")
    }

    val savedCredentials: Flow<SavedCredentials> = context.dataStore.data.map { preferences ->
        SavedCredentials(
            username = preferences[Keys.USERNAME] ?: "",
            password = preferences[Keys.PASSWORD] ?: "",
            remember = preferences[Keys.REMEMBER_ME] ?: false
        )
    }

    suspend fun saveCredentials(username: String, password: String) {
        context.dataStore.edit { preferences ->
            preferences[Keys.USERNAME] = username
            preferences[Keys.PASSWORD] = password
            preferences[Keys.REMEMBER_ME] = true
        }
    }

    suspend fun clearCredentials() {
        context.dataStore.edit { preferences ->
            preferences.remove(Keys.USERNAME)
            preferences.remove(Keys.PASSWORD)
            preferences[Keys.REMEMBER_ME] = false
        }
    }
}
