package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.TextComponent
import com.example.pmdm.R
import com.example.pmdm.components.CarouselStartPage
import com.example.pmdm.components.VerticalCard
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.StartPageState

@Composable
fun StartPage(
    navController: NavController,
    state: StartPageState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo principal
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
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
                    TextComponent(text = "Cargando...", textSize = 20.sp)
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Carrusel con las primeras 5 imágenes
                    CarouselStartPage(
                        items = state.animeList.shuffled().take(5)
                    )
                }

                // Listas horizontales de contenido
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 260.dp)
                ) {
                    // Sección "Todos los animes"
                    item {
                        Text(
                            text = "Todos los Animes",
                            color = Color.White
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(
                                items = state.animeList,
                                key = { it.id }
                            ) { anime ->
                                VerticalCard(anime, navController)
                            }
                        }
                    }

                    // Sección "Populares" (primeros 5 como ejemplo)
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Recomendados",
                            color = Color.White
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(
                                items = state.animeList.shuffled().take(10),
                                key = { it.id }
                            ) { anime ->
                                VerticalCard(anime, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPagePreview() {
    val sampleState = StartPageState(
        animeList = listOf(
            Anime(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
            Anime(2, R.drawable.onepiece, "One Piece", "One Piece", "", ""),
            Anime(3, R.drawable.dragonball, "Dragon Ball", "Dragon Ball Z", "", ""),
            Anime(4, R.drawable.tokyo_revengers, "Tokyo Revengers", "Tokyo Revengers", "", "")
        ),
        isLoading = false,
        error = null
    )

    StartPage(
        navController = rememberNavController(),
        state = sampleState
    )
}