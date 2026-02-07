package com.example.pmdm.components

import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.model.Anime

/**
 * Tarjeta de perfil que muestra la imagen de usuario (personal o por defecto del anime) y controles de cámara/ajustes.
 * Permite al usuario cambiar su foto de perfil tomando una nueva foto con la cámara.
 *
 * @param anime Objeto Anime que proporciona datos de respaldo (imagen y título) cuando no hay foto de perfil
 * @param profileImageUri URI de la imagen de perfil personalizada del usuario (null si no hay foto personalizada)
 * @param modifier Modificador para personalizar el diseño de la tarjeta
 * @param onCameraClick Función lambda que se ejecuta al hacer clic en el botón de cámara para tomar nueva foto
 */
@Composable
fun ProfileCard(
    anime: Anime,
    profileImageUri: Uri?,
    modifier: Modifier = Modifier,
    onCameraClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .border(
                width = 2.dp,
                color = Color.White.copy(alpha = 0.7f),
                shape = RoundedCornerShape(2.dp)
            )
            .width(150.dp)
            .height(250.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (profileImageUri != null) {
                // ✅ Mostrar la foto capturada
                AsyncImage(
                    model = profileImageUri,
                    contentDescription = stringResource(R.string.Text_ProfileCard_1),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                )
            } else {
                // Fallback a la imagen del anime (crocs)
                AsyncImage(
                    model = anime.imageUrl,
                    contentDescription = anime.imageDesc,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                )

            }
            // Nombre o título
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )
            // Botón de cámara para tomar una nueva foto
            Row() {
                IconButtonComponent(
                    icon = Icons.Default.PhotoCamera,
                    description = stringResource(R.string.Text_ProfileCard_2),
                    onClick = onCameraClick
                )

                Spacer(modifier = Modifier.width(10.dp))

                IconButtonComponent(
                    icon = Icons.Default.Settings,
                    description = stringResource(R.string.Text_ProfileCard_3),
                    onClick = { }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

/**
 * Vista previa del componente ProfileCard para visualización en el diseñador de Android Studio.
 * Muestra la tarjeta de perfil usando datos de anime de ejemplo (sin imagen personalizada).
 */
@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    val sample = Anime(
        id = "crocs",
        imageUrl = "crocs",
        imageDesc = "crocs",
        title = "Nombre Usuario",
        synopsis = "",
        info = ""
    )
    ProfileCard(anime = sample, profileImageUri = null, onCameraClick = {})
}