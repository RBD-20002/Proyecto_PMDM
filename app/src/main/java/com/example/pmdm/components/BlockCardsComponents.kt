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
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.model.Anime

/**
 * Componente composable que muestra una cuadrícula de tarjetas de Anime en un diseño de 2 columnas.
 * Organiza las tarjetas en filas de a pares usando LazyColumn para un desplazamiento eficiente.
 *
 * @param input Lista de objetos Anime que se mostrarán en las tarjetas
 * @param navController Controlador de navegación para manejar la navegación entre pantallas
 * @param modifier Modificador para personalizar el diseño del contenedor principal
 */
@Composable
fun BlockCardsComponents(
    input: List<Anime>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center
    ) {
        input.chunked(2).forEach { pares ->
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    pares.forEach { cardConfig ->
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            CardComponent(input = listOf(cardConfig), navController = navController)
                        }
                    }
                    if (pares.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

/**
 * Función de vista previa para mostrar el componente BlockCardsComponents en el diseñador de Android Studio.
 * Crea datos de ejemplo de Anime y renderiza el componente con tres tarjetas idénticas.
 */
@Preview(showBackground = true)
@Composable
fun BlockCardsComponentsPreview() {
    val navController = rememberNavController()
    val sample = Anime(
        id = "naruto",
        imageUrl = "https://placehold.co/300x400",
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja...",
        info = "Tipo: Serie\nGeneros: Shounen, Accion",
        enlace1 = "",
        enlace2 = ""
    )
    BlockCardsComponents(input = listOf(sample, sample, sample), navController = navController)
}
