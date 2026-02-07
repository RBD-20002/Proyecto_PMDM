package com.example.pmdm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.ui.theme.cardContainerColor

/**
 * Hoja modal inferior que permite seleccionar una imagen de perfil entre opciones predefinidas o tomar una foto nueva.
 * Presenta una cuadrícula de imágenes preestablecidas más una opción para abrir la cámara.
 *
 * @param presetImageIds Lista de identificadores únicos para las imágenes predefinidas disponibles
 * @param imageUrlForId Función que convierte un ID de imagen en su URL correspondiente para cargar la imagen
 * @param onSelectPreset Función lambda que se ejecuta al seleccionar una imagen predefinida (recibe el ID de la imagen)
 * @param onTakePhoto Función lambda que se ejecuta al seleccionar la opción de tomar una nueva foto
 * @param onDismiss Función lambda que se ejecuta al cerrar la hoja modal (al tocar fuera o deslizar hacia abajo)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileImagePickerSheet(
    presetImageIds: List<String>,
    imageUrlForId: (String) -> String,
    onSelectPreset: (String) -> Unit,
    onTakePhoto: () -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Text(
            text = stringResource(R.string.Text_ProfileImagePickerSheet_1),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Card(
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.cardContainerColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    onClick = onTakePhoto
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PhotoCamera,
                            contentDescription = stringResource(R.string.Text_ProfileImagePickerSheet_2),
                            modifier = Modifier.padding(24.dp)
                        )
                    }
                }
            }

            items(presetImageIds) { id ->
                Card(
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.cardContainerColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    onClick = { onSelectPreset(id) }
                ) {
                    AsyncImage(
                        model = imageUrlForId(id),
                        contentDescription = "Avatar $id",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

/**
 * Vista previa del componente ProfileImagePickerSheet para visualización en el diseñador de Android Studio.
 * Muestra la hoja modal de selección de imagen con datos de ejemplo.
 */
@Preview
@Composable
fun ProfileImagePickerSheetPreview() {

    ProfileImagePickerSheet(
        presetImageIds = listOf("avatar1", "avatar2", "avatar3"),
        imageUrlForId = { id -> ""},
        onSelectPreset = { selectedId ->
            println("Imagen seleccionada: $selectedId")
        },
        onTakePhoto = {
            println("Abrir cámara")
        },
        onDismiss = {
            println("Hoja cerrada")
        }
    )
}