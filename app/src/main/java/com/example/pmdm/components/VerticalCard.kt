package com.example.pmdm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.model.Anime
import com.example.pmdm.R

/**
 * Tarjeta vertical de anime utilizada en la pantalla de inicio o listas de contenido.
 *
 * Este componente muestra una imagen y el título del anime dentro de una tarjeta
 * clicable. Al presionar la tarjeta, navega automáticamente a la pantalla de
 * detalles del anime correspondiente.
 *
 * ### Características:
 * - Diseño vertical con proporciones fijas (140 × 220 dp).
 * - Imagen superior y título centrado debajo.
 * - Soporte para navegación con [NavController].
 * - Compatible con Material 3.
 *
 * ### Uso típico:
 * Se usa en `LazyRow` o `LazyColumn` para mostrar colecciones de animes, por ejemplo:
 * ```kotlin
 * items(DataProvider.animeList) { anime ->
 *     VerticalAnimeCard(anime, navController)
 * }
 * ```
 *
 * @param anime Objeto [com.example.pmdm.components.CardConfig] que contiene la información del anime (imagen, título e id).
 * @param navController Controlador de navegación que gestiona el cambio hacia la vista de detalles.
 * @param modifier Modificador opcional para ajustar el tamaño, espaciado o estilo visual.
 */
@Composable
fun VerticalCard(
    anime: Anime,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(140.dp)
            .height(220.dp),
        onClick = { navController.navigate("details/${anime.id}") }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Imagen principal del anime
            Image(
                painter = painterResource(id = anime.imageId),
                contentDescription = anime.imageDesc,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(top = 5.dp)
            )

            // Título del anime
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}

/**
 * Vista previa del componente [VerticalCard].
 *
 * Muestra una tarjeta de ejemplo con un anime ficticio (Dragon Ball Z)
 * para verificar la apariencia y el espaciado en el modo de diseño.
 */
@Preview(showBackground = true)
@Composable
private fun VerticalCardPreview() {
    val navController = rememberNavController()
    val sample = Anime(
        id = 1,
        imageId = R.drawable.dragon_ball,
        imageDesc = "Goku",
        title = "DRAGON BALL Z",
        synopsis = "",
        info = ""
    )
    VerticalCard(
        anime = sample,
        navController = navController
    )
}
