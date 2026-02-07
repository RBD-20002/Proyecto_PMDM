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

/**
 * Extensión para acceder al DataStore de configuraciones desde cualquier contexto de la aplicación.
 * Define un DataStore específico para el almacenamiento de preferencias de usuario y configuraciones.
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

/**
 * Repositorio singleton que gestiona las preferencias persistentes del usuario utilizando DataStore.
 * Maneja información como ID de usuario, credenciales guardadas y configuraciones de sesión.
 *
 * @property context Contexto de aplicación para acceder al DataStore
 */
@Singleton
class PreferencesRepository @Inject constructor(@ApplicationContext private val context: Context) {

    /**
     * Objeto que define las claves utilizadas para almacenar las preferencias en el DataStore.
     */
    private object Keys {
        val LOGGED_IN_USER_ID = stringPreferencesKey("logged_in_user_id")
        val SAVED_USERNAME = stringPreferencesKey("saved_username")
        val SAVED_PASSWORD = stringPreferencesKey("saved_password")
        val REMEMBER_CREDENTIALS = booleanPreferencesKey("remember_credentials")
    }

    /**
     * Flujo que emite el ID del usuario que ha iniciado sesión, actualizándose automáticamente cuando cambia.
     * Devuelve null si no hay usuario autenticado.
     */
    val loggedInUserIdFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[Keys.LOGGED_IN_USER_ID]
        }

    /**
     * Flujo que emite las credenciales de inicio de sesión guardadas, actualizándose automáticamente cuando cambian.
     * Permite observar reactivamente las credenciales almacenadas.
     */
    val savedCredentialsFlow: Flow<LoginCredentials> = context.dataStore.data.map {
        LoginCredentials(
            username = it[Keys.SAVED_USERNAME] ?: "",
            password = it[Keys.SAVED_PASSWORD] ?: "",
            remember = it[Keys.REMEMBER_CREDENTIALS] ?: false
        )
    }

    /**
     * Guarda el ID del usuario que ha iniciado sesión exitosamente.
     *
     * @param userId ID único del usuario autenticado
     */
    suspend fun saveUserId(userId: String) {
        context.dataStore.edit { settings ->
            settings[Keys.LOGGED_IN_USER_ID] = userId
        }
    }

    /**
     * Guarda o elimina las credenciales del usuario según la opción "Recordar credenciales".
     *
     * @param credentials Credenciales de inicio de sesión y preferencia de recordar
     */
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

    /**
     * Elimina el ID de usuario almacenado, efectivamente cerrando la sesión.
     * Utilizado cuando el usuario cierra sesión o cuando la sesión expira.
     */
    suspend fun clearSession() {
        context.dataStore.edit { settings ->
            settings.remove(Keys.LOGGED_IN_USER_ID)
        }
    }
}