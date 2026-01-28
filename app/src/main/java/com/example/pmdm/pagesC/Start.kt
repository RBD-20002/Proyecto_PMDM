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
                    TextComponent(
                        text = "Cargando...",
                        textSize = 20.sp,
                        textColor = sectionTextColor
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
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // 2) Sección "Todos los Animes"
                    item {
                        Text(
                            text = "Todos los Animes",
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
                            text = "Recomendados",
                            color = sectionTextColor
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
