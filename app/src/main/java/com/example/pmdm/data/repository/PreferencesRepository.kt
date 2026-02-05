package com.example.pmdm.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
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
    }

    val loggedInUserIdFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[Keys.LOGGED_IN_USER_ID]
        }

    suspend fun saveUserId(userId: String) {
        context.dataStore.edit { settings ->
            settings[Keys.LOGGED_IN_USER_ID] = userId
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { settings ->
            settings.remove(Keys.LOGGED_IN_USER_ID)
        }
    }
}
