package com.example.pmdm.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente de botón reutilizable con estilo personalizado.
 *
 * Muestra un botón centrado dentro de un contenedor [Box] con tamaño fijo.
 * Ejecuta la acción definida en el parámetro [action] al hacer clic.
 *
 * ### Características:
 * - Ancho fijo de **110.dp** y alto de **50.dp**.
 * - Colores personalizados mediante [ButtonColors].
 * - Texto interno renderizado con [TextComponent].
 * - Compatible con vista previa mediante [previewButtom].
 *
 * @param text Texto que se muestra dentro del botón.
 * @param action Acción a ejecutar cuando se presiona el botón.
 *
 * @see TextComponent
 */
@Composable
fun ButtomComponent(text: String, action: () -> Unit){
    Box(modifier = Modifier
        .width(width = 110.dp)
        .height(height = 50.dp)
    ){
        Button(
            onClick = action,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Red
            )
        ) {
            TextComponent(text = text, textSize = 8.sp)
        }
    }
}
/**
 * Vista previa del componente [ButtomComponent].
 *
 * Muestra un botón de ejemplo con el texto "CREAR CUENTA"
 * y un log de prueba en la consola cuando se hace clic.
 *
 * @see ButtomComponent
 */
@Preview
@Composable
fun previewButtom(){
    ButtomComponent("CREAR CUENTA") {
        Log.e("Prueba","Click botom")
    }
}