package com.example.pmdm.Components

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
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.DataProvider


/**
 * Componente que muestra una cuadrícula de tarjetas en una lista vertical.
 *
 * Cada fila contiene hasta dos tarjetas generadas a partir de los objetos [CardConfig].
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
fun BlockCardsComponents(input: List<CardConfig>, navController: NavController, modifier: Modifier = Modifier) {
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

/**
 * Vista previa del componente [BlockCardsComponents].
 *
 * Genera una lista de animes desde [DataProvider.animeList] y
 * crea un [NavController] temporal para visualizar la composición
 * de las tarjetas en el modo Preview de Android Studio.
 *
 * @see BlockCardsComponents
 */
@Preview
@Composable
fun PreviewCards() {
    val animeList = DataProvider.animeList
    val navController = rememberNavController()
    BlockCardsComponents(input = animeList, navController = navController)
}
