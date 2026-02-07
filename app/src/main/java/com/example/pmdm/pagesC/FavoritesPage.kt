package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.FavColumnDisplay
import com.example.pmdm.components.TextComponent
import com.example.pmdm.R
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.FavoritePageState

/**
 * Pantalla que muestra la lista de animes favoritos del usuario.
 * Muestra un mensaje informativo si no hay favoritos o una cuadrícula de tarjetas si hay favoritos.
 *
 * @param navController Controlador de navegación para redirigir a detalles de anime al hacer clic
 * @param state Estado actual de la pantalla que contiene la lista de favoritos y estado de vacío
 */
@Composable
fun FavoritePage(
    navController: NavController,
    state: FavoritePageState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_FavoritePage_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                if (state.isEmpty) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextComponent(
                            text = stringResource(R.string.Text_FavoritePage_2),
                            textSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextComponent(
                            text = stringResource(R.string.Text_FavoritePage_3),
                            textSize = 16.sp
                        )
                    }
                } else {
                    FavColumnDisplay(
                        favorites = state.favorites,
                        navController = navController
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

/**
 * Vista previa del componente FavoritePage para visualización en el diseñador de Android Studio.
 * Muestra la pantalla de favoritos con dos animes de ejemplo.
 */
@Preview(showBackground = true)
@Composable
fun FavoritePagePreview() {
    val sampleState = FavoritePageState(
        favorites = listOf(
            Anime("naruto", "naruto", "Naruto", "Naruto", "", ""),
            Anime("one_piece", "one_piece", "One Piece", "One Piece", "", "")
        ),
        isEmpty = false
    )

    FavoritePage(
        navController = rememberNavController(),
        state = sampleState
    )
}