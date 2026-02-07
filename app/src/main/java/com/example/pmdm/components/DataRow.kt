package com.example.pmdm.components

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

/**
 * Componente que muestra una fila de datos con etiqueta y valor en una disposición horizontal.
 * Utiliza un diseño de dos columnas con la etiqueta a la izquierda y el valor a la derecha.
 *
 * @param label Texto de la etiqueta que describe el tipo de dato (ej: "Usuario", "Email")
 * @param value Valor correspondiente a la etiqueta (ej: "Paco", "paco@email.com")
 */
@Composable
fun DataRow(
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
            textSize = 13.sp,
            textColor = Color.White,
            modifier = Modifier.padding(3.dp)
        )

        // Valor del campo (derecha)
        TextComponent(
            text = value,
            textSize = 12.sp,
            textColor = Color.White
        )
    }
}

/**
 * Vista previa del componente PreviewDataRow para visualización en el diseñador de Android Studio.
 * Muestra un ejemplo de una fila de datos con etiqueta "Usuario" y valor "Paco".
 */
@Preview
@Composable
fun ejemplo() {
    DataRow("Usuario", "Paco")
}