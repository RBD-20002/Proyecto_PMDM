package com.example.pmdm.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.Anime
import com.example.pmdm.R

/**
 * Modelo de datos que define la configuración de una tarjeta.
 *
 * Contiene los datos necesarios para representar un elemento en una vista de tarjetas,
 * incluyendo el identificador, imagen, título y textos informativos.
 *
 * @property id Identificador único del elemento.
 * @property imageId Recurso de imagen asociado a la tarjeta.
 * @property imageDesc Descripción de la imagen para accesibilidad.
 * @property title Título principal mostrado en la tarjeta.
 * @property synopsis Sinopsis o descripción breve del contenido.
 * @property info Información adicional o detalle extendido.
 */
data class CardConfig(
    val id: Int,
    val imageId: Int,
    val imageDesc: String = "",
    val title: String,
    val synopsis: String,
    val info: String,
    val enlace1: String = "",
    val enlace2: String = "",
    val favorite: Boolean ?= false
){
    // CONSTRUCTOR NUEVO para usar con el modelo Anime
    constructor(
        anime: Anime  // ¡Usa el Anime que creamos arriba!
    ) : this(
        id = anime.id,
        imageId = anime.imageId,
        imageDesc = anime.imageDesc,
        title = anime.title,
        synopsis = anime.synopsis,
        info = anime.info,
        enlace1 = anime.enlace1,
        enlace2 = anime.enlace2,
        favorite = anime.isFavorite
    )
}

/**
 * Componente que muestra una o varias tarjetas de contenido.
 *
 * Cada tarjeta incluye una imagen, un título y permite navegación
 * hacia una pantalla de detalles al hacer clic.
 *
 * ### Características:
 * - Usa un [Card] por cada elemento en la lista [input].
 * - Permite navegar a una ruta dinámica `"details/{id}"` mediante [NavController].
 * - Ajusta la imagen con [ContentScale.FillBounds] para ocupar el alto completo.
 * - Muestra el título usando el componente [TextComponent].
 *
 * @param input Lista de configuraciones [CardConfig] que definen las tarjetas a mostrar.
 * @param navController Controlador de navegación que gestiona el evento de clic.
 *
 * @see CardConfig
 * @see TextComponent
 */
@Composable
fun CardComponent(input: List<CardConfig>, navController: NavController){

    Column {
        input.forEach { cardConfig ->
            Card(modifier = Modifier
                .width(220.dp)
                .height(100.dp)
                .padding(4.dp),
                onClick = { navController.navigate("details/${cardConfig.id}") }
            ){
                Row{
                    Box(
                        modifier = Modifier
                            .width(65.dp)
                            .fillMaxHeight()
                    ){
                        Image(
                            painter = painterResource(id = cardConfig.imageId),
                            contentDescription = cardConfig.imageDesc,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column {
                            TextComponent(
                                text = cardConfig.title,
                                textColor = Color.Black,
                                textSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Vista previa del componente [CardComponent].
 *
 * Muestra dos tarjetas de ejemplo con imágenes y títulos de anime.
 * Se usa [rememberNavController] para simular la navegación.
 *
 * @see CardComponent
 */
@Preview
@Composable
fun PreviewCard(){
    val inputs = listOf(
        CardConfig(
            id = 0,
            imageId = R.drawable.dragonball,
            imageDesc = "Dragon Ball Z",
            title = "DRAGON BALL Z",
            synopsis = "",
            info = ""
        ),
        CardConfig(
            id = 0,
            imageId = R.drawable.tokyo_revengers,
            imageDesc = "Dragon Ball Z",
            title = "TOKYO REVENGERS",
            synopsis = "",
            info = ""
        )
    )

    CardComponent(input = inputs, navController = rememberNavController())

}