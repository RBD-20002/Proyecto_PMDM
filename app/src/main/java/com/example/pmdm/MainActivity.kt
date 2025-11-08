package com.example.pmdm

import SearchToggle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.pmdm.model.DataProvider
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.nicolasComponent.Toolbar
import com.example.pmdm.ui.theme.PMDMTheme

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

    var searchActive by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    val animeList = DataProvider.animeList
    val searchResults: List<String> = if (query.isBlank()) {
        emptyList()
    } else {
        animeList.filter { it.title.contains(query, ignoreCase = true) }
            .map { it.title }
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val bottomRoutes: Set<String> = setOf(
        com.example.pmdm.navigation.Destination.Start.route,
        com.example.pmdm.navigation.Destination.ListContend.route,
        com.example.pmdm.navigation.Destination.Details.route,
        com.example.pmdm.navigation.Destination.Profile.route,
        com.example.pmdm.navigation.Destination.Fav.route
    )

    val isBottomRoute: Boolean = if (backStackEntry == null) {
        true
    } else {
        backStackEntry
            ?.destination
            ?.hierarchy
            ?.mapNotNull { it.route }
            ?.any { it in bottomRoutes } == true
    }

    Scaffold(
        topBar = {
            Column {
                Toolbar(onSearchClick = { searchActive = true })
                if (searchActive) {
                    SearchToggle(
                        results = searchResults,
                        externalActive = searchActive,
                        onActiveChangeExternal = { searchActive = it },
                        onQueryChangeExternal = { newQuery -> query = newQuery },
                        onResultClick = { title ->
                            val anime = animeList.find { it.title.equals(title, ignoreCase = true) }
                            if (anime != null) {
                                navController.navigate("details/${anime.id}")
                            }
                        },
                        onSearch = { searchQuery ->
                            val anime = animeList.find { it.title.equals(searchQuery, ignoreCase = true) }
                            if (anime != null) {
                                navController.navigate("details/${anime.id}")
                                searchActive = false
                            }
                        }
                    )
                }
            }
        },
        bottomBar = {
            if (isBottomRoute) {
                com.example.pmdm.nicolasComponent.NavigationBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        com.example.pmdm.navigation.AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


