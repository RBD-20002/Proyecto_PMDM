package com.example.pmdm.navigation

import LoginPage
import ProfilePage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.PagesC.DetailsPage
import com.example.pmdm.PagesC.FavoritePage
import com.example.pmdm.PagesC.ListContend
import com.example.pmdm.PagesC.StartPage
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.DataProvider

/**
 * Define el gráfico de navegación principal de la aplicación.
 *
 * Este `NavHost` centraliza todas las rutas declaradas en [Destination] y
 * permite navegar entre las distintas pantallas del proyecto, como inicio,
 * lista de contenidos, perfil, login, favoritos y detalles de anime.
 *
 * Cada destino está vinculado con una función `@Composable` correspondiente.
 *
 * ### Rutas incluidas:
 * - **Start** → Pantalla de inicio ([StartPage])
 * - **ListContend** → Lista de animes ([ListContend])
 * - **Profile** → Perfil de usuario ([ProfilePage])
 * - **Login** → Pantalla de inicio de sesión ([LoginPage])
 * - **Fav** → Favoritos ([FavoritePage])
 * - **details/{id}** → Detalles de un anime específico ([DetailsPage])
 *
 * @param navController Controlador de navegación que administra las rutas.
 * @param modifier Modificador opcional para ajustar el `NavHost`.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Start.route,
        modifier = modifier
    ) {
        // Rutas principales de la barra de navegación inferior
        composable(Destination.Start.route) {
            StartPage(
                navController = navController,
                recommendedList = state.recommendedAnimes.map { it.toCardConfig() },
                popularList = state.popularAnimes.map { it.toCardConfig() })
        }
        composable(Destination.ListContend.route) {
            ListContend(
                navController = navController,
                animeList = DataProvider.animeList
            )
        }
        composable(Destination.Profile.route) {
            ProfilePage(
                profileData = listOf(
                    com.example.pmdm.Components.PreviewFieldConfig("USER:", state.username),
                    com.example.pmdm.Components.PreviewFieldConfig("EMAIL:", state.email),
                    com.example.pmdm.Components.PreviewFieldConfig("ROLE:", state.role)
                ),
                favorites = state.favoriteAnimes.map { it.toCardConfig() },
                canEdit = true,
                navController = navController
            )
        }
        composable(Destination.Login.route) {
            LoginPage(
                email = "",
                password = "",
                onEmailChange = {},
                onPasswordChange = {},
                onLoginClick = {},
                onRegisterClick = {},
                onGuestClick = {}
            )
        }
        composable(Destination.Fav.route) {
            FavoritePage(
                navController = navController,
                favoriteList = state.favorites.map { it.toCardConfig() }
            )
        }

        // Ruta dinámica para la pantalla de detalles (recibe un ID por parámetro)
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val anime = DataProvider.animeList.find { it.id == id }
            if (anime != null) {
                DetailsPage(
                    anime = anime,
                    isFavorite = anime,
                    onToggleFavorite = { viewModel.toggleFavorite() }
                )
            }
        }
    }
}


