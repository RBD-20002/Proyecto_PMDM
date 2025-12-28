package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R
import com.example.pmdm.Components.BlockDisplayCardComponent
import com.example.pmdm.Components.CardConfig
import com.example.pmdm.Components.SnackbarComponent
import com.example.pmdm.Components.TextBlockConfig
import com.example.pmdm.Components.TextComponent
import com.example.pmdm.model.DataProvider
import kotlinx.coroutines.launch

@Composable
fun DetailsPage(anime: CardConfig) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Spacer(modifier = Modifier.height(30.dp)) }

            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(anime.imageId),
                        contentDescription = anime.imageDesc,
                        modifier = Modifier.size(250.dp),
                        contentScale = ContentScale.Fit,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextComponent(text = anime.title, textSize = 30.sp, textColor = Color.Cyan)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            item {
                BlockDisplayCardComponent(animeInfo = anime)
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
        FloatingActionButton(
            onClick = {
                val favorite = DataProvider.isFavorite(animeId = anime.id)
                DataProvider.filterFavorite(animeId = anime.id)

                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = if(!favorite){
                            "${anime.title} añadido a favoritos"
                            }else{
                                "${anime.title} eliminado de favoritos"
                            },
                        duration = SnackbarDuration.Short
                    )
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, "Boton Favorito")
        }

        SnackbarComponent(
            snackbarHostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


private fun getAnimeInfo(): List<TextBlockConfig> {
    return listOf(
        TextBlockConfig(
            titleBlock = "SINOPSIS",
            title = "Naruto",
            descrip = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
            titleSize = 20.sp,
            descripSize = 15.sp
        ),
        TextBlockConfig(
            titleBlock = "INFORMACION",
            descrip = "Tipo:\nSerie\n\nGeneros:\nSuper Poderes, Shounen, Artes Marciales, Comedia, Accion\n\nStudios:\nPierrot\n\nTemporada:\nOtoño 2002\n\nDemografia:\nShounen\n\nIdiomas:\nJaponés\n\nEpisodios:\n220\n\nDuracion:\n23 min. por episodio\n\nEmitido:\nJueves, 03 de Octubre de 2002",
            titleSize = 18.sp,
            descripSize = 15.sp
        )
    )
}

@Preview
@Composable
fun PreviewDetails() {
    val sample = CardConfig(
        id = 1,
        imageId = R.drawable.naruto,
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
        info = "Tipo:\n" +
                "Serie\n\n" +
                "Generos:\n" +
                "Super Poderes, Shounen, Artes Marciales, Comedia, Accion\n\n" +
                "Studios:\n" +
                "Pierrot\n\n" +
                "Temporada:\n" +
                "Otoño 2002\n\n" +
                "Demografia:\n" +
                "Shounen\n\n" +
                "Idiomas:\n" +
                "Japonés\n\n" +
                "Episodios:\n" +
                "220\n\n" +
                "Duracion:\n" +
                "23 min. por episodio\n\n" +
                "Emitido:\n" +
                "Jueves, 03 de Octubre de 2002",
        enlace1 = "https://www3.animeflv.net/anime/naruto",
        enlace2 = "https://jkanime.net/naruto"
    )
    DetailsPage(anime = sample)
}
