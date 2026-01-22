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
import com.example.pmdm.pagesC.CameraPage
import com.example.pmdm.pagesC.DetailsPage
import com.example.pmdm.pagesC.FavoritePage
import com.example.pmdm.pagesC.ListContend
import com.example.pmdm.pagesC.LoginPage
import com.example.pmdm.pagesC.ProfilePage
import com.example.pmdm.pagesC.StartPage
import com.example.pmdm.viewModel.AuthViewModel
import com.example.pmdm.viewModel.DetailsViewModel
import com.example.pmdm.viewModel.FavoriteViewModel
import com.example.pmdm.viewModel.LoginViewModel
import com.example.pmdm.viewModel.ProfileViewModel
import com.example.pmdm.viewModel.StartViewModel

/**
 * Define el NavHost de la aplicación, enlazando cada ruta con su pantalla composable.
 *
 * Con la integración de la cámara se añade una entrada adicional para la ruta "camera".
 * Para la cámara se reutiliza el mismo ProfileViewModel que la pantalla de perfil, de modo
 * que la imagen capturada se guarde en el estado del usuario.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel

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
            LaunchedEffect(id) { if (id != null) vm.loadAnime(id) }
            DetailsPage(
                state = state,
                onToggleFavorite = { vm.toggleFavorite() },
                isUserLoggedIn = true // puedes usar el AuthViewModel para validar esto
            )
        }

        // ✅ Pantalla de cámara: reutiliza ProfileViewModel de la pantalla de perfil
        composable(Destination.Camera.route) { cameraEntry ->
            val profileEntry = remember(cameraEntry) {
                navController.getBackStackEntry(Destination.Profile.route)
            }
            val profileVm: ProfileViewModel = viewModel(viewModelStoreOwner = profileEntry)
            CameraPage(
                navController = navController,
                onPhotoTaken = { uri -> profileVm.updateProfileImage(uri) }
            )
        }
    }
}
