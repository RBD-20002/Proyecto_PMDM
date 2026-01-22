package com.example.pmdm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.model.Anime
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.delay

/**
 * Carrusel automático de imágenes de anime mostrado en la pantalla de inicio.
 *
 * Este componente presenta una lista de elementos ([Anime]) en formato
 * deslizable horizontal, avanzando automáticamente cada [intervalMs] milisegundos.
 *
 * Cada página muestra una imagen de anime con su título superpuesto y un
 * indicador inferior de posición (círculos activos/inactivos).
 *
 * ### Características principales:
 * - Avance automático entre elementos con animación.
 * - Repetición infinita (vuelve al primer elemento al llegar al final).
 * - Indicadores de posición que cambian de tamaño y opacidad según la página activa.
 * - Adaptable mediante el parámetro [modifier].
 *
 * @param modifier Modificador para el tamaño o espaciado externo del carrusel.
 * @param intervalMs Tiempo en milisegundos entre cada cambio automático de imagen.
 * @param items Lista de configuraciones de tarjetas ([Anime]) a mostrar.
 *              Por defecto usa `DataProvider.animeList`.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselStartPage(
    modifier: Modifier = Modifier,
    intervalMs: Long = 3000L,
    items: List<Anime> = DataProvider.animeList
) {
    if (items.isEmpty()) return

    val pagerState = rememberPagerState(pageCount = { items.size })

    // Auto-scroll
    LaunchedEffect(items.size, intervalMs) {
        while (true) {
            delay(intervalMs)
            val next = (pagerState.currentPage + 1) % items.size
            pagerState.animateScrollToPage(next)
        }
    }


    // ✅ Importante: aquí fijamos el tamaño del carrusel para que TODAS las páginas midan igual
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSpacing = 0.dp
        ) { page ->
            val anime = items[page]

            // ✅ Cada página ocupa exactamente el mismo tamaño del Pager
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.extraLarge)
            ) {
                Image(
                    painter = painterResource(id = anime.imageId),
                    contentDescription = anime.imageDesc,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )

                // Degradado superior
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Black.copy(alpha = 0.55f), Color.Transparent)
                            )
                        )
                        .align(Alignment.TopStart)
                )

                // Título
                Text(
                    text = anime.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(14.dp)
                )
            }
        }

        // Indicadores
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(items.size) { idx ->
                val active = pagerState.currentPage == idx
                Box(
                    modifier = Modifier
                        .size(if (active) 10.dp else 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (active) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AutoCarouselFromDataPreview() {
    CarouselStartPage(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    )
}
