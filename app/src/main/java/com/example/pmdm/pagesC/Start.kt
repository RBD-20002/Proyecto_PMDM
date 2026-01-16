package com.example.pmdm.PagesC

import CarouselStartPage
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.model.DataProvider
import com.example.pmdm.RicardoComponent.VerticalCard
import com.example.pmdm.model.CardConfig

/**
 * Pantalla principal de inicio de la aplicación.
 *
 * Esta pantalla actúa como la portada principal, mostrando un fondo con un
 * carrusel superior de animes destacados y dos secciones horizontales con
 * listas de animes recomendados y populares.
 *
 * ### Estructura:
 * - **Fondo:** Imagen completa que sirve como background.
 * - **Carrusel superior:** Componente [CarouselStartPage] que rota automáticamente entre animes.
 * - **Listas inferiores:** Dos secciones horizontales (`Recomendados` y `Populares`)
 *   con tarjetas de anime ([VerticalCard]).
 *
 * ### Características:
 * - Diseño completamente adaptable a la pantalla.
 * - Usa datos desde [DataProvider.animeList].
 * - Integra navegación hacia la pantalla de detalles al pulsar una tarjeta.
 * - Mantiene coherencia con el tema de Material 3.
 *
 * @param navController Controlador de navegación para redirigir a las pantallas de detalle de anime.
 */
@Composable
fun StartPage(
    navController: NavController,
    recommendedList: List<CardConfig>,
    popularList: List<CardConfig>
){
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo principal de la pantalla
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Carrusel superior de animes destacados
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarouselStartPage()
        }

        // Listas horizontales de contenido (debajo del carrusel)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 260.dp)
        ) {
            // Sección "Recomendados"
            item {
                Text(
                    text = "Recomendados",
                    color = Color.White)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    items(
                        items = recommendedList,
                        key = { it.id }) { anime ->
                            VerticalCard(cardConfig = anime, navController)
                    }
                }
            }

            // Sección "Populares"
            item {
                Text(
                    text = "Populares",
                    color = Color.White)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(
                        items = popularList,
                        key = { it.id }) { anime ->
                            VerticalCard(anime, navController)
                    }
                }
            }
        }
    }
}

/**
 * Vista previa del componente [StartPage].
 *
 * Muestra un ejemplo de la pantalla principal con un `NavController` de prueba,
 * permitiendo revisar el diseño del fondo, el carrusel y las listas horizontales.
 */
@Preview(showBackground = true)
@Composable
fun StartPagePreview() {
    val sampleReco = listOf(
        CardConfig(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
        CardConfig(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
    )
    val sampleFav = listOf(
        CardConfig(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
        CardConfig(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
    )

    StartPage(
        navController = rememberNavController(),
        recommendedList = sampleFav,
        popularList = sampleReco
    )
}

