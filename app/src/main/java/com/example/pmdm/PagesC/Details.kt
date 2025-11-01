package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.TextBlockComponent
import com.example.pmdm.RicardoComponent.TextBlockConfig
import com.example.pmdm.nicolas.Toolbar

@Composable
fun DetailsPage() {
    val infos = remember { getAnimeInfo() }

    Scaffold(
        topBar = { Toolbar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    Image(
                        painter = painterResource(R.drawable.naruto),
                        contentDescription = "Naruto",
                        modifier = Modifier
                            .size(250.dp),
                        contentScale = ContentScale.Fit,
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }

                items(infos) { config ->
                    TextBlockComponent(info = listOf(config))
                }
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
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
fun Preview(){
    DetailsPage()
}