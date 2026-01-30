package com.example.pmdm.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
fun preview1(){
    IconButtonComponent(
        icon = Icons.Default.MeetingRoom,
        description = "BOTON DE SALIR",
        onClick = { Log.e("Prueba", "Click botom") }
    )
}

@Preview
@Composable
fun Preview2(){
    IconButtonComponent(
        icon = Icons.Default.Settings,
        description = "BOTON DE SALIR",
        onClick = { Log.e("Prueba", "Click botom") }
    )
}