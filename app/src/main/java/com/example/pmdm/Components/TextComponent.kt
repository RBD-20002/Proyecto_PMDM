package com.example.pmdm.Components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Componente de texto reutilizable con estilo configurable.
 *
 * Permite definir el texto a mostrar, tamaño, color, número máximo de líneas
 * y comportamiento en caso de desbordamiento.
 *
 * ### Características:
 * - Por defecto, el texto es blanco y tamaño 10.sp.
 * - Si no se especifica, el desbordamiento se maneja con puntos suspensivos ([TextOverflow.Ellipsis]).
 * - El número máximo de líneas es ilimitado a menos que se indique lo contrario.
 *
 * @param text Texto que se mostrará en pantalla.
 * @param textSize Tamaño de la fuente del texto. Por defecto 10.sp.
 * @param textColor Color del texto. Por defecto blanco.
 * @param modifier Modificador opcional para personalizar la disposición o estilo.
 * @param overflow Comportamiento al desbordarse el texto. Por defecto [TextOverflow.Ellipsis].
 * @param maxLines Número máximo de líneas. Por defecto ilimitado.
 */
@Composable
fun TextComponent(
    text: String,
    textSize: TextUnit = 10.sp,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
    overflow: TextOverflow? = null,
    maxLines: Int? = null,
) {
    Text(
        text = text,
        fontSize = textSize,
        color = textColor,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = overflow ?: TextOverflow.Ellipsis
    )
}

/**
 * Vista previa del componente [TextComponent].
 *
 * Muestra un ejemplo con texto "USER:" y tamaño de fuente 10.sp.
 */
@Preview
@Composable
fun viewText() {
    TextComponent(text = "USER:", textSize = 10.sp)
}