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
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.model.DataProvider
import com.example.pmdm.RicardoComponent.VerticalAnimeCard

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
 *   con tarjetas de anime ([VerticalAnimeCard]).
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
fun StartPage(navController: androidx.navigation.NavController) {
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
                        VerticalAnimeCard(anime, navController)
                    }
                }
                Spacer(Modifier.height(12.dp))
            }

            // Sección "Populares"
            item {
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
                    // Se usa .shuffled() para variar el orden de los animes
                    items(DataProvider.animeList.shuffled(), key = { it.id }) { anime ->
                        VerticalAnimeCard(anime, navController)
                    }
                }
                Spacer(Modifier.height(80.dp)) // Espaciado adicional al final
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
    val navController = rememberNavController()
    StartPage(navController = navController)
}
