package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pmdm.pagesC.*
import com.example.pmdm.viewModel.AuthViewModel
import com.example.pmdm.viewModel.DetailsViewModel
import com.example.pmdm.viewModel.FavoriteViewModel
import com.example.pmdm.viewModel.LoginViewModel
import com.example.pmdm.viewModel.ProfileViewModel
import com.example.pmdm.viewModel.StartViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel  // ← NUEVO PARÁMETRO
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
                    if (state.email == "ricardo03-03-02@hotmail.com" && state.password == "RBD90-") {
                        authViewModel.login(state.email, state.password)  // ← USA AuthViewModel
                        navController.navigate(Destination.Profile.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    }
                },
                onRegisterClick = {
                    if (state.email.isNotBlank() && state.password.isNotBlank()) {
                        authViewModel.login(state.email, state.password)  // ← USA AuthViewModel
                        navController.navigate(Destination.Profile.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    }
                },
                onGuestClick = {
                    authViewModel.loginAsGuest()  // ← USA AuthViewModel
                    navController.navigate(Destination.Start.route) {
                        popUpTo(Destination.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // ---------- PANTALLA DE FAVORITOS ----------
        composable(Destination.Fav.route) {
            val viewModel: FavoriteViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                viewModel.loadFavorites()
            }

            FavoritePage(
                navController = navController,
                state = state
            )
        }

        // ---------- PANTALLA DE DETALLES ----------
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val viewModel: DetailsViewModel = viewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val authState by authViewModel.state.collectAsStateWithLifecycle()  // ← Estado de auth

            LaunchedEffect(id) {
                if (id != null) {
                    viewModel.loadAnime(id)
                }
            }

            DetailsPage(
                state = state,
                onToggleFavorite = {
                    viewModel.toggleFavorite()
                },
                isUserLoggedIn = authState.isLoggedIn  // ← Pasar estado real
            )
        }
    }
}