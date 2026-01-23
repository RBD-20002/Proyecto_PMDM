package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import com.example.pmdm.navigation.AppNavHost
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.GuestBottomBar
import com.example.pmdm.components.MainButtonBar
import com.example.pmdm.components.SearchToggle
import com.example.pmdm.components.Toolbar
import com.example.pmdm.ui.theme.PMDMTheme
import com.example.pmdm.viewModel.AuthViewModel
import com.example.pmdm.viewModel.SearchViewModel
import com.example.pmdm.viewModel.StartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMDMTheme {
                MainContent()
            }
        }
    }
}

@Composable
private fun MainContent() {
    val navController = rememberNavController()

    val searchViewModel: SearchViewModel = viewModel()
    val searchState by searchViewModel.state.collectAsStateWithLifecycle()

    val startViewModel: StartViewModel = viewModel()
    val startState by startViewModel.state.collectAsStateWithLifecycle()

    // Auth
    val authViewModel: AuthViewModel = viewModel()
    val authState by authViewModel.state.collectAsStateWithLifecycle()

    // Ruta actual
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    LaunchedEffect(Unit) {
        startViewModel.loadAnimes()
    }

    val searchResults: List<String> = if (searchState.query.isBlank()) {
        emptyList()
    } else {
        startState.animeList.filter { anime ->
            anime.title.contains(searchState.query, ignoreCase = true)
        }.map { it.title }
    }

    // Toolbar y BottomBar se muestran en TODAS las páginas MENOS en login
    val shouldShowToolbarAndBottomBar = currentRoute !in listOf("login", "createAccount")

    // SearchBar solo en algunas pantallas
    val shouldShowSearch = currentRoute in listOf("start", "listContend", "favoritos")

    Scaffold(
        topBar = {
            if (shouldShowToolbarAndBottomBar) {
                Column {
                    Toolbar(
                        onSearchClick = { searchViewModel.activateSearch() }
                    )

                    if (shouldShowSearch && searchState.isActive) {
                        SearchToggle(
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
                                val anime = startState.animeList.find {
                                    it.title.equals(title, ignoreCase = true)
                                }
                                anime?.let {
                                    navController.navigate("details/${it.id}")
                                    searchViewModel.deactivateSearch()
                                }
                            },
                            onSearch = { searchQuery ->
                                val anime = startState.animeList.find {
                                    it.title.equals(searchQuery, ignoreCase = true)
                                }
                                anime?.let {
                                    navController.navigate("details/${it.id}")
                                    searchViewModel.deactivateSearch()
                                }
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (shouldShowToolbarAndBottomBar) {
                if (authState.isLoggedIn) {
                    MainButtonBar(navController = navController)
                } else {
                    GuestBottomBar(navController = navController)
                }
            }
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            authViewModel = authViewModel
        )
    }
}
