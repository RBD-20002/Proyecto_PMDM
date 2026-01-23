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
import com.example.pmdm.pagesC.CreateAcountPage
import com.example.pmdm.pagesC.DetailsPage
import com.example.pmdm.pagesC.FavoritePage
import com.example.pmdm.pagesC.ListContend
import com.example.pmdm.pagesC.LoginPage
import com.example.pmdm.pagesC.ProfilePage
import com.example.pmdm.pagesC.StartPage
import com.example.pmdm.viewModel.AuthViewModel
import com.example.pmdm.viewModel.CreateAccountViewModel
import com.example.pmdm.viewModel.DetailsViewModel
import com.example.pmdm.viewModel.FavoriteViewModel
import com.example.pmdm.viewModel.LoginViewModel
import com.example.pmdm.viewModel.ProfileViewModel
import com.example.pmdm.viewModel.StartViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Login.route,
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

                onLoginClick = {
                    // ✅ CREDENCIALES CORRECTAS (AJUSTA AQUÍ si quieres otras)
                    if (state.email == "abc" && state.password == "123") {
                        vm.setLoginError(null)
                        authViewModel.login(state.email, state.password)

                        navController.navigate(Destination.Start.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    } else {
                        vm.setLoginError("Correo o contraseña incorrectos")
                    }
                },

                onRegisterClick = {
                    navController.navigate("createAccount")
                },

                onGuestClick = {
                    vm.setLoginError(null)
                    authViewModel.loginAsGuest()

                    navController.navigate(Destination.Start.route) {
                        popUpTo(Destination.Login.route) { inclusive = true }
                    }
                }
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
                isUserLoggedIn = authViewModel.state.value.isLoggedIn
            )
        }

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

        composable("createAccount") {
            val vm: CreateAccountViewModel = viewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            if (state.success) {
                LaunchedEffect(Unit) {
                    vm.clearState()
                    navController.popBackStack()
                }
            }

            CreateAcountPage(
                state = state,
                onUsernameChange = vm::onUsernameChange,
                onEmailChange = vm::onEmailChange,
                onPasswordChange = vm::onPasswordChange,
                onRepeatPasswordChange = vm::onRepeatPasswordChange,
                onCreateClick = vm::onCreateClick,
                onCancelClick = { navController.popBackStack() }
            )
        }

    }
}
