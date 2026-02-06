package com.example.pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
    authViewModel: AuthViewModel,
    startViewModel: StartViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Login.route,
        modifier = modifier
    ) {
        composable(Destination.Start.route) {
            val state by startViewModel.state.collectAsStateWithLifecycle()
            StartPage(navController = navController, state = state)
        }

        composable(Destination.ListContend.route) {
            val state by startViewModel.state.collectAsStateWithLifecycle()
            ListContend(navController = navController, state = state)
        }

        composable(Destination.Profile.route) {
            val vm: ProfileViewModel = hiltViewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadProfile() }

            ProfilePage(
                state = state,
                navController = navController,
                onLogout = { authViewModel.logout() },
                onOpenImagePicker = vm::openImagePicker,
                onCloseImagePicker = vm::closeImagePicker,
                presetImageIds = vm.presetProfileImageIds,
                imageUrlForId = vm::imageUrlForId,
                onSelectPreset = vm::selectPresetImage,

                onOpenEditDialog = vm::openEditDialog,
                onCloseEditDialog = vm::closeEditDialog,
                onEditUsernameChange = vm::onEditUsernameChange,
                onEditEmailChange = vm::onEditEmailChange,
                onSaveEdits = vm::saveProfileDataEdits
            )

        }

        composable(Destination.Login.route) {
            val vm: LoginViewModel = hiltViewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LoginPage(
                state = state,
                authError = authViewModel.state.collectAsStateWithLifecycle().value.error,
                onUsernameChange = {
                    authViewModel.setError(null)
                    vm.onUsernameChange(it)
                },
                onPasswordChange = {
                    authViewModel.setError(null)
                    vm.onPasswordChange(it)
                },
                onTogglePasswordVisibility = vm::togglePasswordVisibility,
                onRememberCredentialsChange = { vm.onRememberCredentialsChange(it) },
                onLoginClick = {
                    vm.onLoginSuccess()
                    authViewModel.setError(null)
                    authViewModel.login(username = state.userName, password = state.password)
                },
                onRegisterClick = { navController.navigate(Destination.CreateAccount.route) },
                onGuestClick = {
                    authViewModel.setError(null)
                    authViewModel.loginAsGuest()
                    navController.navigate(Destination.Start.route) {
                        popUpTo(Destination.Login.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.Favorites.route) {
            val vm: FavoriteViewModel = hiltViewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) { vm.loadFavorites() }

            FavoritePage(navController = navController, state = state)
        }

        composable(
            route = Destination.Details.ROUTE_PATTERN,
            arguments = listOf(navArgument("animeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val animeId = backStackEntry.arguments?.getString("animeId") ?: return@composable

            val vm: DetailsViewModel = hiltViewModel()
            val state by vm.state.collectAsStateWithLifecycle()

            LaunchedEffect(animeId) { vm.loadAnime(animeId = animeId) }

            DetailsPage(
                state = state,
                onToggleFavorite = { vm.toggleFavorite() },
                isUserLoggedIn = authViewModel.state.collectAsStateWithLifecycle().value.isLoggedIn
            )
        }

        composable(Destination.Camera.route) { cameraEntry ->
            val profileEntry = remember(cameraEntry) {
                navController.getBackStackEntry(Destination.Profile.route)
            }
            val profileVm: ProfileViewModel = hiltViewModel(viewModelStoreOwner = profileEntry)

            CameraPage(
                navController = navController,
                onPhotoTaken = { uri -> profileVm.updateProfileImage(uri) }
            )
        }

        composable(Destination.CreateAccount.route) {
            val vm: CreateAccountViewModel = hiltViewModel()
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
                onCancelClick = { navController.popBackStack() },
                onTogglePasswordVisibility = vm::togglePasswordVisibility,
                onToggleRepeatPasswordVisibility = vm::toggleRepeatPasswordVisibility
            )

        }
    }
}