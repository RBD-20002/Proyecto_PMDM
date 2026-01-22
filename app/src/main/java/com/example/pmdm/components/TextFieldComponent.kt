package com.example.pmdm.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente de campo de texto personalizado.
 *
 * Permite al usuario ingresar información con un placeholder configurable
 * y bordes redondeados. Ideal para formularios o entradas de datos.
 *
 * ### Características:
 * - Placeholder usando [TextComponent] para mostrar texto de referencia.
 * - Bordes redondeados con [RoundedCornerShape] de 10.dp.
 * - Soporta ancho completo y padding interno.
 * - Estado interno manejado mediante [remember] y [mutableStateOf].
 *
 * @param info Texto de placeholder que se mostrará cuando el campo esté vacío.
 * @param color Color del texto del placeholder.
 * @param placeholderText Composable opcional para personalizar el placeholder.
 *
 * @see TextComponent
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    info: String,
    color: Color,
    placeholderText: (@Composable () -> Unit)? = null,
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            TextComponent(
                text = info,
                textColor = color,
                textSize = 15.sp
            )
        },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    )
}

/**
 * Vista previa del componente [TextFieldComponent].
 *
 * Muestra un ejemplo de campo de texto con placeholder "prueba" y color negro.
 *
 * @see TextFieldComponent
 */
@Preview
@Composable
fun PreviewTextField() {
    TextFieldComponent(info = "prueba", Color.Black)
}