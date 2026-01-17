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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.navigation.Destination

/**
 * Barra de navegación inferior de la aplicación.
 *
 * Este componente muestra las secciones principales (rutas) definidas en la clase
 * [com.example.pmdm.navigation.Destination], permitiendo al usuario cambiar entre
 * pantallas como Inicio, Lista, Favoritos y Perfil.
 *
 * Se integra con `NavController` para navegar dentro del `NavHost` de la app y
 * mantener el estado de las rutas visitadas.
 *
 * ### Características:
 * - Resalta el ítem actual según la ruta activa.
 * - Evita duplicar entradas en el back stack (`launchSingleTop = true`).
 * - Restaura el estado de cada destino al regresar (`restoreState = true`).
 * - Hace `popUpTo` la raíz del grafo para una navegación eficiente.
 *
 * @param navController Controlador de navegación usado para manejar las rutas activas.
 * @param modifier Modificador opcional para ajustar estilo o tamaño del componente.
 */
@Composable
fun NavigationBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Lista de destinos que aparecerán en la barra inferior
    val items = listOf(
        Destination.Start,
        Destination.ListContend,
        Destination.Fav,
        Destination.Profile
    )

    // Obtiene la ruta actual para resaltar el ítem activo
    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(modifier = modifier) {
        items.forEach { dest ->
            val selected = backStackEntry
                ?.destination
                ?.hierarchy
                ?.any { it.route == dest.route } == true

            //SE MODIFICO EN PARA QUE NO SE GUARDE EL ESTADO Y SIEMRPRE SE SETEE
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(dest.route) {
                        // Mantiene el historial de navegación limpio
                        popUpTo(navController.graph.startDestinationId) { saveState = false }
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

/**
 * Vista previa del componente [NavigationBottomBar].
 *
 * Crea un `NavController` de ejemplo para mostrar la barra inferior en el modo de diseño.
 */
@Preview
@Composable
fun ButtomPreview() {
    val navController = rememberNavController()
    NavigationBottomBar(navController = navController)
}
