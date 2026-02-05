package com.example.pmdm.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.navigation.Destination

@Composable
fun MainButtonBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Destination.Start,
        Destination.ListContend,
        Destination.Favorites, // <--- CORREGIDO
        Destination.Profile
    )

    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(modifier = modifier) {
        items.forEach { dest ->
            val selected = backStackEntry
                ?.destination
                ?.hierarchy
                ?.any { it.route == dest.route } == true

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(dest.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = false }
                        launchSingleTop = true
                        restoreState = false
                    }
                },
                icon = {
                    Icon(
                        imageVector = dest.icon,
                        contentDescription = stringResource(id = dest.title) // <--- CORREGIDO
                    )
                },
                label = { Text(stringResource(id = dest.title)) } // <--- CORREGIDO
            )
        }
    }
}

@Preview
@Composable
fun ButtomPreview() {
    val navController = rememberNavController()
    MainButtonBar(navController = navController)
}
