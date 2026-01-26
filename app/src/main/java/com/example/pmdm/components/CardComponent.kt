package com.example.pmdm.components

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
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.model.Anime


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
 * @param input Lista de configuraciones [Anime] que definen las tarjetas a mostrar.
 * @param navController Controlador de navegación que gestiona el evento de clic.
 *
 * @see Anime
 * @see TextComponent
 */
@Composable
fun CardComponent(input: List<Anime>, navController: NavController){

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
                        AsyncImage(
                            model = "http://10.0.2.2:5131/images/${cardConfig.imageId}",
                            contentDescription = cardConfig.imageDesc,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
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
@Preview(showBackground = true)
@Composable
fun BlockDisplayCardComponentPreview() {
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