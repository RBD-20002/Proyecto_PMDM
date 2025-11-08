package com.example.pmdm.nicolasComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.RicardoComponent.TextComponent

/**
 * Fila de vista previa que muestra un par **etiqueta–valor** dentro de un bloque de datos.
 *
 * Este componente se utiliza para representar la información de un usuario (u otro tipo de datos)
 * en formato de dos columnas: la primera con la etiqueta y la segunda con el valor correspondiente.
 *
 * Generalmente se usa dentro de [DataProfileComponent] para mostrar los datos del perfil.
 *
 * ### Características:
 * - Distribuye los textos en los extremos de la fila.
 * - Mantiene un espaciado y color uniforme.
 * - Es totalmente reutilizable para mostrar pares clave-valor en otros contextos.
 *
 * @param label Texto de la etiqueta o nombre del campo (por ejemplo: `"USER:"`, `"EMAIL:"`).
 * @param value Valor asociado a la etiqueta (por ejemplo: `"NicoDev"`, `"nico@example.com"`).
 */
@Composable
fun PreviewDataRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Etiqueta del campo (izquierda)
        TextComponent(
            text = label,
            textSize = 15.sp,
            textColor = Color.White,
            modifier = Modifier.padding(3.dp)
        )

        // Valor del campo (derecha)
        TextComponent(
            text = value,
            textSize = 15.sp,
            textColor = Color.White
        )
    }
}

/**
 * Vista previa del componente [PreviewDataRow].
 *
 * Muestra un ejemplo simple con los textos "Usuario" y "Paco" para diseño y prueba visual.
 */
@Preview
@Composable
fun ejemplo() {
    PreviewDataRow("Usuario", "Paco")
}
