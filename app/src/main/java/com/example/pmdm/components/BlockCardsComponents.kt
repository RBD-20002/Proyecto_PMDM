package com.example.pmdm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm.R
import com.example.pmdm.model.Anime


/**
 * Componente que muestra una cuadrícula de tarjetas en una lista vertical.
 *
 * Cada fila contiene hasta dos tarjetas generadas a partir de los objetos [Anime].
 * Si hay un número impar de elementos, se inserta un [Spacer] para mantener la simetría visual.
 *
 * ### Características:
 * - Usa un [LazyColumn] para renderizado eficiente de listas.
 * - Organiza los elementos en filas con un máximo de dos tarjetas.
 * - Permite navegación a través del [NavController].
 * - Incluye márgenes y espaciado uniforme entre elementos.
 *
 * @param input Lista de configuraciones de tarjetas a renderizar.
 * @param navController Controlador de navegación para manejar interacciones.
 * @param modifier Modificador opcional para personalizar el estilo del contenedor.
 *
 * @see CardComponent
 */
@Composable
fun BlockCardsComponents(input: List<Anime>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        verticalArrangement = Arrangement.Center
    ){
        input.chunked(2).forEach { pares ->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ){
                    pares.forEach { cardConfig ->
                        Column(modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                        ){
                            CardComponent(input = listOf(cardConfig), navController = navController)
                        }
                    }
                    if(pares.size == 1){
                        Spacer(modifier = Modifier
                            .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBlockDisplayCardComponent() {
    val sample = Anime(
        id = "naruto",
        imageId = "naruto",
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja...",
        info = "Tipo: Serie\nGeneros: Shounen, Accion",
        enlace1 = "",
        enlace2 = ""
    )
    BlockDisplayCardComponent(animeInfo = sample)
}