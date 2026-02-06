package com.example.pmdm.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.pmdm.model.LoginCredentials
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class PreferencesRepository @Inject constructor(@ApplicationContext private val context: Context) {

    private object Keys {
        val LOGGED_IN_USER_ID = stringPreferencesKey("logged_in_user_id")
        val SAVED_USERNAME = stringPreferencesKey("saved_username")
        val SAVED_PASSWORD = stringPreferencesKey("saved_password")
        val REMEMBER_CREDENTIALS = booleanPreferencesKey("remember_credentials")
    }

    val loggedInUserIdFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[Keys.LOGGED_IN_USER_ID]
        }

    val savedCredentialsFlow: Flow<LoginCredentials> = context.dataStore.data.map {
        LoginCredentials(
            username = it[Keys.SAVED_USERNAME] ?: "",
            password = it[Keys.SAVED_PASSWORD] ?: "",
            remember = it[Keys.REMEMBER_CREDENTIALS] ?: false
        )
    }

    suspend fun saveUserId(userId: String) {
        context.dataStore.edit { settings ->
            settings[Keys.LOGGED_IN_USER_ID] = userId
        }
    }

    suspend fun saveCredentials(credentials: LoginCredentials) {
        context.dataStore.edit { settings ->
            if (credentials.remember) {
                settings[Keys.SAVED_USERNAME] = credentials.username
                settings[Keys.SAVED_PASSWORD] = credentials.password
                settings[Keys.REMEMBER_CREDENTIALS] = true
            } else {
                settings.remove(Keys.SAVED_USERNAME)
                settings.remove(Keys.SAVED_PASSWORD)
                settings.remove(Keys.REMEMBER_CREDENTIALS)
            }
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { settings ->
            settings.remove(Keys.LOGGED_IN_USER_ID)
        }
    }
}
