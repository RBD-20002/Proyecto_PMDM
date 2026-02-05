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

sealed class Destination(
    val route: String,
    val icon: ImageVector,
    @StringRes val title: Int
) {
    object Start : Destination("start", Icons.Default.Home, R.string.destination_home)
    object ListContend : Destination("listContend", Icons.AutoMirrored.Filled.List, R.string.destination_home)

    object Details : Destination(
        "details",
        Icons.Default.Info,
        R.string.destination_home // No se muestra en la barra de navegación
    ) {
        const val ROUTE_PATTERN = "details/{animeId}"

        fun createRoute(animeId: String): String {
            return "details/$animeId"
        }
    }

    object Profile : Destination("profile", Icons.Default.Person, R.string.destination_profile)
    object Login : Destination("login", Icons.Default.AccountBox, R.string.app_name)
    object Favorites : Destination("favoritos", Icons.Default.Stars, R.string.destination_favorites)
    object Camera : Destination("camera", Icons.Default.PhotoCamera, R.string.app_name)

    object CreateAccount : Destination("createAccount", Icons.Default.AccountBox, R.string.app_name)

    companion object {
        val toptier = listOf(Start, Favorites, Profile)
    }
}