package com.example.pmdm.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Stars
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Clase sellada que define todas las rutas de navegación de la aplicación.
 *
 * Cada objeto dentro de [Destination] representa una pantalla del proyecto,
 * incluyendo su **ruta**, **icono**, **etiqueta** (label) y **descripción accesible**.
 *
 * Sirve como punto central para registrar y reutilizar las rutas tanto en el
 * `NavHost` como en la `BottomNavigationBar`, garantizando consistencia en los nombres.
 *
 * ### Estructura general
 * - `route`: identificador de la pantalla usado en `NavHost`.
 * - `icon`: icono asociado para la BottomBar.
 * - `label`: texto visible debajo del icono.
 * - `contentDescription`: descripción accesible para lectores de pantalla.
 */
sealed class Destination(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val contentDescription: String
) {

    /**
     * Pantalla de inicio principal, mostrada al abrir la app.
     */
    data object Start : Destination(
        route = "start",
        icon = Icons.Default.Home,
        label = "Inicio",
        contentDescription = "Pantalla de inicio"
    )

    /**
     * Pantalla con la lista completa de animes disponibles.
     */
    data object ListContend : Destination(
        route = "listContend",
        icon = Icons.AutoMirrored.Filled.List,
        label = "Lista",
        contentDescription = "Pantalla de lista"
    )

    /**
     * Pantalla de detalles, usada para mostrar la información de un anime específico.
     * Esta pantalla suele recibir un parámetro dinámico `id` en la ruta.
     */
    data object Details : Destination(
        route = "details",  // ← Coincide con NavHost <- modifique esto agregando {id}
        icon = Icons.Default.Info,
        label = "Detalles",
        contentDescription = "Pantalla de detalles"
    )

    /**
     * Pantalla de perfil del usuario.
     */
    data object Profile : Destination(
        route = "profile",
        icon = Icons.Default.Person,
        label = "Perfil",
        contentDescription = "Pantalla de perfil"
    )

    /**
     * Pantalla de inicio de sesión o registro de usuario.
     * No se incluye en la barra inferior de navegación.
     */
    data object Login : Destination(
        route = "login",
        icon = Icons.Default.AccountBox,
        label = "Login",
        contentDescription = "Pantalla de login"
    )

    /**
     * Pantalla de animes favoritos del usuario.
     */
    data object Fav : Destination(
        route = "favoritos",
        icon = Icons.Default.Stars,
        label = "Favoritos",
        contentDescription = "Pantalla de favoritos"
    )

    companion object {
        /**
         * Lista de pantallas visibles en la barra de navegación inferior.
         *
         * Excluye las pantallas auxiliares (por ejemplo, `Login` o `Details`).
         */
        val entries: List<Destination> = listOf(Start, ListContend, Fav, Profile)
    }
}
