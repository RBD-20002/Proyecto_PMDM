package com.example.pmdm.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Componente de texto personalizado y reutilizable con valores predeterminados configurables.
 * Simplifica el uso de Text con configuraciones comunes como tamaño, color y comportamiento de overflow.
 *
 * @param text Contenido de texto que se mostrará
 * @param textSize Tamaño del texto (predeterminado: 10.sp)
 * @param textColor Color del texto (predeterminado: Color.White)
 * @param modifier Modificador para personalizar el diseño del componente de texto
 * @param overflow Comportamiento cuando el texto excede el espacio disponible (predeterminado: Ellipsis)
 * @param maxLines Número máximo de líneas a mostrar (predeterminado: ilimitado)
 * @param textAlign Alineación del texto dentro del contenedor (predeterminado: Center)
 * @param lineHeight Altura de línea del texto (predeterminado: 1.5 veces el tamaño del texto)
 */
@Composable
fun TextComponent(
    text: String,
    textSize: TextUnit = 10.sp,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
    overflow: TextOverflow? = null,
    maxLines: Int? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit? = null
) {
    Text(
        text = text,
        fontSize = textSize,
        color = textColor,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = overflow ?: TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        lineHeight = lineHeight ?: (textSize * 1.5f)
    )
}

/**
 * Vista previa básica del componente TextComponent para visualización en el diseñador de Android Studio.
 * Muestra el componente con texto "USER:" usando el tamaño de texto predeterminado.
 */
@Preview
@Composable
fun viewText() {
    TextComponent(text = "USER:", textSize = 10.sp)
}