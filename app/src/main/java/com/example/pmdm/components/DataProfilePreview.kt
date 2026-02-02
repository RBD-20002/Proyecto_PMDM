package com.example.pmdm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R

/**
 * Modelo de datos que representa un campo de vista previa de perfil.
 *
 * @property label Etiqueta o nombre del campo (por ejemplo: "USER:", "EMAIL:").
 * @property value Valor correspondiente al campo (por ejemplo: "NicoDev", "nico@example.com").
 */
data class PreviewFieldConfig(
    val label: String,
    val value: String
)

/**
 * Componente que muestra una tarjeta de información de usuario con formato de perfil.
 *
 * Este componente crea un bloque con un título y una lista de pares *etiqueta-valor*
 * para mostrar datos del usuario (por ejemplo, nombre, email, rol, etc.).
 *
 * Se presenta dentro de un contenedor con borde redondeado y color de fondo personalizable.
 *
 * ### Características:
 * - Muestra un título centrado en la parte superior.
 * - Lista los datos en filas con espaciado uniforme.
 * - Personalizable en colores y tamaños mediante parámetros.
 *
 * @param title Título principal del bloque (por defecto `"DATOS USUARIO"`).
 * @param items Lista de pares `label` y `value` a mostrar.
 * @param borderColor Color del borde del contenedor (por defecto negro).
 * @param backgroundColor Color de fondo del bloque (por defecto un azul oscuro).
 */
@Composable
fun DataProfileComponent(
    title: String = stringResource(R.string.Pag_Perfil_Text_1),
    items: List<PreviewFieldConfig>,
    borderColor: Color = Color.Black,
    backgroundColor: Color = Color(0xFF0A0D1F).copy(alpha = 0.5f)
) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .border(5.dp, borderColor, RoundedCornerShape(10.dp))
            .padding(10.dp)
            .background(backgroundColor, RoundedCornerShape(10.dp))
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Título del bloque
                TextComponent(
                    text = title,
                    textSize = 20.sp,
                    textColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Lista de campos (usuario, email, rol, etc.)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items.forEach { item ->
                        // Cada fila muestra el label y valor correspondiente
                        PreviewDataRow(label = item.label, value = item.value)
                    }
                }
            }
        }
    }
}

/**
 * Vista previa del componente [DataProfileComponent].
 *
 * Muestra un ejemplo de tarjeta de perfil con datos de usuario ficticios.
 */
@Preview
@Composable
fun DataPreviewComponentPreview() {
    val sampleItems = listOf(
        PreviewFieldConfig(label = "USER:", value = "NicoDev"),
        PreviewFieldConfig(label = "EMAIL:", value = "nico@example.com")
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        DataProfileComponent(
            title = "DATOS DE USUARIO",
            items = sampleItems,
            borderColor = Color.White
        )
    }
}
