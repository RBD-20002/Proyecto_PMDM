package com.example.pmdm.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente de botón personalizado reutilizable con estilo predefinido.
 *
 * @param text Texto que se mostrará dentro del botón
 * @param enabled Estado de habilitación del botón (true = interactivo, false = deshabilitado)
 * @param action Función lambda que se ejecutará cuando se haga clic en el botón
 */
@Composable
fun ButtomComponent(
    text: String,
    enabled: Boolean = true,
    action: () -> Unit,
) {

    Button(
        onClick = action,
        modifier = Modifier
            .width(width = 150.dp)
            .height(height = 40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray.copy(alpha = 0.7f),
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray.copy(alpha = 0.4f),
            disabledContentColor = Color.Red
        ),
        enabled = enabled
    ) {
        TextComponent(text = text, textSize = 10.sp)

    }

}

/**
 * Vista previa para visualizar el componente ButtomComponent en el diseñador de Android Studio.
 * Muestra un botón con el texto "CREAR CUENTA" que imprime un log al hacer clic.
 */
@Preview
@Composable
fun previewButtom() {
    ButtomComponent("CREAR CUENTA") {
        Log.e("Prueba", "Click botom")
    }
}