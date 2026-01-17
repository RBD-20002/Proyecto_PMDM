package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.pagesC.*
import com.example.pmdm.viewModel.DetailsViewModel
import com.example.pmdm.viewModel.FavoritePageViewModel
import com.example.pmdm.viewModel.LoginViewModel
import com.example.pmdm.viewModel.ProfileViewModel
import com.example.pmdm.viewModel.StartViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Start.route,
        modifier = modifier
    ) {
        // ---------- PANTALLA DE INICIO ----------
        composable(Destination.Start.route) {
            val viewModel: StartViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.loadAnimes()
            }

            StartPage(
                navController = navController,
                state = state
            )
        }

        // ---------- PANTALLA DE LISTA ----------
        composable(Destination.ListContend.route) {
            val viewModel: StartViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.loadAnimes()
            }

            ListContend(
                navController = navController,
                state = state
            )
        }

        // ---------- PANTALLA DE PERFIL ----------
        composable(Destination.Profile.route) {
            val viewModel: ProfileViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.loadProfile()
            }

            ProfilePage(
                state = state,
                navController = navController
            )
        }

        // ---------- PANTALLA DE LOGIN ----------
        composable(Destination.Login.route) {
            val viewModel: LoginViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LoginPage(
                state = state,
                onEmailChange = { viewModel.onEmailChange(it) },
                onPasswordChange = { viewModel.onPasswordChange(it) },
                onTogglePasswordVisibility = { viewModel.togglePasswordVisibility() },
                onLoginClick = {
                    // Ejemplo: validación simple
                    if (state.email.isNotBlank() && state.password.isNotBlank()) {
                        navController.navigate(Destination.Profile.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    }
                    // En un caso real, aquí harías llamada API
                },
                onRegisterClick = {
                    // Navegar a pantalla de registro (si la tuvieras)
                    // Por ahora, vamos a Profile
                    navController.navigate(Destination.Profile.route) {
                        popUpTo(Destination.Login.route) { inclusive = true }
                    }
                },
                onGuestClick = {
                    // Modo invitado - ir al inicio
                    navController.navigate(Destination.Start.route) {
                        popUpTo(Destination.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // ---------- PANTALLA DE FAVORITOS ----------
        composable(Destination.Fav.route) {
            val viewModel: FavoritePageViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.loadFavorites()
            }

            FavoritePage(
                navController = navController,
                state = state
            )
        }

        // ---------- PANTALLA DE DETALLES (RUTA DINÁMICA) ----------
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val viewModel: DetailsViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(id) {
                if (id != null) {
                    viewModel.loadAnime(id)
                }
            }

            DetailsPage(
                state = state,
                onToggleFavorite = {
                    viewModel.toggleFavorite()
                    // Si quisieras actualizar otras pantallas:
                    // Podrías usar un evento compartido o recargar
                }
            )
        }
    }
}