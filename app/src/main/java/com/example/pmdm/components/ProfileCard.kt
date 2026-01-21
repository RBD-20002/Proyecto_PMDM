package com.example.pmdm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.ui.graphics.Color
import com.example.pmdm.model.Anime

/**
 * Tarjeta de perfil del usuario con imagen, nombre y un icono decorativo.
 *
 * Este componente muestra una tarjeta vertical que contiene:
 * - Una imagen principal (por ejemplo, foto de perfil o avatar del usuario).
 * - El nombre o título del usuario.
 * - Un pequeño icono de cámara al pie, indicando edición o foto.
 *
 * Suele utilizarse dentro de pantallas de perfil o configuraciones del usuario.
 *
 * ### Características:
 * - Bordes redondeados con contorno negro.
 * - Distribución vertical centrada.
 * - Altura y anchura fijas para mantener consistencia visual.
 *
 * @param anime Objeto [Anime] que contiene los datos a mostrar (imagen, descripción y título).
 * @param modifier Modificador opcional para ajustar el tamaño, bordes o espaciado externo del componente.
 */
@Composable
fun ProfileCard(
    anime: Anime,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(2.dp)
            )
            .width(140.dp)
            .height(220.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Imagen principal del perfil
            Image(
                painter = painterResource(id = anime.imageId),
                contentDescription = anime.imageDesc,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )

            // Título o nombre de usuario
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )

            // Icono inferior (decorativo o funcional)
            Icon(
                imageVector = Icons.Default.PhotoCamera,
                contentDescription = "Ícono de cámara",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .height(16.dp)
            )
        }
    }
}

/**
 * Vista previa del componente [ProfileCard].
 *
 * Muestra un ejemplo de tarjeta con datos ficticios para diseño y prueba visual.
 */
@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    val sample = Anime(
        id = 1,
        imageId = R.drawable.crocs,
        imageDesc = "crocs",
        title = "Nombre Usuario",
        synopsis = "",
        info = ""
    )
    ProfileCard(anime = sample)
}
