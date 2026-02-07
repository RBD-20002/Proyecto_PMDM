package com.example.pmdm.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.navigation.Destination

/**
 * Barra superior de la aplicación con título personalizable.
 * Utiliza los colores del tema Material Design y se muestra en la parte superior de la pantalla.
 *
 * @param title Texto que se mostrará como título en el centro de la barra superior
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

/**
 * Barra de navegación inferior que proporciona acceso rápido a las principales secciones de la app.
 * Mantiene sincronizada la selección visual con la pantalla actual usando el estado de navegación.
 *
 * @param navController Controlador de navegación para gestionar los cambios entre pantallas
 * @param currentDestination Destino de navegación actual para determinar qué ítem mostrar como seleccionado
 */
@Composable
fun AppBottomBar(navController: NavController, currentDestination: NavDestination?) {
    val navItems = listOf(Destination.Start, Destination.Favorites, Destination.Profile)

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        navItems.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(stringResource(screen.title)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

/**
 * Vista previa del componente AppTopBar para visualización en el diseñador de Android Studio.
 * Muestra la barra superior con un título de ejemplo.
 */
@Preview
@Composable
fun AppTopBarPreview() {
    AppTopBar(title = "AnimeHUB")
}

/**
 * Vista previa del componente AppBottomBar para visualización en el diseñador de Android Studio.
 * Simula un estado donde la pantalla actual es "Start" (seleccionada).
 */
@Preview
@Composable
fun AppBottomBarPreview() {
    val navController = rememberNavController()
    AppBottomBar(
        navController = navController,
        currentDestination = null
    )
}