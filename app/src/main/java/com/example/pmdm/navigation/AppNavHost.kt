package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmdm.pagesC.*
import com.example.pmdm.viewModel.DetailsViewModel
import com.example.pmdm.viewModel.FavoriteViewModel
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

        composable(Destination.Start.route) {
            val vm: StartViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadAnimes() }

            StartPage(navController = navController, state = state)
        }

        composable(Destination.ListContend.route) {
            val vm: StartViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadAnimes() }

            ListContend(navController = navController, state = state)
        }

        composable(Destination.Profile.route) {
            val vm: ProfileViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadProfile() }

            ProfilePage(state = state, navController = navController)
        }

        composable(Destination.Login.route) {
            val vm: LoginViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LoginPage(
                state = state,
                onEmailChange = { vm.onEmailChange(it) },
                onPasswordChange = { vm.onPasswordChange(it) },
                onTogglePasswordVisibility = { vm.togglePasswordVisibility() },
                onLoginClick = { /* tu lógica */ },
                onRegisterClick = { /* tu lógica */ },
                onGuestClick = { /* tu lógica */ }
            )
        }

        composable(Destination.Fav.route) {
            val vm: FavoriteViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadFavorites() }

            FavoritePage(navController = navController, state = state)
        }

        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

            val vm: DetailsViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(id) {
                if (id != null) vm.loadAnime(id)
            }

            DetailsPage(
                state = state,
                onToggleFavorite = { vm.toggleFavorite() }
            )
        }

        // ✅ NUEVO: pantalla cámara
        composable(Destination.Camera.route) { cameraEntry ->

            // 🔥 CLAVE: reutilizar el MISMO ProfileViewModel que usa "profile"
            // (porque el ViewModel normal en Camera sería otro distinto)
            val profileEntry = remember(cameraEntry) {
                navController.getBackStackEntry(Destination.Profile.route)
            }
            val profileVm: ProfileViewModel = viewModel(viewModelStoreOwner = profileEntry)

            CameraPage(
                navController = navController,
                onPhotoTaken = { uri ->
                    profileVm.updateProfileImage(uri)
                }
            )
        }
    }
}
