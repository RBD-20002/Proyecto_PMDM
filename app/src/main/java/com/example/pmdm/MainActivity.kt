package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.GuestBottomBar
import com.example.pmdm.components.MainButtonBar
import com.example.pmdm.components.SearchToggle
import com.example.pmdm.components.Toolbar
import com.example.pmdm.navigation.AppNavHost
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.theme.PMDMTheme
import com.example.pmdm.viewModel.AuthViewModel
import com.example.pmdm.viewModel.SearchViewModel
import com.example.pmdm.viewModel.StartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent() }
    }
}

@Composable
private fun MainContent() {
    val systemDark = isSystemInDarkTheme()
    var darkTheme by rememberSaveable { mutableStateOf(systemDark) }

    PMDMTheme(darkTheme = darkTheme) {
        val navController = rememberNavController()

        val searchViewModel: SearchViewModel = hiltViewModel()
        val searchState by searchViewModel.state.collectAsStateWithLifecycle()

        val startViewModel: StartViewModel = hiltViewModel()
        val startState by startViewModel.state.collectAsStateWithLifecycle()

        val authViewModel: AuthViewModel = hiltViewModel()
        val authState by authViewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(authState.isLoggedIn) {
            val targetRoute = if (authState.isLoggedIn) Destination.Start.route else Destination.Login.route
            navController.navigate(targetRoute) {
                popUpTo(navController.graph.id) { inclusive = true }
                launchSingleTop = true
            }
        }

        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        LaunchedEffect(Unit) { startViewModel.loadAnimes() }

        val isSearchEnabledOnThisScreen =
            currentRoute in setOf(
                Destination.Start.route,
                Destination.ListContend.route,
                Destination.Favorites.route,
                Destination.Profile.route
            ) || (currentRoute?.startsWith("details") == true)

        LaunchedEffect(currentRoute) {
            if (searchState.isActive) {
                searchViewModel.deactivateSearch()
            }
        }

        val searchResults: List<String> =
            if (searchState.query.isBlank()) emptyList()
            else startState.animeList
                .filter { anime -> anime.title.contains(searchState.query, ignoreCase = true) }
                .map { it.title }

        val shouldShowToolbarAndBottomBar = currentRoute !in listOf(
            Destination.Login.route,
            Destination.CreateAccount.route
        )

        Scaffold(
            topBar = {
                if (shouldShowToolbarAndBottomBar) {
                    Toolbar(
                        isDark = darkTheme,
                        onSearchClick = {
                            if (searchState.isActive) searchViewModel.deactivateSearch()
                            else {
                                searchViewModel.onQueryChange("")
                                searchViewModel.activateSearch()
                            }
                        },
                        onThemeClick = { darkTheme = !darkTheme }
                    )
                }
            },
            bottomBar = {
                if (shouldShowToolbarAndBottomBar) {
                    if (authState.isLoggedIn) MainButtonBar(navController = navController)
                    else GuestBottomBar(navController = navController)
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                AppNavHost(
                    navController = navController,
                    authViewModel = authViewModel,
                    startViewModel = startViewModel
                )

                if (shouldShowToolbarAndBottomBar && isSearchEnabledOnThisScreen && searchState.isActive) {
                    SearchToggle(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 4.dp),
                        hint = "Buscar anime...",
                        results = searchResults,
                        externalActive = searchState.isActive,
                        onActiveChangeExternal = { active ->
                            if (active) searchViewModel.activateSearch()
                            else searchViewModel.deactivateSearch()
                        },
                        onQueryChangeExternal = { newQuery ->
                            searchViewModel.onQueryChange(newQuery)
                        },
                        onResultClick = { title ->
                            val anime = startState.animeList.find { it.title.equals(title, ignoreCase = true) }
                            anime?.let {
                                navController.navigate(Destination.Details.createRoute(it.id))
                                searchViewModel.deactivateSearch()
                            }
                        },
                        onSearch = { searchQuery ->
                            val anime = startState.animeList.find { it.title.equals(searchQuery, ignoreCase = true) }
                            anime?.let {
                                navController.navigate(Destination.Details.createRoute(it.id))
                                searchViewModel.deactivateSearch()
                            }
                        }
                    )
                }
            }
        }
    }
}