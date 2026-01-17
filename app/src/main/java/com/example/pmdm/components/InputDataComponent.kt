package com.example.pmdm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente que muestra una fila con una etiqueta y un campo de texto.
 *
 * Se utiliza para representar un par **(label - campo de entrada)** en formularios
 * o bloques de datos personales. La etiqueta se muestra a la izquierda y
 * el campo de entrada a la derecha.
 *
 * ### Características:
 * - Alinea texto y campo de entrada en una misma línea mediante [Row].
 * - Distribuye los elementos equitativamente con [Arrangement.SpaceBetween].
 * - Usa [TextComponent] para el texto y [TextFieldComponent] para el campo.
 * - Admite un placeholder opcional para el campo de texto.
 *
 * @param textValue Texto de la etiqueta que describe el campo (por ejemplo, "USER:").
 * @param textInfo Texto informativo o valor inicial del campo.
 * @param placeholder Composable opcional que se puede usar como marcador de posición.
 *
 * @see TextComponent
 * @see TextFieldComponent
 */
@Composable
fun InputDataComponent(
    textValue: String,
    textInfo: String,
    placeholder: (@Composable () -> Unit)? = null
){

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextComponent(
                text = textValue,
                textSize = 15.sp,
                textColor = Color.White,
                modifier = Modifier
                    .padding(3.dp)
            )

            TextFieldComponent(
                info = textInfo,
                color = Color.Black
            )
        }
}

/**
 * Vista previa del componente [InputDataComponent].
 *
 * Muestra un ejemplo con etiqueta y campo de entrada de usuario
 * para visualizar su diseño dentro del editor.
 *
 * @see InputDataComponent
 */
@Preview
@Composable
fun PreviewInputData(){
    InputDataComponent("User:","INTRODUCE USER")
}