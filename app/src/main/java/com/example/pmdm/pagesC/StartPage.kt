package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.components.CarouselStartPage
import com.example.pmdm.components.TextComponent
import com.example.pmdm.components.VerticalCard
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.StartPageState
import com.example.pmdm.ui.theme.cardTextColor

/**
 * Pantalla de inicio principal de la aplicación que muestra un carrusel destacado,
 * lista completa de animes y sección de recomendados.
 *
 * @param navController Controlador de navegación para redirigir a detalles de anime al hacer clic
 * @param state Estado actual de la pantalla que contiene la lista de animes, estado de carga y errores
 */
@Composable
fun StartPage(
    navController: NavController,
    state: StartPageState,
) {
    val sectionTextColor = MaterialTheme.cardTextColor

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo principal
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_StartPage_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        when {
            state.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextComponent(
                        text = stringResource(R.string.Text_StartPage_2), textSize = 20.sp
                    )
                }
            }

            state.error != null -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextComponent(
                        text = "Error: ${state.error}",
                        textSize = 16.sp,
                        textColor = Color.Red
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    // 1) Carrusel
                    item {
                        Spacer(modifier = Modifier.height(12.dp))
                        CarouselStartPage(
                            items = state.animeList.shuffled().take(5),
                            modifier = Modifier.fillMaxWidth(),
                            navController = navController
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // 2) Sección "Todos los Animes"
                    item {
                        Text(
                            text = stringResource(R.string.Pag_Inicio_Text_1),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    item {
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            items(items = state.animeList, key = { it.id }) { anime ->
                                VerticalCard(anime, navController)
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // 3) Sección "Recomendados"
                    item {
                        Text(
                            text = stringResource(R.string.Pag_Inicio_Text_2),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    item {
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            items(items = state.animeList.shuffled().take(10), key = { it.id }) { anime ->
                                VerticalCard(anime, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Vista previa del componente StartPage para visualización en el diseñador de Android Studio.
 * Muestra la pantalla de inicio con dos animes de ejemplo.
 */
@Preview(showBackground = true)
@Composable
fun StartPagePreview() {
    val sampleState = StartPageState(
        animeList = listOf(
            Anime("one_piece", "https://placehold.co/300x400", "desc", "One Piece", "", ""),
            Anime("one_piece2", "https://placehold.co/300x400", "desc", "One Piece", "", ""),
        ),
        isLoading = false,
        error = null
    )

    StartPage(
        navController = rememberNavController(),
        state = sampleState
    )
}