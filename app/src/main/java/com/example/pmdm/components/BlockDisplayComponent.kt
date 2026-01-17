package com.example.pmdm.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.model.CardConfig

@Composable
fun BlockDisplayCardComponent(
    animeInfo: CardConfig,
) {
    Column {
        DisplayCardComponent(
            title = "INFORMACION",
            firstInfo = animeInfo.info
        )

        Spacer(modifier = Modifier.height(15.dp))

        DisplayCardComponent(
            title = "SINOPSIS:",
            firstInfo = animeInfo.synopsis
        )

        Spacer(modifier = Modifier.height(15.dp))

        DisplayCardComponent(
            title = "ENLACES:",
            firstInfo = "",
            links = {
                Spacer(modifier = Modifier.height(10.dp))
                LinkButtonComponent(
                    img = R.drawable.flv,
                    description = "animeFLV",
                    titleButton = "Ver en AnimeFLV"
                ) {
                    Log.i("PruebaFLV","Click "+animeInfo.enlace1)
                }
                Spacer(modifier = Modifier.height(10.dp))
                LinkButtonComponent(
                    img = R.drawable.jk,
                    description = "jkAnime",
                    titleButton = "Ver en jkAnime"
                ) {
                    Log.i("PruebaJK","Click "+animeInfo.enlace2)
                }
            }
        )
    }
}


@Preview
@Composable
fun PreviewDisplayCard() {
    val inputs = CardConfig(
        id = 1,
        imageId = R.drawable.naruto,
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
        info = "Tipo:\nSerie\n\nGeneros:\nSuper Poderes, Shounen, Artes Marciales, Comedia, Accion\n\nStudios:\nPierrot\n\nTemporada:\nOtoño 2002\n\nDemografia:\nShounen\n\nIdiomas:\nJaponés\n\nEpisodios:\n220\n\nDuracion:\n23 min. por episodio\n\nEmitido:\nJueves, 03 de Octubre de 2002",
        enlace1 = "https://www3.animeflv.net/anime/naruto",
        enlace2 = "https://jkanime.net/naruto"
    )
    BlockDisplayCardComponent(animeInfo = inputs)
}
