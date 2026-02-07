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

/**
 * Extensión para acceder al DataStore de preferencias desde cualquier contexto de la aplicación.
 * Define un DataStore específico para el almacenamiento de credenciales.
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "credentials")

/**
 * Clase de datos que representa las credenciales guardadas localmente del usuario.
 * Incluye nombre de usuario, contraseña y un indicador de si se debe recordar al usuario.
 *
 * @property username Nombre de usuario almacenado (cadena vacía si no hay credenciales)
 * @property password Contraseña almacenada (cadena vacía si no hay credenciales)
 * @property remember Indica si el usuario seleccionó la opción "Recordarme"
 */
data class SavedCredentials(
    val username: String = "",
    val password: String = "",
    val remember: Boolean = false
)

/**
 * Repositorio singleton que gestiona el almacenamiento y recuperación de credenciales de usuario
 * utilizando DataStore de Jetpack para persistencia segura.
 *
 * @property context Contexto de aplicación para acceder al DataStore
 */
@Singleton
class CredentialsRepository @Inject constructor(@ApplicationContext private val context: Context) {

    /**
     * Objeto que define las claves utilizadas para almacenar las credenciales en el DataStore.
     */
    private object Keys {
        val USERNAME = stringPreferencesKey("username")
        val PASSWORD = stringPreferencesKey("password")
        val REMEMBER_ME = booleanPreferencesKey("remember_me")
    }

    /**
     * Flujo que emite las credenciales guardadas cada vez que cambian.
     * Permite observar reactivamente las credenciales almacenadas.
     */
    val savedCredentials: Flow<SavedCredentials> = context.dataStore.data.map { preferences ->
        SavedCredentials(
            username = preferences[Keys.USERNAME] ?: "",
            password = preferences[Keys.PASSWORD] ?: "",
            remember = preferences[Keys.REMEMBER_ME] ?: false
        )
    }

    /**
     * Guarda las credenciales del usuario en el DataStore y activa la opción "Recordarme".
     *
     * @param username Nombre de usuario a guardar
     * @param password Contraseña a guardar
     */
    suspend fun saveCredentials(username: String, password: String) {
        context.dataStore.edit { preferences ->
            preferences[Keys.USERNAME] = username
            preferences[Keys.PASSWORD] = password
            preferences[Keys.REMEMBER_ME] = true
        }
    }

    /**
     * Elimina todas las credenciales almacenadas y desactiva la opción "Recordarme".
     */
    suspend fun clearCredentials() {
        context.dataStore.edit { preferences ->
            preferences.remove(Keys.USERNAME)
            preferences.remove(Keys.PASSWORD)
            preferences[Keys.REMEMBER_ME] = false
        }
    }
}