package com.example.pmdm.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.model.Anime
@Composable
fun BlockDisplayCardComponent(animeInfo: Anime) {
    val context = LocalContext.current
    var openedIndex by remember { mutableStateOf<Int?>(null) }

    Column {
        DisplayCardComponent(
            title = stringResource(R.string.PD_Text_1),
            firstInfo = animeInfo.info,
            open = openedIndex == 0,
            onClick = {
                openedIndex = if (openedIndex == 0) null else 0
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        DisplayCardComponent(
            title = stringResource(R.string.PD_Text_2),
            firstInfo = animeInfo.synopsis,
            open = openedIndex == 1,
            onClick = {
                openedIndex = if (openedIndex == 1) null else 1
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        DisplayCardComponent(
            title = stringResource(R.string.PD_Text_3),
            firstInfo = "",
            open = openedIndex == 2,
            onClick = {
                openedIndex = if (openedIndex == 2) null else 2
            },
            links = {
                Spacer(modifier = Modifier.height(10.dp))
                LinkButtonComponent(
                    img = R.drawable.flv,
                    description = "animeFLV",
                    titleButton = stringResource(R.string.PD_Text_4)
                ) {
                    context.startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(animeInfo.enlace1))
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                LinkButtonComponent(
                    img = R.drawable.jk,
                    description = "jkAnime",
                    titleButton = stringResource(R.string.PD_Text_5)
                ) {
                    context.startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(animeInfo.enlace2))
                    )
                }
            }
        )
    }
}



@Preview
@Composable
fun PreviewDisplayCard() {
    val inputs = Anime(
        id = "naruto",
        imageUrl = "naruto",
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
        info = "Tipo:\nSerie\n\nGeneros:\nSuper Poderes, Shounen, Artes Marciales, Comedia, Accion\n\nStudios:\nPierrot\n\nTemporada:\nOtoño 2002\n\nDemografia:\nShounen\n\nIdiomas:\nJaponés\n\nEpisodios:\n220\n\nDuracion:\n23 min. por episodio\n\nEmitido:\nJueves, 03 de Octubre de 2002",
        enlace1 = "https://www3.animeflv.net/anime/naruto",
        enlace2 = "https://jkanime.net/naruto"
    )
    BlockDisplayCardComponent(animeInfo = inputs)
}
