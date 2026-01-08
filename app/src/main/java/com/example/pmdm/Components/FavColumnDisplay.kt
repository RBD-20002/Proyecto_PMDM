package com.example.pmdm.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.RicardoComponent.VerticalAnimeCard
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.DataProvider

/**
 * Muestra una lista de animes favoritos usando una columna básica.
 *
 * Este componente es una versión simple sin desplazamiento (no usa `LazyColumn`),
 * ideal para aprender cómo organizar elementos en `Column` y `Row`.
 *
 * - Muestra un título arriba.
 * - Coloca los animes en **filas de 2 elementos**.
 * - Cada fila contiene dos tarjetas ([VerticalAnimeCard]).
 *
 * @param title Título que se mostrará encima de la lista (por defecto "Tus Favoritos").
 * @param favorites Lista de animes a mostrar (usa objetos [CardConfig]).
 * @param navController Controlador de navegación opcional. Si no se pasa,
 * se crea uno localmente con `rememberNavController()` para evitar errores.
 */
@Composable
fun FavColumnDisplay(
    favorites: List<CardConfig>,
    navController: NavController
) {
    // Si no se recibe un NavController, se crea uno local
    val controller = navController

    // Dividimos la lista en grupos de 2 animes por fila
    val rows = favorites.chunked(2)

    // Columna principal que contiene el título y las filas
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            ).padding(5.dp)
        ) {
            // Título simple
            TextComponent(
                text = "FAVORITOS",
                textSize = 30.sp
            )
        }

        // Cada grupo forma una fila con 2 animes
        for (group in rows) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (anime in group) {
                    VerticalAnimeCard(anime, navController)
                }
            }
        }
    }
}

/**
 * Vista previa del componente [FavColumnDisplay].
 *
 * Muestra un ejemplo con los primeros animes de [DataProvider.animeList],
 * para ver cómo se ve la estructura en columnas y filas sin scroll.
 */
@Preview
@Composable
fun FavColumnDisplayPreview() {
    val navController = rememberNavController()
    val sample = DataProvider.animeList.take(15)
    FavColumnDisplay(favorites = sample, navController = navController)
}
