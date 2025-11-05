package com.example.pmdm.PagesC

import CarouselStartPage
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.DataProvider
import com.example.pmdm.RicardoComponent.VerticalAnimeCard

@Composable
fun StartPage(navController: androidx.navigation.NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Carrusel superior
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarouselStartPage()
        }

        // Listas horizontales (debajo del carrusel)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 260.dp) // ajusta si tu carrusel tiene otra altura
        ) {
            Text(
                "Recomendados",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(DataProvider.animeList, key = { it.id }) { anime ->
                    VerticalAnimeCard(
                        cardConfig = anime,
                        navController = navController
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Populares",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(DataProvider.animeList.shuffled(), key = { it.id }) { anime ->
                    VerticalAnimeCard(
                        cardConfig = anime,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPagePreview() {
    val navController = rememberNavController()
    StartPage(navController = navController)
}
