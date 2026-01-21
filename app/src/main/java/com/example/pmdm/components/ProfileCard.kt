package com.example.pmdm.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.model.CardConfig

/**
 * Tarjeta de perfil del usuario con imagen, nombre y botón de cámara.
 *
 * ✅ Si profileImageUri != null → se muestra esa foto (sacada con CameraX)
 * ✅ Si profileImageUri == null → fallback a cardConfig.imageId (crocs)
 */
@Composable
fun ProfileCard(
    cardConfig: CardConfig,
    profileImageUri: Uri?,
    modifier: Modifier = Modifier,
    onCameraClick: () -> Unit = {}
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

            // ✅ FOTO (Uri) o fallback a drawable (crocs)
            if (profileImageUri != null) {
                AsyncImage(
                    model = profileImageUri,
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = cardConfig.imageId),
                    contentDescription = cardConfig.imageDesc,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                )
            }

            // Nombre
            Text(
                text = cardConfig.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )

            // Botón cámara
            IconButton(
                onClick = onCameraClick,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Cambiar foto"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    val sample = CardConfig(
        id = 1,
        imageId = R.drawable.crocs,
        imageDesc = "crocs",
        title = "Nombre Usuario",
        synopsis = "",
        info = ""
    )

    ProfileCard(
        cardConfig = sample,
        profileImageUri = null,
        onCameraClick = {}
    )
}
