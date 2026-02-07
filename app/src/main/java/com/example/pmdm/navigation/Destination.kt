package com.example.pmdm.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Stars
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pmdm.R

/**
 * Clase sellada que define todos los destinos de navegación disponibles en la aplicación.
 * Cada destino tiene una ruta única, un icono asociado y un título para mostrar en la interfaz.
 *
 * @property route Ruta única que identifica el destino en el gráfico de navegación
 * @property icon Icono que representa visualmente el destino (usado en barras de navegación)
 * @property title Recurso de cadena que contiene el título legible del destino
 */
sealed class Destination(
    val route: String,
    val icon: ImageVector,
    @StringRes val title: Int
) {

    /** Pantalla de inicio principal de la aplicación. */
    object Start : Destination("start", Icons.Default.Home, R.string.destination_home)

    /** Pantalla que muestra la lista de contenido/animes disponibles. */
    object ListContend : Destination("listContend", Icons.AutoMirrored.Filled.List, R.string.destination_home)

    /** Pantalla de detalles de un anime específico. */
    object Details : Destination(
        "details",
        Icons.Default.Info,
        R.string.destination_home // No se muestra en la barra de navegación
    ) {

        /** Patrón de ruta con parámetro para el ID del anime. */
        const val ROUTE_PATTERN = "details/{animeId}"

        /**
         * Crea una ruta completa para navegar a los detalles de un anime específico.
         *
         * @param animeId ID único del anime a mostrar
         * @return Ruta completa con el ID del anime incluido
         */
        fun createRoute(animeId: String): String {
            return "details/$animeId"
        }
    }

    /** Pantalla de perfil del usuario. */
    object Profile : Destination("profile", Icons.Default.Person, R.string.destination_profile)

    /** Pantalla de inicio de sesión. */
    object Login : Destination("login", Icons.Default.AccountBox, R.string.app_name)

    /** Pantalla de animes favoritos del usuario. */
    object Favorites : Destination("favoritos", Icons.Default.Stars, R.string.destination_favorites)

    /** Pantalla de cámara para tomar fotos de perfil. */
    object Camera : Destination("camera", Icons.Default.PhotoCamera, R.string.app_name)

    /** Pantalla de creación de cuenta de usuario. */
    object CreateAccount : Destination("createAccount", Icons.Default.AccountBox, R.string.app_name)

    companion object {
        /** Lista de destinos principales que se muestran en la barra de navegación superior. */
        val toptier = listOf(Start, Favorites, Profile)
    }
}