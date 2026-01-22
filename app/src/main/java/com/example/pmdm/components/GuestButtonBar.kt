package com.example.pmdm.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.pmdm.navigation.Destination

@Composable
fun GuestBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Solo 3 destinos para invitados
    val guestItems = listOf(
        Destination.Start,        // Inicio
        Destination.ListContend,  // Lista
        Destination.Login         // Perfil → Login
    )

    // Obtiene la ruta actual
    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(modifier = modifier) {
        guestItems.forEach { dest ->
            val selected = backStackEntry
                ?.destination
                ?.hierarchy
                ?.any { it.route == dest.route } == true

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(dest.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = false
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        imageVector = dest.icon,
                        contentDescription = dest.contentDescription
                    )
                },
                label = { Text(dest.label) }
            )
        }
    }
}

@Preview(showBackground = true, name = "GuestBottomBar Preview")
@Composable
fun GuestBottomBarPreview() {
    val navController = rememberNavController()
    androidx.compose.material3.MaterialTheme {
        GuestBottomBar(navController = navController)
    }
}

// Preview adicional para diferentes estados
@Preview(showBackground = true, name = "GuestBottomBar - En Start")
@Composable
fun GuestBottomBarStartPreview() {
    androidx.compose.material3.MaterialTheme {
        val navController = rememberNavController()
        // Simula estar en la ruta "start"
        GuestBottomBar(navController = navController)
    }
}