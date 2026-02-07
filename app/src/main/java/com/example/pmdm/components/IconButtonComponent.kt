package com.example.pmdm.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Componente reutilizable de botón de icono con funcionalidad de clic personalizable.
 * Proporciona una interfaz consistente para botones basados en iconos en toda la aplicación.
 *
 * @param icon ImageVector del icono que se mostrará dentro del botón
 * @param description Texto de accesibilidad que describe la función del botón para lectores de pantalla
 * @param onClick Función lambda que se ejecuta cuando se hace clic en el botón
 * @param enabled Estado booleano que controla si el botón está habilitado para interacción
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconButtonComponent(
   icon: ImageVector,
   description: String,
   onClick: () -> Unit,
   enabled: Boolean = true
){

    IconButton(
        onClick = onClick,
        modifier = Modifier.padding(2.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description
        )
    }
}

/**
 * Vista previa del componente IconButtonComponent con un icono de "MeetingRoom".
 * Muestra cómo se vería un botón de icono para salir o cerrar sesión.
 */
@Preview
@Composable
fun preview1(){
    IconButtonComponent(
        icon = Icons.Default.MeetingRoom,
        description = "BOTON DE SALIR",
        onClick = { Log.e("Prueba", "Click botom") }
    )
}

/**
 * Vista previa alternativa del componente IconButtonComponent con un icono de "Settings".
 * Muestra cómo se vería un botón de icono para configuraciones o ajustes.
 */
@Preview
@Composable
fun Preview2(){
    IconButtonComponent(
        icon = Icons.Default.Settings,
        description = "BOTON DE SALIR",
        onClick = { Log.e("Prueba", "Click botom") }
    )
}