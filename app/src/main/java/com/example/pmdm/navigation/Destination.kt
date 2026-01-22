package com.example.pmdm.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Stars
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Define todas las rutas de navegación de la aplicación.
 *
 * Cada destino contiene su `route`, el icono de la barra de navegación inferior,
 * la etiqueta y una descripción accesible.  La ruta de cámara no se incluye en la lista
 * de entradas porque se lanza desde el perfil y no aparece en la bottom bar.
 */
sealed class Destination(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val contentDescription: String
) {
    data object Start : Destination("start", Icons.Default.Home, "Inicio", "Pantalla de inicio")
    data object ListContend : Destination("listContend", Icons.AutoMirrored.Filled.List, "Lista", "Pantalla de lista")
    data object Details : Destination("details/{id}", Icons.Default.Info, "Detalles", "Pantalla de detalles")
    data object Profile : Destination("profile", Icons.Default.Person, "Perfil", "Pantalla de perfil")
    data object Login : Destination("login", Icons.Default.AccountBox, "Login", "Pantalla de login")
    data object Fav : Destination("favoritos", Icons.Default.Stars, "Favoritos", "Pantalla de favoritos")

    // ✅ Nueva ruta: pantalla de cámara (no aparece en la barra inferior)
    data object Camera : Destination("camera", Icons.Default.PhotoCamera, "Cámara", "Pantalla de cámara")

    companion object {
        /**
         * Destinos que aparecen en la bottom bar. La cámara queda fuera para ser lanzada
         * desde el perfil.
         */
        val entries: List<Destination> = listOf(Start, ListContend, Fav, Profile)
    }
}
