package com.example.pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.NavigationBottomBar
import com.example.pmdm.components.SearchToggle
import com.example.pmdm.components.Toolbar
import com.example.pmdm.navigation.AppNavHost
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.theme.PMDMTheme
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

    // ViewModel para búsqueda
    val searchViewModel: SearchViewModel = viewModel()
    val searchState by searchViewModel.state.collectAsState()

    // Obtener lista de animes desde StartViewModel
    val startViewModel: StartViewModel = viewModel()
    val startState by startViewModel.state.collectAsStateWithLifecycle()

    // Cargar animes al inicio
    LaunchedEffect(Unit) {
        startViewModel.loadAnimes()
    }

    // Filtrar resultados de búsqueda
    val searchResults: List<String> = if (searchState.query.isBlank()) {
        emptyList()
    } else {
        startState.animeList.filter { anime ->
            anime.title.contains(searchState.query, ignoreCase = true)
        }.map { it.title }
    }

    // Determinar si mostrar bottom bar
    val backStackEntry by navController.currentBackStackEntryAsState()
    val isBottomRoute: Boolean = when {
        backStackEntry == null -> true
        else -> {
            val currentRoute = backStackEntry?.destination?.route
            currentRoute != null && (
                    currentRoute == Destination.Start.route ||
                            currentRoute == Destination.ListContend.route ||
                            currentRoute == Destination.Profile.route ||
                            currentRoute == Destination.Fav.route ||
                            currentRoute?.startsWith("details/") == true
                    )
        }
    }

    Scaffold(
        topBar = {
            Column {
                Toolbar(
                    onSearchClick = {
                        // Activar búsqueda con toggle (alternar)
                        searchViewModel.toggleSearch(!searchState.isActive)
                    }
                )

                // Mostrar barra de búsqueda si está activa
                if (searchState.isActive) {
                    SearchToggle(
                        hint = "Buscar anime por título...",
                        results = searchResults,
                        externalActive = searchState.isActive,
                        onActiveChangeExternal = { active ->
                            if (active) {
                                searchViewModel.toggleSearch(true)
                            } else {
                                searchViewModel.toggleSearch(false)
                            }
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
                                searchViewModel.toggleSearch(false) // Cerrar búsqueda
                            }
                        },
                        onSearch = { searchQuery ->
                            val anime = startState.animeList.find {
                                it.title.equals(searchQuery, ignoreCase = true)
                            }
                            anime?.let {
                                navController.navigate("details/${it.id}")
                                searchViewModel.toggleSearch(false) // Cerrar búsqueda
                            }
                        }
                    )
                }
            }
        },
        bottomBar = {
            if (isBottomRoute) {
                NavigationBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}